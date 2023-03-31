package clases;

public abstract class Cuadrupedo extends Animal{
    private float altura = 0.1F;

    public Cuadrupedo setAltura(float altura){
        if(altura < 0){
            throw new IllegalArgumentException();
        }
        this.altura = altura;
        return this;
    }

    public float getAltura(){
        return altura;
    }

    protected Cuadrupedo(String nombre, float peso, float altura){
        super(nombre, peso);
        setAltura(altura);
    }
    protected Cuadrupedo(String nombre, float peso){
        super(nombre, peso);
    }
    protected Cuadrupedo(){
        super();
    }
    @Override
    public abstract Cuadrupedo comer(int kg);
    @Override
    public abstract Cuadrupedo comer();
    @Override
    protected int setNumeroDePatas(){
        return 4;
    }
}
