package clases;

import JLISV.LIB;

public class Consumicion implements Cloneable, Comparable<Consumicion>{
    private Articulos producto = Articulos.caña;
    private double precio = 1.00;
    private int numArticulos = 1;

    public enum Articulos{
        caña,
        refresco,
        pincho,
        tapa,
        bocadillo,
        vino
    }
    //getters
    public Articulos getProducto() {
        return producto;
    }
    public double getPrecio() {
        return precio;
    }
    public int getNumArticulos() {
        return numArticulos;
    }
    //setters
    public Consumicion setProducto(Articulos producto) {
        this.producto = producto;
        return this;
    }
    public Consumicion setPrecio(double precio) {
        this.precio = precio;
        return this;
    }
    public Consumicion setNumArticulos(int numArticulos) {
        if(numArticulos < 0){
            throw new IllegalArgumentException("El numero de articulos debe ser positivo");
        }
        this.numArticulos = numArticulos;
        return this;
    }
    //constructores
    public Consumicion(){};
    public Consumicion(Articulos producto, double precio, int numArticulos) {
        setProducto(producto);
        setPrecio(precio);
        setNumArticulos(numArticulos);
    }
    public Consumicion(double precio, Articulos producto, int numArticulos){
        this(producto, precio, numArticulos);
    }
    public Consumicion(int numArticulos, double precio, Articulos producto){
        this(producto, precio, numArticulos);
    }
    public Consumicion(Articulos producto, int numArticulos, double precio){
        this(producto, precio, numArticulos);
    }
    public Consumicion(Articulos producto, double precio) {
        setProducto(producto);
        setPrecio(precio);
    }
    public Consumicion(double precio, Articulos producto){
        this(producto, precio);
    }   
    public Consumicion(Articulos producto, int numArticulos){
        setProducto(producto);
        setNumArticulos(numArticulos);
    }
    public Consumicion(int numArticulos, Articulos producto){
        this(producto, numArticulos);
    }
    public Consumicion(double precio, int numArticulos){
        setPrecio(precio);
        setNumArticulos(numArticulos);
    }
    public Consumicion(int numArticulos, double precio){
        this(precio, numArticulos);
    }
    //metodos calculo
    public double coste(){
        return LIB.redon(numArticulos*precio, 2);
    }
    //overrides
    @Override
    public String toString(){
        return "Producto " + producto.name() + "\n" +
                "Precio: " + precio + "\n" +
                "Numero de unidades: " + numArticulos + "\n" + 
                "Coste total: " + coste();
    }
    @Override
    public Consumicion clone(){
        try{
            return  (Consumicion)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public int compareTo(Consumicion o){
        if(this.coste() < o.coste())return -1;
        if(this.coste() > o.coste())return 1;
        return 0;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((producto == null) ? 0 : producto.hashCode());
        long temp;
        temp = Double.doubleToLongBits(precio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + numArticulos;
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
        Consumicion other = (Consumicion) obj;
        if (producto != other.producto)
            return false;
        if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
            return false;
        if (numArticulos != other.numArticulos)
            return false;
        return true;
    }
}