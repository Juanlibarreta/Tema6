package clases;

import java.io.Closeable;
import java.util.Random;

import clases.enumerados.Materiales;

public class Placa implements Cloneable, Comparable<Placa>, Closeable{
    public static final int ANCHO_MIN;
    public static final int ALTO_MIN;
    public static final int ANCHO_MAX;
    public static final int ALTO_MAX;
    static{
        Random rd = new Random();
        ANCHO_MIN = rd.nextInt(3, 11);
        ALTO_MIN = rd.nextInt(3, 11);
        ANCHO_MAX = rd.nextInt(80, 101);
        ALTO_MAX = rd.nextInt(80, 101);
    }
    public final String NOMBRE_INI;
    public final int ANCHO_INI;
    public final int ALTO_INI;
    public final Materiales MATERIAL_INI;
    private String nombre = "";
    private int ancho = 0;
    private int alto = 0;
    Materiales material = Materiales.MADERA;

    /**
     * devuelve nombre placa
     * 
     * @return nombre
     * 
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * 
     * @param nombre variable de entrada
     * @return
     */
    public Placa setNombre(String nombre){
        if(!nombre.matches("[A-ZÑ]+(\\s[A-ZÑ])*")){
            throw new IllegalArgumentException("Palabras en mayusculas y con espacios");
        }
        this.nombre = nombre;
        return this;
    }
    /**
     * 
     * @return ancho placa
     */
    public int getAncho(){
        return ancho;
    }
    /**
     * 
     * @param ancho
     * @return
     */
    public Placa setAncho(int ancho){
        if(ancho < ANCHO_MIN || ancho > ANCHO_MAX){
            throw new IllegalArgumentException("Ancho no valido, valores entre " + ANCHO_MIN + " y " + ANCHO_MAX);
        }
        this.ancho = ancho;
        return this;
    }
    /**
     * 
     * @return alto placa
     */
    public int getAlto(){
        return alto;
    }
    /**
     * 
     * @param alto
     * @return
     */
    public Placa setAlto(int alto){
        if(alto < ALTO_MIN || alto > ALTO_MAX){
            throw new IllegalArgumentException("Alto no valido, valores entre " + ALTO_MIN + " y " + ALTO_MAX);
        }
        this.alto = alto;
        return this;
    }
    /**
     * 
     * @return material placa
     */
    public Materiales getMaterial(){
        return material;
    }
    /**
     * 
     * @param material
     * @return
     */
    public Placa setMaterial(Materiales material){
        this.material = material;
        return this;
    }

    /**
     * 
     * @param nombre
     * @param alto
     * @param ancho
     * @param material
     */
    public Placa(String nombre, int alto, int ancho, Materiales material){
        setNombre(nombre);
        setAlto(alto);
        setAncho(ancho);
        setMaterial(material);
        NOMBRE_INI = getNombre();
        ALTO_INI = getAlto();
        ANCHO_INI = getAncho();
        MATERIAL_INI = getMaterial();
    }

    /**
     * 
     * @return
     */
    public Placa inicial(){
        setNombre(NOMBRE_INI);
        setAlto(ALTO_INI);
        setAncho(ANCHO_INI);
        setMaterial(MATERIAL_INI);
        return this;
    }

    
    /** 
     * @return Object
     */
    //clone
    @Override
    protected Object clone(){
        try{
            return super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString(){
        String v = "";
        v += "Inscripcion: " + getNombre();
        v += "Alto: " + getAlto();
        v += "Ancho: " + getAncho();
        v += "Material: " + getMaterial() + " Precio: " + getMaterial().getPrecio()+ " Calidad: " + getMaterial().getCalidad();
        return v;
    }

    
    /** 
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Placa o) {
        if(getNombre().compareTo(o.getNombre()) < 0) return -1;
        if(getNombre().compareTo(o.getNombre()) > 0) return 1;
        return 0;
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
        Placa other = (Placa) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }
    @Override
    public void close(){
        System.out.println("*****PLACA DESTRUIDA*****");
    }
}
