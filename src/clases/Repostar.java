package clases;

import JLISV.LIB;
import clases.enumerados.Semana;

public class Repostar implements Cloneable, Comparable<Repostar>{
    private Semana dia = Semana.lunes;
    private double cantidad = 1;
    private double precio = 0.5;
    //getters
    public Semana getDia() {
        return dia;
    }
    public double getCantidad() {
        return cantidad;
    }
    public double getPrecio() {
        return precio;
    }
    //setters
    public void setDia(Semana dia) {
        this.dia = dia;
    }
    public void setCantidad(double cantidad) {
        if(cantidad <= 1){
            throw new IllegalArgumentException("Cantidad debe ser mayor que 1");
        }
        this.cantidad = cantidad;
    }
    public void setPrecio(double precio) {
        if(precio < 0.5){
            throw new IllegalArgumentException("Precio debe ser mayor que 0,5");
        }
        this.precio = precio;
    }
    //constructores
    public Repostar(Semana dia, double cantidad, double precio){
        setDia(dia);
        setCantidad(cantidad);
        setPrecio(precio);
    }
    public Repostar(double cantidad, Semana dia, double precio){
        this(dia,cantidad,precio);
    }
    public Repostar(double cantidad, double precio, Semana dia){
        this(dia,cantidad,precio);
    }
    //metodos
    public double coste(){
        return precio*cantidad;
    }
    public double coste(int v){
        return LIB.redon(precio*cantidad, v);
    }
    //overrides
    @Override
    public String toString(){
        String s = "Dia: " + this.getDia() +"\n";
        s += "Cantidad: " + this.getCantidad() +"\n";
        s += "Precio" + this.getPrecio() + "\n";
        return s;
    }
    @Override
    public Repostar clone(){
            try{
                return  (Repostar)super.clone();
            }catch(CloneNotSupportedException e){
                e.printStackTrace();
            }
            return null;
        }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dia == null) ? 0 : dia.hashCode());
        long temp;
        temp = Double.doubleToLongBits(cantidad);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(precio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Repostar other = (Repostar) obj;
        if (dia != other.dia)
            return false;
        if (Double.doubleToLongBits(cantidad) != Double.doubleToLongBits(other.cantidad))
            return false;
        if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
            return false;
        return true;
    }
    @Override
    public int compareTo(Repostar o){
        if(this.coste() < o.coste()) return -1;
        if(this.coste() > o.coste()) return 1;
        return 0;
    }
}
