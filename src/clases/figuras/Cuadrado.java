package clases.figuras;

import java.beans.PropertyVetoException;

import clases.interfaces.Aritmetica;

public class Cuadrado extends Rectangulo implements Aritmetica{
    private boolean girado = false;

    public boolean getGirado(){
        return girado;
    }

    public int getLado(){
        return super.getAlto();
    }

    public Cuadrado setGirado(boolean girado){
        try {
            getCambiandose().fireVetoableChange("girado", this.girado, girado);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        boolean antiguo = this.girado;
        this.girado = girado;
        getCambio().firePropertyChange("girado", antiguo, this.girado);
        return this;
    }

    public Cuadrado setLado(int lado){
        try {
            getCambiandose().fireVetoableChange("lado", super.getAlto(), lado);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        int antiguo = super.getAlto();
        setAlto(lado);
        getCambio().firePropertyChange("lado", antiguo, lado);
        return this; 
    }

    @Override
    public Cuadrado setAncho(int lado){
        super.setAncho(lado);
        if(super.getAncho() != super.getAlto()){
            super.setAlto(lado);
        }
        return this;
    }

    @Override
    public Cuadrado setAlto(int lado){
        super.setAlto(lado);
        if(super.getAlto() != super.getAncho()){
            super.setAncho(lado);
        }
        return this;
    }
    public Cuadrado(){
        super();
    }

    public Cuadrado(int lado){
        setLado(lado);
    }

    public Cuadrado(int lado, boolean girado){
        setLado(lado);
        setGirado(girado);
    }

    public Cuadrado(int lado, char borde, char relleno){
        super(borde, relleno);
        setLado(lado);
    }

    public Cuadrado(Cuadrado cuadrado){
        setGirado(cuadrado.getGirado());
        setLado(cuadrado.getLado());
    }
    
    @Override
    public String dibujar(){
        String s = "";
        if(girado){
            for (int i = 0; i < getLado()*2; i++) {
                for (int j = 0; j < getLado()*2; j++) {
                    if(i < getLado()){
                        if(j == getLado() && i == 0){
                            s += getBorde() + " ";
                        }else if(j == getLado() + i || j == getLado() - i){
                            s += getBorde() + " ";
                        }else if(j < getLado() + i && j > getLado() - i){
                            s+= getRelleno() + " ";
                        }else{
                            s += " " + " ";
                        }
                    }else{
                        if(i > getLado()){
                            if(j == getLado() - (getLado()*2 -1- i) || j == getLado() + (getLado()*2 -1-i)){
                               s += getBorde() + " ";
                            }else if(j > getLado() - (getLado()*2 -1- i) && j < getLado() + (getLado()*2 -1- i)){
                               s += getRelleno() + " ";
                            }else{
                               s += " " + " ";
                            }
                        }
                    }
                }
                if(i != getLado()){
                    s+= "\n";
                }
            }
        }else{
            s += super.dibujar();
        }
        return s;
    }

    @Override
    public String dimension(){
        return getLado() + " X " + getLado();
    }

    @Override
    public String toString(){
        String s = "";
        s += super.toString();
        s+= "GIRADO: " + getGirado();
        return s;
    }

    @Override
    public int compareTo(Rectangulo o) {
        if(o instanceof Cuadrado){
            Cuadrado c = (Cuadrado) o;
            if(this.getLado() < c.getLado())return -1;
            if(this.getLado() > c.getLado()) return 1;
            return 0;
        }
        return super.compareTo(o);
    }

    @Override
    public Cuadrado sumar(Object o) {
        if(!(o instanceof Cuadrado)){
            throw new IllegalArgumentException("el parametro no es de tipo cuadrado");
        }
        Cuadrado c = (Cuadrado) o;
        this.setLado(this.getLado() + c.getLado());
        return this;
    }

    @Override
    public Cuadrado restar(Object o) {
        if(!(o instanceof Cuadrado)){
            throw new IllegalArgumentException("el parametro no es de tipo cuadrado");
        }
        Cuadrado c = (Cuadrado) o;
        if(this.getLado() - c.getLado() < 2){
            this.setLado(2);
        }else{
            this.setLado(this.getLado() - c.getLado());
        }
        return this;
    }

    @Override
    public Cuadrado multiplicar(Object valor) {
        if(!(valor instanceof Cuadrado)){
            throw new IllegalArgumentException("el parametro no es de tipo cuadrado");
        }
        Cuadrado c = (Cuadrado) valor;
        this.setLado(this.getLado()*c.getLado());
        return this;
    }
}
