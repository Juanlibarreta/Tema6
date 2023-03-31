package clases;


import java.beans.PropertyVetoException;

import clases.enumerados.Licenciatura;

public class Profesor extends Persona{
    public final Licenciatura LICENCIATURA;
    private String centro = "";
    private int experiencia = 0;

    public String getCentro(){
        return centro;
    }

    public int getExperiencia(){
        return experiencia;
    }

    public Profesor setCentro(String centro){
        if(centro.matches("[A-ZÑ]*")){
            throw new IllegalArgumentException("Palabra en mayusculas o en blanco");
        }
        try {
            getCambiar().fireVetoableChange("centro", this.centro, centro);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        String antiguo = this.centro;
        this.centro = centro;
        getCambiado().firePropertyChange("centro",antiguo,this.centro);
        return this;
    }

    public Profesor setExperiencia(int experiencia){
        if(experiencia < 0 || experiencia > 39){
            throw new IllegalArgumentException("Numero mayor de 0 y menor de 39, inclusivo");
        }
        try {
            getCambiar().fireVetoableChange("experiencia", this.experiencia, experiencia);
        } catch (PropertyVetoException e) {
           e.printStackTrace();
        }
        int antiguo = this.experiencia;
        this.experiencia = experiencia;
        getCambiado().firePropertyChange("experiencia", antiguo,this.experiencia);
        return this;
    }

    public Profesor(String nombre, int edad, double altura, double peso, Licenciatura licenciatura,String centro,int experiencia){
        super(nombre,edad,altura,peso);
        LICENCIATURA = licenciatura;
        setCentro(centro);
        setExperiencia(experiencia);
    }
    public Profesor(String nombre){
        super(nombre);
        LICENCIATURA = Licenciatura.Fisicas;
    }
    public Profesor(String nombre, Licenciatura licenciatura){
        super(nombre);
        LICENCIATURA = licenciatura;
    }
    public Profesor(String nombre, int edad,Licenciatura licenciatura){
        super(nombre,edad);
        LICENCIATURA = licenciatura;
    }
    public Profesor(int edad,String nombre,Licenciatura licenciatura){
        this(nombre, edad, licenciatura);
    }
    public Profesor(String nombre,int edad,double peso, Licenciatura licenciatura, String centro){
        super(nombre, edad, peso);
        LICENCIATURA = licenciatura;
        setCentro(centro);
    }

    @Override
    public String toString(){
        String s = "";
        s+= super.toString();
        s+= "\nCentro: " + getCentro() +
         "\nExperiencia: " + getExperiencia() +
         "\nLicenciatura: " + LICENCIATURA;
        return s;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + experiencia;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Profesor other = (Profesor) obj;
        if (experiencia != other.experiencia)
            return false;
        return true;
    }

    @Override
    public int compareTo(Persona p) {
        if(p instanceof Profesor){
            Profesor pr = (Profesor) p;
            if(getExperiencia()<pr.getExperiencia())return -1;
            if(getExperiencia()>pr.getExperiencia())return 1;
            return 0;
        }
        return super.compareTo(p);
    }

    
    
}
