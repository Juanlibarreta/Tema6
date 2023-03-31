package clases;


public class ClienteBar implements Cloneable, Comparable<ClienteBar>{
    private String nombre = "";
    private Consumicion c = null;
    //getter
    public String getNombre() {
        return nombre;
    }
    public Consumicion getConsumicion() {
        return c;
    }
    //setters
    public ClienteBar setNombre(String nombre) {
        if(!nombre.matches("|[A-ZÑ][a-zñáéíóúü]*")){
            throw new IllegalArgumentException("Nombre primera mayuscula y resto minuscula");
        }
        this.nombre = nombre;
        return this;
    }
    public ClienteBar setConsumicion(Consumicion c) {
        this.c = c;
        return this;
    }
    //constructor
    public ClienteBar(String nombre, Consumicion c){
        setNombre(nombre);
        setConsumicion(c);
    }
    public ClienteBar(Consumicion c, String nombre){
        this(nombre, c);
    }
    public ClienteBar(Consumicion c){
        setConsumicion(c);
    }
    public ClienteBar(String nombre){
        setNombre(nombre);
    }
    public ClienteBar(){

    }
    //calculo
    public String informe(){
        String x = String.format("%-20s ", nombre);
        x += String.format("%-10s" + " %8d" + " %6.2f" + " %8.2f",
         c.getProducto(), c.getNumArticulos(), c.getPrecio(), c.coste());
        return x;
    }
    //Overrides
    @Override
    public String toString(){
        String v = "Nombre: " +nombre;
        if(c != null){
            v +="\n" + c.toString();
        }
        return v;
    }
    @Override
    public ClienteBar clone(){
        try {
            ClienteBar cliente = (ClienteBar) super.clone();
            if(cliente.getConsumicion() != null){
                cliente.setConsumicion(getConsumicion().clone());
            }
            return cliente;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((c == null) ? 0 : c.hashCode());
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
        ClienteBar other = (ClienteBar) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (c == null) {
            if (other.c != null)
                return false;
        } else if (!c.equals(other.c))
            return false;
        return true;
    }
    @Override
    public int compareTo(ClienteBar o){
        if(this.getNombre().compareTo(o.getNombre()) < 0) return -1;
        if(this.getNombre().compareTo(o.getNombre()) > 0) return 1;
        return 0;
    }
}
