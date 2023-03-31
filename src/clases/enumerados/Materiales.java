package clases.enumerados;

public enum Materiales {
    MADERA(0.5,4),
    LATON(1.2,5),
    HIERRO(1.8,7),
    ACERO(2.25,9);
    private double precio = 1;
    private int calidad = 1;

    public double getPrecio(){
        return precio;
    }
    public int getCalidad(){
        return calidad;
    }
    Materiales(double precio, int calidad){
        this.precio = precio;
        this.calidad = calidad;
    }
    Materiales(int calidad, double precio){
        this(precio, calidad);
    }
}
