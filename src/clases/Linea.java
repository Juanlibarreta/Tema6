package clases;

public class Linea implements Cloneable{
    private String nombre = "";
    private double precio = 0.0;
    private int cantidad = 0;

    public String getNombre(){
        return nombre;
    }
    public double getPrecio(){
        return precio;
    }
    public int getCantidad(){
        return cantidad;
    }

    public void setNombre(String nombre){
        if(!nombre.matches("[a-zñ]{,20}")){
            throw new IllegalArgumentException("Nombre debe ser tamaño maximo 20");
        }
        this.nombre = nombre;
    }
    public void setPrecio(double precio){
        if(precio < 0.0 || precio > 500.00){
            throw new IllegalArgumentException("Precio mayor que 0 y menor que 500.00");
        }
        this.precio = precio;
    }
    public void setCantidad(int cantidad){
        if(cantidad < 0 || cantidad > 10){
            throw new IllegalArgumentException("Cantidad entr 0 y 10");
        }
        this.cantidad = cantidad;
    }
    @Override
    public Linea clone(){
        try{
            return  (Linea) super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
}
