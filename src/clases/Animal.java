package clases;

public abstract class Animal {
    public final int NUMERO_DE_PATAS;
    private String nombre = "Desconocido";
    private float peso = 0.3F;

    public String getNombre(){
        return nombre;
    }
    public float getPeso(){
        return peso;
    }
    public Animal setNombre(String nombre){
        if(!nombre.matches("[A-ZÑ]*")){
            throw new IllegalArgumentException("Nombre en mayusculas");
        }
        this.nombre = nombre;
        return this;
    }
    public Animal setPeso(float peso){
        if(peso < 0){
            throw new IllegalArgumentException("Peso debe ser positivo");
        }
        this.peso = peso;
        return this;
    }
    protected Animal(String nombre, float peso){
        setNombre(nombre);
        setPeso(peso);
        NUMERO_DE_PATAS = setNumeroDePatas();
    }

    protected Animal(float peso, String nombre){
        this(nombre,peso);
    }
    protected Animal(float peso){
        setPeso(peso);
        NUMERO_DE_PATAS = setNumeroDePatas();
    }
    protected Animal(String nombre){
        setNombre(nombre);
        NUMERO_DE_PATAS = setNumeroDePatas();
    }
    protected Animal(){
        NUMERO_DE_PATAS = setNumeroDePatas();
    }
    abstract public Animal comer();
    abstract public Animal comer(int comer);
    abstract protected int setNumeroDePatas();

    @Override
    public String toString(){
        String s = "";
        s += "Numero de patas: " + NUMERO_DE_PATAS + "\n";
        s += "Nombre: " + getNombre() + "\n";
        s += "Peso: " + getPeso() + "\n"; 
        return s;
    }
}
