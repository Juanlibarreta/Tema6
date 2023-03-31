package clases;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.math.*;
import java.util.ArrayList;
import java.util.Comparator;

import JLISV.LIB;
import clases.figuras.Rectangulo;
import clases.interfaces.Alimentarse;
import clases.interfaces.Carrera;
import clases.interfaces.ICoche;
import clases.util.Excepciones;

public class Persona implements Cloneable, Comparable<Persona>, AutoCloseable, Comparator<Persona>, Alimentarse,Carrera, ICoche{
    private int edad = 0;
    private double altura = 0.5;
    private double peso = 2.5;
    public final String NOMBRE;
    public final int EDAD_INICIAL;
    private Mascota mascota = null;
    private Rectangulo r = new Rectangulo();
    private int cuentas[] = new int[10];
    private ArrayList<Double> cuenta = new ArrayList<>();
    private ArrayList<Consumicion> cons = new ArrayList<>();
    private final Consumicion consumicion = new Consumicion();
    public static final int esperanza_mujer;
    public static final int esperanza_hombre;
    private static int creados;
    private static int totalEdad;
    private final PropertyChangeSupport cambiado = new PropertyChangeSupport(this);
    private final VetoableChangeSupport cambiar = new VetoableChangeSupport(this);
    private ICoche coche;
    public static class NombreInvalidoException extends RuntimeException{
        public NombreInvalidoException(String s){
            super(s);
        }
    }
    public static class EdadFueraDeRangoException extends RuntimeException{
        public EdadFueraDeRangoException(String s){
            super(s);
        }
    }
    public static class AlturaFueraDeRangoException extends RuntimeException{
        public AlturaFueraDeRangoException(String s){
            super(s);
        }
    }
    public static class PesoFueraDeRangoException extends RuntimeException{
        public PesoFueraDeRangoException(String s){
            super(s);
        }
    }
    public static final Comparator<Persona> PESO = (a,b)->{
        if(a.getPeso()<b.getPeso())return -1;
        if(a.getPeso()>b.getPeso())return 1;
        return 0;
    };
    public static final Comparator<Persona> ALTURA = new Comparator<>(){
        @Override
        public int compare(Persona a, Persona b){
            if(a.getAltura() < b.getAltura()) return -1;
            if(a.getAltura() > b.getAltura()) return 1;
            return 0;
        }
    }; 
    static public final Comparator<Persona> NOMBRE_EDAD = new Comparator<>(){
        @Override
        public int compare(Persona a, Persona b){
            if(a.NOMBRE.compareTo(b.NOMBRE) < 0) return -1;
            if(a.NOMBRE.compareTo(b.NOMBRE) > 0) return 1;
            if(a.getAltura() < b.getAltura()) return -1;
            if(a.getAltura() > b.getAltura()) return 1;
            return 0;
        }
    };
    
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        cambiado.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        cambiado.addPropertyChangeListener(propertyName, listener);
    }

    public void vetoableChangeListener(VetoableChangeListener listener){
        cambiar.addVetoableChangeListener(listener);
    }
    public void vetoableChangeListener(String propertyName,VetoableChangeListener listener){
        cambiar.addVetoableChangeListener(propertyName, listener);
    }

    public void setPrecio(double precio) {
        consumicion.setPrecio(precio);
    }

    public void setNumArticulos(int numArticulos) {
        consumicion.setNumArticulos(numArticulos);
    }

    public void setAncho(int v) {
        r.setAncho(v);
    }

    public void setAlto(int v) {
        r.setAlto(v);
    }

    public String dibujar() {
        return r.dibujar();
    }

    static{
        esperanza_mujer = 90;
        esperanza_hombre = 85;
    }
    /** 
     * @return int
     */
    //getters
    public int getEdad(){
        return edad;
    }
    
    /** 
     * @return double
     */
    public double getAltura(){
        return altura;
    }
    
    /** 
     * @return double
     */
    public double getPeso(){
        return peso;
    }

    
    /** 
     * @return Mascota
     */
    public Mascota getMascota(){
        return mascota;
    }

    
    /** 
     * @return int[]
     */
    private int[] getCuentas() {
        return cuentas.clone();
    }

    
    /** 
     * @param index
     * @return int
     */
    public int getCuentas(int index){
        return getCuentas()[index];
    }

    
    /** 
     * @return ArrayList<Double>
     */
    public ArrayList<Double> getCuenta(){
        return cuenta;
    }

    
    /** 
     * @param i
     * @return double
     */
    public double getCuenta(int i){
        return cuenta.get(i);
    }

    
    /** 
     * @return ArrayList<Consumicion>
     */
    public ArrayList<Consumicion> getConsumicion(){
        return cons;
    }

    
    /** 
     * @return int
     */
    public static int getCreados() {
        return creados;
    }

    
    /** 
     * @return int
     */
    public static int getTotalEdad() {
        return totalEdad;
    }

    public PropertyChangeSupport getCambiado(){
        return cambiado;
    }

    public VetoableChangeSupport getCambiar(){
        return cambiar;
    }
    
    /** 
     * @param v
     * @return Persona
     */
    public Persona setEdad(int v){
        if(v < 0 || v >120){
            new Excepciones().valorNegativoException("Edad fuera de rango");
        }
        setTotalEdad(getTotalEdad() - getEdad());
        int edadAntigua = edad;
        edad = v;
        setTotalEdad(getTotalEdad() + v);
        cambiado.firePropertyChange("edad", edadAntigua, edad);
        return this;
    }
    
    /** 
     * @param v
     * @return Persona
     */
    public Persona setAltura(double v){
        if(v < 0.3 || v > 2.2){
            throw new AlturaFueraDeRangoException("Altura entre 0.3 y 2.2");
        }
        if(new BigDecimal(String.valueOf(v)).scale() > 2){
            new Excepciones().numeroInvalidoDeDecimalesException("Maximo 2 decimales");
        }
        double alturaAntigua = altura;
        altura = v;
        cambiado.firePropertyChange("Altura", alturaAntigua, altura);
        return this;
    }
    
    /** 
     * @param v
     * @return Persona
     */
    public Persona setPeso(double v){
        if(v < 1.7 || v > 140){
            throw new PesoFueraDeRangoException("Peso entre 1.7 y 140");
        }
        /* 
        if(new BigDecimal(String.valueOf(v)).scale() > 1){
            new Excepciones().numeroInvalidoDeDecimalesException("Peso debe tener 1 decimal maximo");
        }
        */
        peso = v;
        return this;
    }
    
    /** 
     * @param v
     * @return String
     */
    private String setNOMBRE(String v){
        if(!v.matches("[A-ZÑÁÉÍÓÚÜ]+")){
            throw new NombreInvalidoException("Nombre debe ser primera en mayuscula, resto en minusculas");
        }
        return v;
    }

    
    /** 
     * @param v
     * @return Persona
     */
    public Persona setMascota(Mascota v){
        mascota = v;
        return this;
    }
    
    /** 
     * @param v
     * @return Persona
     */
    public Persona setCuentas(int[] v){
        if(v == null){
            this.cuentas = new int[10];
        }
        if(v.length != 10){
            throw new IllegalArgumentException("No tiene 10 cuentas");
        }
        for (int i : v) {
            if(i < 0){
                throw new IllegalArgumentException("La cuenta no puede ser negativa");
            }
        }
        this.cuentas = v.clone();
        return this;
    }
    
    /** 
     * @param index
     * @param cuenta
     * @return Persona
     */
    public Persona setCuentas(int index, int cuenta){
        if(index < 0 || index >= this.cuentas.length){
            throw new IllegalArgumentException("Index fuera de rango");
        }
        if(cuenta < 0){
            throw new IllegalArgumentException("Cuentas debe ser positivo");
        }
        this.cuentas[index] = cuenta;
        return this;
    }
    
    /** 
     * @param cuenta
     * @return Persona
     */
    public Persona setCuenta(ArrayList<Double> cuenta){
        if(cuenta == null){
            cuenta = new ArrayList<>();
        }
        this.cuenta = cuenta;
        return this;
    }
    
    /** 
     * @param i
     * @param v
     * @return Persona
     */
    public Persona setCuenta(int i, double v){
        cuenta.set(i,v);
        return this;
    }
    
    /** 
     * @param cons
     * @return Persona
     */
    public Persona setConsumicion(ArrayList<Consumicion> cons){
        if(cons == null){
            cons = new ArrayList<>();
        }
        this.cons = cons;
        return this;
    }
    
    /** 
     * @param creados
     */
    private static void setCreados(int creados) {
        Persona.creados = creados;
    }
    
    /** 
     * @param totalEdad
     */
    private static void setTotalEdad(int totalEdad) {
        if(totalEdad < 0){
            throw new IllegalArgumentException("No puedes restar edad");
        }
        Persona.totalEdad = totalEdad;
    }
    //constructores
    public Persona(String nombre, int edad, double altura, double peso){
        NOMBRE = setNOMBRE(nombre);
        setTotalEdad(getTotalEdad() + edad);
        setEdad(edad);
        setAltura(altura);
        setPeso(peso);
        EDAD_INICIAL = getEdad();
        setCreados(creados+1);
    }
    public Persona(String nombre){
        NOMBRE = setNOMBRE(nombre);
        EDAD_INICIAL = getEdad();
        setCreados(creados+1);
    }
    public Persona(String nombre, int edad){
        NOMBRE = setNOMBRE(nombre);
        setEdad(edad);
        EDAD_INICIAL = getEdad();
        setCreados(creados+1);
    }
    public Persona(String nombre, double altura){
        NOMBRE = setNOMBRE(nombre);
        setAltura(altura);
        EDAD_INICIAL = getEdad();
        setCreados(creados+1);
    }
    public Persona(String nombre, int edad, double peso){
        NOMBRE = setNOMBRE(nombre);
        setEdad(edad);
        setPeso(peso);
        EDAD_INICIAL = getEdad();
        setCreados(creados+1);
    }
    public Persona(String nombre, Mascota mascota){
        NOMBRE = setNOMBRE(nombre);
        setMascota(mascota);
        EDAD_INICIAL = getEdad();
        setCreados(creados+1);
    }
    public Persona(int[] cuentas){
        NOMBRE = "Desconocido";
        EDAD_INICIAL = getEdad();
        setCuentas(cuentas);
        setCreados(creados+1);
    }
    //this
    public Persona(double peso, String nombre, int edad){
        this(nombre, edad, peso);
    }
    public Persona(int edad, double peso, String nombre){
        this(nombre, edad, peso);
    }
    //copia
    public Persona(Persona p){
        setEdad(p.getEdad());
        setAltura(p.getAltura());
        setPeso(p.getPeso());
        setMascota(p.getMascota());
        setCuentas(p.getCuentas().clone());
        NOMBRE = setNOMBRE(p.NOMBRE);
        EDAD_INICIAL = p.EDAD_INICIAL;
    }
    //constructores default
    public Persona(){
        NOMBRE = "Desconocido";
        EDAD_INICIAL = getEdad();
    }
    
    /** 
     * @return double
     */
    //metodos calculo
    public double imc(){
        double im = peso/Math.pow(altura, 2);
        im = LIB.redon(im, 1);
        return im;
    }
    
    /** 
     * @return int
     */
    public int lengthCuentas(){
        return getCuentas().length;
    }
    
    /** 
     * @return int
     */
    public int lengthCuenta(){
        return cuenta.size();
    }
    
    /** 
     * @param v
     */
    public void addCuenta(double v){
        cuenta.add(v);
    }
    
    /** 
     * @param i
     */
    public void remove(int i){
        cuenta.remove(i);
    }
    
    /** 
     * @param v
     */
    public void remove(Double v){
        cuenta.remove(v);
    }
    
    /** 
     * @return boolean
     */
    //metodos consultas
    public boolean serInfantil(){
        return (edad >= 0 && edad <= 6);
    }
    
    /** 
     * @return boolean
     */
    public boolean serNino(){
        return (edad >= 7 && edad <= 11);
    }
    
    /** 
     * @return boolean
     */
    public boolean serAdolescente(){
        return (edad >= 12 && edad <= 18);
    }
    
    /** 
     * @return boolean
     */
    public boolean serJoven(){
        return (edad >= 19 && edad <= 25);
    }
    
    /** 
     * @return boolean
     */
    public boolean serAdulto(){
        return (edad >= 26 && edad <= 64);
    }
    
    /** 
     * @return boolean
     */
    public boolean serAnciano(){
        return (edad >= 26 && edad <= 64);
    }
    
    /** 
     * @return Persona
     */
    //cambios de estado
    public Persona cumplir(){
        setEdad(edad+1);
        return this;
    }
    
    /** 
     * @param v
     * @return Persona
     */
    public Persona engordar(double v){
        if(v < 0){
            throw new IllegalArgumentException("Peso a engordar debe ser positivo");
        }
        setPeso(peso + v);
        return this;
    }
    
    /** 
     * @return Persona
     */
    public Persona engordar(){
        engordar(1);
        return this;
    }
    
    /** 
     * @param v
     * @return Persona
     */
    public Persona adelgazar(double v){
        if(v < 0){
            throw new IllegalArgumentException("Peso a adelgazar debe ser positivo");
        }
        setPeso(peso - v);
        return this;
    }
    
    /** 
     * @return Persona
     */
    public Persona adelgazar(){
        adelgazar(1);
        return this;
    }
    
    /** 
     * @return String
     */
    //conversion cadena
    @Override
    public String toString(){
        String s = "Nombre: " + NOMBRE + "\n" +
            "Edad: " + getEdad() + "\n" +
            "Altura: " + getAltura() + "\n" +
            "Peso " + getPeso() + "\n";
            for (int i = 0; i < cuentas.length; i++) {
                s += "Cuenta " + (i+1) + ": " + cuentas[i] + " "; 
            }
        if(getCoche() != null) s +="Coche: " + coche.toString() + "\n";
        if(mascota != null) s += "Nombre mascota: " + getMascota().getNombre() + "\n" +
                                "Tipo: " + getMascota().getAnimal().name() +"\n";
        return s;
    }
    
    /** 
     * @return Persona
     */
    //overrrides
    @Override
    public Persona clone(){
        try{
            Persona p = (Persona) super.clone();
            if(getMascota() != null){
                p.setMascota(getMascota().clone());
            }
            p.setCuenta((ArrayList<Double>) getCuenta().clone());
            p.setCuentas(getCuentas().clone());
            ArrayList<Consumicion> con = (ArrayList<Consumicion>) cons.clone();
            for (int i = 0; i < con.size(); i++) {
                if(con.get(i) != null){
                    con.set(i, con.get(i).clone());
                }
            }
            p.setConsumicion(con);
            setCreados(getCreados()+1);
            setTotalEdad(getTotalEdad() + edad);
            return  p;
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + edad;
        long temp;
        temp = Double.doubleToLongBits(altura);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(peso);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((NOMBRE == null) ? 0 : NOMBRE.hashCode());
        return result;
    }
    
    /** 
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (edad != other.edad)
            return false;
        if (Double.doubleToLongBits(altura) != Double.doubleToLongBits(other.altura))
            return false;
        if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
            return false;
        if (NOMBRE == null) {
            if (other.NOMBRE != null)
                return false;
        } else if (!NOMBRE.equals(other.NOMBRE))
            return false;
        return true;
    }
    
    /** 
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Persona o){
       if(this.NOMBRE.compareTo(o.NOMBRE) < 0) return -1;
       if(this.NOMBRE.compareTo(o.NOMBRE) > 0) return 1;
        return 0;
    }
    
    /** 
     * @param a
     * @param b
     * @return int
     */
    @Override
    public int compare(Persona a, Persona b) {
        if(a == null && b == null) return 0;
        if(a == null) return 1;
        if(b == null) return -1;
        if(a.getEdad() < b.getEdad()) return -1;
        if(a.getEdad() > b.getEdad()) return 1;
        return 0;
    }
    
    /** 
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        System.out.println("Me he cerrado");
        setCreados(getCreados() - 1);
        setTotalEdad(getTotalEdad() - getEdad());
    }
    
    @Override
    public Persona correr(float km){
        if(km <= 0){
            new Excepciones().valorNegativoException("Los km no deben ser negativos o cero");
        }
        float recorrido = km * 0.05F;
        setPeso(getPeso() - recorrido);
        return this;
    }

    @Override
    public Persona correr(){
        correr(1);
        return this;
    }

    @Override
    public Persona comer(float kg){
        if(kg <= 0){
            new Excepciones().valorNegativoException("No puede ser negativo o cero");
        }
        float engordar = kg * 0.3F;
        setPeso(getPeso() + engordar);
        return this;
    }

    @Override
    public Persona comer(){
        comer(1);
        return this;
    }

    @Override
    public Persona beber(float kg){
        if(kg <= 0){
            new Excepciones().valorNegativoException("No puede ser negativo o cero");
        }
        float bebe = kg * 0.1F;
        setPeso(getPeso()+bebe);
        return this;
    }

    @Override
    public Persona beber(){
        beber(1);
        return this;
    }

    public ICoche getCoche(){
        return (ICoche) coche.clone();
    }

    public Persona setCoche(ICoche coche){
        if(coche == null)this.coche = null;
        else this.coche = (ICoche) coche.clone();
        return this;
    }

    @Override
    public String getMatricula() {
       return this.coche.getMatricula();
    }

    @Override
    public Persona setMatricula(String s) {
        this.coche.setMatricula(s);
        return this;
    }

    @Override
    public Colores getColor() {
        return this.coche.getColor();
    }

    @Override
    public Persona setColor(Colores color) {
        this.coche.setColor(color);
        return this;
    }

    @Override
    public double getVelocidad() {
        return this.coche.getVelocidad();
    }

    @Override
    public Persona setVelocidad(double velocidad) {
        this.coche.setVelocidad(velocidad);
        return this;
    }

    @Override
    public Persona acelerar() {
        this.coche.setVelocidad(coche.getVelocidad()+1);
        return this;
    }

    @Override
    public Persona frenar() {
        this.coche.setVelocidad(coche.getVelocidad()-1);
        return this;
    }
}