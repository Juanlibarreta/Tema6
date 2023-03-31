package clases;


import java.util.ArrayList;

import JLISV.LIB;

public class Alumno implements Comparable<Alumno>{
    public final String NOMBRE[] = {"Fundamentos de Programacion","Base de datos","Lenguaje de marcas","Sistemas informaticos","Formacion y orientacion labora","Entornos de desarrollo"};
    public final String SIGLAS[] = {"FP","BD","XML","SI","FOL","ED"};
    private String nombre = "";
    private String primerApellido = "";
    private String segundoApellido = "";
    private int[] notas = {1,1,1,1,1,1};
    //getters
    public String[] getNOMBRE() {
        return NOMBRE;
    }
    public String[] getSIGLAS() {
        return SIGLAS;
    }
    public String getNombre() {
        return nombre;
    }
    public String getPrimerApellido() {
        return primerApellido;
    }
    public String getSegundoApellido() {
        return segundoApellido;
    }
    public int[] getNotas() {
        return notas;
    }
    //setters
    public Alumno setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public Alumno setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
        return this;
    }
    public Alumno setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
        return this;
    }
    public Alumno setNota(int[] notas) {
        this.notas = notas;
        return this;
    }
    public Alumno setNotas(){
        for (int i = 0; i < notas.length; i++) {
            this.notas[i] = setNotas(LIB.lInt("Introducir nota para "+ SIGLAS[i] +": "));
        }
        return this;
    }

    public int setNotas(int v){
        if(v < 1 || v > 10){
            throw new IllegalArgumentException("Nota entre 1 y 10");
        }
        return v;
    }
    //constructores
    public Alumno(){}

    public Alumno(String primerApellido, String segundoApellido, String nombre){
        setPrimerApellido(primerApellido);
        setSegundoApellido(segundoApellido);
        setNombre(nombre);
    }
    //metodos
    public int notaModulo(String s){
        int n = 0;
        for(int i = 0; i < SIGLAS.length; i++){
            if(SIGLAS[i].equals(s)){
                n = notas[i];
            }
        }
        return n;
    }

    public void modNotaModulo(String s){
        for (int i = 0; i < SIGLAS.length; i++) {
            if(SIGLAS[i].equals(s)){
                notas[i] = setNotas(LIB.lInt("Introduce nueva nota en "+ SIGLAS[i] + ": "));
            }
        }
    }

    public void asigMismaNota(int n){
        for (int i = 0; i < notas.length; i++) {
            notas[i] = setNotas(n);
        }
    }
    public void busqueda(ArrayList<Alumno> a, Alumno alumno){
        if(a.contains(alumno)){
            System.out.println("Alumno archivado");
        }else{
            System.out.println("Alumno no existente");
        }
    }
    public double media(){
        double v = 0.0;
        for (int i = 0; i < notas.length; i++) {
            v += notas[i]; 
        }
        v = LIB.redon(v/(notas.length*1.0), 1);
        return v;
    }
    //override
    @Override
    public String toString(){
        String s = "";
        s += nombre + " " + primerApellido + " " + segundoApellido + "\n";
        for (int i = 0; i < notas.length; i++) {
            s += SIGLAS + ": " + notas[i] + "\n";
        }
        s+= "Media: " + media() + "\n";
        return s;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((primerApellido == null) ? 0 : primerApellido.hashCode());
        result = prime * result + ((segundoApellido == null) ? 0 : segundoApellido.hashCode());
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
        Alumno other = (Alumno) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (primerApellido == null) {
            if (other.primerApellido != null)
                return false;
        } else if (!primerApellido.equals(other.primerApellido))
            return false;
        if (segundoApellido == null) {
            if (other.segundoApellido != null)
                return false;
        } else if (!segundoApellido.equals(other.segundoApellido))
            return false;
        return true;
    }

    @Override
    public int compareTo(Alumno o){
        return this.getNombre().compareTo(o.getNombre());
    }
}
