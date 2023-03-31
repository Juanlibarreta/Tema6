package clases;

public class Perro extends Cuadrupedo{
    public static final float INCREMENTO_PESO_POR_KILO;
    static{
        INCREMENTO_PESO_POR_KILO = 0.1F;
    }
    public int getPesoEnGramos(){
        return (int) getPeso()*1000;
    }
    public Perro(float peso, String nombre){
        super(nombre, peso);
    }
    public Perro(String nombre, float peso){
        this(peso, nombre);
    }
    @Override
    public Perro comer(int kg) {
        if(kg < 0){
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        setPeso(getPeso() + INCREMENTO_PESO_POR_KILO*kg);
        return this;
    }
    @Override
    public Perro comer() {
        comer(1);
        return this;
    }
}
