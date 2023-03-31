package clases;
public class Mascota implements Cloneable, Comparable<Mascota>{
    private String nombre = "";
    private Animal animal = Animal.perro;

    public enum Animal{
        perro,
        gato,
        tortuga,
        hamster,
        pajaro,
        pez
    }
    //getters
    public String getNombre(){
        return nombre;
    }
    public Animal getAnimal(){
        return animal;
    }
    //setters
    public Mascota setAnimal(Animal animal){
        this.animal = animal;
        return this;
    }
    public Mascota setNombre(String nombre){
        if(!nombre.matches("[A-ZÑ]*[a-zñ]+") && !nombre.matches("")){
            throw new IllegalArgumentException("Una palabra en minusculas o cadena vacia");
        }
        this.nombre = nombre;
        return this;
    }
    //constructor
    public Mascota(String nombre, Animal animal){
        this.setNombre(nombre);
        this.setAnimal(animal);
    }
    public Mascota(String nombre){
        this.setNombre(nombre);
    }
    public Mascota(Animal animal){
        this.setAnimal(animal);
    }
    public Mascota(Mascota mascota){
        this.setAnimal(mascota.getAnimal());
        this.setNombre(mascota.getNombre());
    }
    //to String
    public String toString(){
        return "Animal: " + getAnimal() + "\n" +
                "Nombre: " + nombre;
    }
    //overrides
    @Override
    public Mascota clone(){
        try{
            return  (Mascota)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public int compareTo(Mascota o){
        if(this.getNombre().compareTo(o.getNombre()) < 0) return -1;
        if(this.getNombre().compareTo(o.getNombre()) > 0) return 1;
        return 0;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mascota other = (Mascota) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    } 
}
