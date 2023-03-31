package clases.figuras;

import clases.interfaces.Acumulable;
import clases.util.Excepciones;

public abstract class Figura implements Acumulable, Comparable<Figura>{
    public final int VERTICES;

    protected int setVertices(int v){
        if(v < 3){
            new Excepciones().VerticesInvalidosException("El numero de vertices debe ser superior a 2");
        }
        return v;
    }
    protected Figura(int vertice){
        VERTICES = setVertices(vertice);
    }
    public abstract int perimetro(int j);
    public abstract int area();
    @Override
    public abstract Figura acumular();
    @Override
    public abstract Figura acumular(Object valor);
    @Override
    public abstract boolean esNulo();
    @Override
    public abstract int compareTo(Figura o);
    @Override
    public String toString(){
        return "Nº de vertices: " + VERTICES;
    }
}
