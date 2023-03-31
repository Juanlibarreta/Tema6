package clases;

import java.math.BigDecimal;

import JLISV.LIB;

public class Rebajas implements Cloneable, Comparable<Rebajas>{
    private double precio = 1;
    private int porcentaje = 10;
    //getter
    public double getPrecio() {
        return precio;
    }
    public int getPorcentaje() {
        return porcentaje;
    }
    //setters
    public void setPrecio(double v) {
        if(v < 0){
            throw new IllegalArgumentException("Debe ser positivo");
        }
        if(new BigDecimal(String.valueOf(v)).scale() > 2){
            throw new IllegalArgumentException("Debe tener maximo 2 decimales");
        }
        this.precio = v;
    }
    public void setPorcentaje(int v) {
        if(v < 10 || v > 80){
            throw new IllegalArgumentException("Debe ser entre 10 y 80");
        }
        this.porcentaje = v;
    }
    //contructores
    public Rebajas(){
    }
    public Rebajas(double precio, int porcentaje){
        setPrecio(precio);
        setPorcentaje(porcentaje);
    }
    public Rebajas(double precio){
        setPrecio(precio);
    }
    public Rebajas(int porcentaje){
        setPorcentaje(porcentaje);
    }
    //metodos calculos
    public double precioInicial(){
        double inicial = precio/((100-porcentaje)/100.0);
        inicial = LIB.redon(inicial, 2);
        return inicial;
    }

    //override
     @Override
    public Rebajas clone(){
        try{
            return  (Rebajas)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(precio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + porcentaje;
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
        Rebajas other = (Rebajas) obj;
        if (Double.doubleToLongBits(precio) != Double.doubleToLongBits(other.precio))
            return false;
        if (porcentaje != other.porcentaje)
            return false;
        return true;
    }
    @Override
    public int compareTo(Rebajas o){
        if(this.getPorcentaje() < o.getPorcentaje()) return -1;
        if(this.getPorcentaje() > o.getPorcentaje()) return 1;
        return 0;
    }
}
