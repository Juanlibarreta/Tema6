package clases.interfaces.genericas;

import java.util.Comparator;

public class Vector<T> {
    private T[] elementos = null;
    final public Class clase;
    
    
    private T[] getElementos() {
        return elementos;
    }

    public Vector setElementos(T[] elementos){
        this.elementos = elementos;
        return this;
    }
    public Vector(){
        setElementos((T[]) new Object[0]);
        clase = elementos.getClass();
    }
    
    public int size(){
        return elementos.length;
    }

    public boolean isEmpty(){
        return elementos.length == 0;
    }

    public T getElemento(int i){
        if(i < 0 || elementos.length == 0 || elementos == null || i >= size()){
            return null;
        }
        return elementos[i];
    }

    public T getUltimo(){
        if(elementos == null){
            return null;
        }
        return elementos[size()-1];
    }

    public T GetPrimero(){
        if(elementos == null){
            return null;
        }
        return elementos[0];
    }

    public Vector add(int posi, T elemento){
        if(posi != 0 || posi > size()-1 || elemento == null){
            throw new IllegalArgumentException("Posicion invalida o elemento null");
        }
        this.elementos[posi] = elemento;
        return this;
    }

    public Vector add(T elemento){
        return add(size()-1,elemento);
    }

    public Vector remove(int posi){
        if(posi >= 0 && posi < size()){
            elementos[posi] = null;
        }
        return this;
    }

    public Vector removeFirst(T elemento){
        for (int i = 0; i < size(); i++) {
            if(getElementos()[i] == elemento){
                this.elementos[i] = null;
                return this;
            }
        }
        return this;
    }

    public Vector removeLast(T elemento){
        for (int i = size()-1; i >= 0; i--) {
            if(getElementos()[i] == elemento){
                this.elementos[i] = null;
                return this;
            }
        }
        return this;
    }

    public Vector removeAll(T elemento){
        for (int i = 0; i < size(); i++) {
            if(getElementos()[i] == elemento){
                this.elementos[i] = null;
            }
        }
        return this;
    }

    public Vector ordenar(Comparator<T> comp){
        return this;
    }
}
