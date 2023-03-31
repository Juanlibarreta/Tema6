package clases.figuras;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.util.Comparator;

import JLISV.LIB;
import clases.interfaces.Acumulable;

public class Rectangulo implements Cloneable, Comparable<Rectangulo>, Acumulable{
    private int ancho = 2;
    private int alto = 2;
    private char borde = '*';
    private char relleno = '+';
    public final int ANCHO_INICIAL;
    public final int ALTO_INICIAL;
    private final PropertyChangeSupport cambio = new PropertyChangeSupport(this);
    private final VetoableChangeSupport cambiandose = new VetoableChangeSupport(this);
    public static class FueraDeRangoException extends RuntimeException{
        public FueraDeRangoException(String s){
            super(s);
        }
    }
    final public static Comparator<Rectangulo> PERIMETRO = new Comparator<Rectangulo>() {
        @Override
        public int compare(Rectangulo a, Rectangulo b) {
            if(a.perimetro() < b.perimetro())return -1;
            if(a.perimetro() > b.perimetro()) return 1;
            return 0;
        }
    };

    //getters
    public int getAncho(){
        return ancho;
    }
    public int getAlto(){
        return alto;
    }
    public char getBorde(){
        return borde;
    }
    public char getRelleno(){
        return relleno;
    }
    public PropertyChangeSupport getCambio(){
        return cambio;
    }
    public VetoableChangeSupport getCambiandose(){
        return cambiandose;
    }
    //setters
    public Rectangulo setAncho(int v){
        if(v < 2){
            throw new Rectangulo.FueraDeRangoException("Ancho debe ser mayor que 1");
        }
        int anchoAntiguo = this.ancho;
        this.ancho = v;
        cambio.firePropertyChange("cambio", anchoAntiguo, this.ancho);
        return this;
    }
    public Rectangulo setAlto(int v){
        if(v < 2){
            throw new Rectangulo.FueraDeRangoException("Alto debe ser mayor que 1");
        }
        int altoAntiguo = this.alto;
        this.alto = v;
        cambio.firePropertyChange("cambio", altoAntiguo, this.alto);
        return this;
    }
    public Rectangulo setBorde(char v){
        if(v != '*' && v != '+' && v != '-'){
            throw new Rectangulo.FueraDeRangoException("Borde debe ser '*', '+' o '-'");
        }
        this.borde = v;
        return this;
    }
    public Rectangulo setRelleno(char v){
        if(v != '*' && v != '+' && v != '-' && v != ' '){
            throw new Rectangulo.FueraDeRangoException("Relleno debe ser '*', '+', '-' o ' '");
        }
        this.relleno = v;
        return this;
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        cambio.addPropertyChangeListener(listener);
    }
   public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        cambio.addPropertyChangeListener(propertyName, listener);
    }
    public void vetoableChangeListener(VetoableChangeListener listener){
        cambiandose.addVetoableChangeListener(listener);
    }
    public void vetoableChangeListener(String propertyName,VetoableChangeListener listener){
        cambiandose.addVetoableChangeListener(propertyName, listener);
    }
    //constructores
    public Rectangulo(int ancho, int alto, char borde, char relleno){
        setAncho(ancho);
        setAlto(alto);
        setBorde(borde);
        setRelleno(relleno);
        ALTO_INICIAL = getAlto();
        ANCHO_INICIAL = getAncho();
    }
    public Rectangulo(int ancho, int alto){
        setAlto(alto);
        setAncho(ancho);
        ALTO_INICIAL = getAlto();
        ANCHO_INICIAL = getAncho();
    }
    public Rectangulo(char borde, char relleno){
        setBorde(borde);
        setRelleno(relleno);
        ALTO_INICIAL = getAlto();
        ANCHO_INICIAL = getAncho();
    }
    public Rectangulo(int ancho, char borde, char relleno){
        setAncho(ancho);
        setBorde(borde);
        setRelleno(relleno);
        ALTO_INICIAL = getAlto();
        ANCHO_INICIAL = getAncho();
    }
    public Rectangulo(int alto, int ancho, char borde){
        setAlto(alto);
        setAncho(ancho);
        setBorde(borde);
        ALTO_INICIAL = getAlto();
        ANCHO_INICIAL = getAncho();
    }
    //this
    public Rectangulo(int ancho, char borde, int altura){
        this(altura, ancho, borde);
    }
    public Rectangulo(char borde, int ancho, int altura){
        this(altura, ancho, borde);
    }
    public Rectangulo(char borde,int ancho, char relleno){
        this(ancho, borde, relleno);
    }
    public Rectangulo(char borde, char relleno, int ancho){
        this(ancho, borde,relleno);
    }
    //constructor default
    public Rectangulo(){
        ALTO_INICIAL = getAlto();
        ANCHO_INICIAL = getAncho();
    }
    //Método fabricacion
    public static Rectangulo sumar(Rectangulo a,Rectangulo b){
        if(a == null || b == null){
            return null;
        }
        int ancho = a.getAncho() + b.getAncho();
        int alto = a.getAlto() + b.getAlto();
        return new Rectangulo(ancho, alto, '+',' ');
    }
    //metodo calculo
    public int area(){
        return ancho*alto;
    }
    public int perimetro(){
        return ancho*2 + alto*2;
    }
    public double diagonal(){
        return Math.sqrt(ancho*ancho + alto*alto);
    }
    public double diagonal(int n){
        if(n < 0){
            n *= -1;
        }
        return LIB.redon(diagonal(), n);
    }
    //metodos consulta
    public boolean esCuadrado(){
        return ancho == alto;
    }
    //cambio de estado
    public Rectangulo plus(){
        setAlto(alto+1);
        setAncho(ancho+1);
        return this;
    }
    public Rectangulo invertir(){
        int aux = ancho;
        setAncho(alto);
        setAlto(aux);
        return this;
    }
    public Rectangulo restaurar(){
        setAlto(ALTO_INICIAL);
        setAncho(ANCHO_INICIAL);
        return this;
    }
    //conversion cadenas
    public String dibujar(){
        String s = "";
        for(int i = 0; i < alto;i++){
            for(int j = 0; j < ancho;j++){
                if(i == 0 || i == alto-1){
                    s += borde + " ";
                }else if(j == 0 || j == ancho - 1){
                    s += borde + " ";
                }else{
                    s += relleno + " ";
                }
            }
            s += "\n";
        }
        return s;
    }
    public String dibujar(String nombre){
        return nombre + dibujar();
    }
    public String dimension(){
        return getAncho() + " X " + getAlto();
    }
   //overrides
    @Override
    public String toString(){
        return "ANCHO: " + getAncho() + "\n" +
                "ALTO: " + getAlto() + "\n" +
                "BORDE: " + getBorde() + "\n" +
                "RELLENO: " + getRelleno() + "\n";
    }
    @Override
    public Rectangulo clone(){
        try{
            return  (Rectangulo)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ancho;
        result = prime * result + alto;
        result = prime * result + borde;
        result = prime * result + relleno;
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
        Rectangulo other = (Rectangulo) obj;
        if (ancho != other.ancho)
            return false;
        if (alto != other.alto)
            return false;
        if (borde != other.borde)
            return false;
        if (relleno != other.relleno)
            return false;
        return true;
    }
    @Override
    public int compareTo(Rectangulo o){
        if(this.area() < o.area())return -1;
        if(this.area() > o.area())return 1;
        return 0;
    }
    @Override
    public Rectangulo acumular() {
        return plus();
    }
    @Override
    public Rectangulo acumular(Object valor) {
        if(!(valor instanceof Rectangulo)){
            throw new IllegalArgumentException("No es un rectangulo");
        }
        Rectangulo r = (Rectangulo) valor;
        this.setAlto(r.getAlto()+this.getAlto());
        this.setAncho(r.getAncho()+this.getAncho());
        return this;
    }
    @Override
    public boolean esNulo() {
        return getAlto() == 2 && getAncho() == 2;
    }
}

