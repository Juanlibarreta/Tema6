package clases;

import java.util.ArrayList;
import java.util.List;

import JLISV.LIB;

public class Alumnos implements Cloneable{
    private String nombre = "";
    private ArrayList<Integer> listaNotas = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public List<Integer> getListaNotas() {
        return listaNotas;
    }
    public int getNotas(int i){
        return listaNotas.get(i);
    }

    public void setNombre(String nombre) {
        if(nombre.length() > 20){
            throw new IllegalArgumentException("Longitud del nombre menor que 20 caracteres");
        }
        if(!nombre.matches("^[A-ZÑÁÉÍÓÚ][a-zñáéíóúü]+(\\s^[A-ZÑÁÉÍÓÚ][a-zñáéíóúü]+)*")){
            throw new IllegalArgumentException("Primera letra en mayuscula, el resto en minusculas, palabras separadas por espacio");
        }
        this.nombre = nombre;
    }
    public void setListaNotas(ArrayList<Integer> listaNotas) {
        this.listaNotas = listaNotas;
    }
    public void setNotas(int nota){
        if(nota > 10 || nota < 0){
            throw new IllegalArgumentException("La nota no esta entre 0 y 10");
        }
        listaNotas.add(nota);
    }
    
    public int sobresalientes(){
        int cont = 0;
        for(int i = 0; i < listaNotas.size();i++){
            if(listaNotas.get(i) >= 8){
                cont++;
            }
        }
        return cont;
    }
    public int suspensos(){
        int cont = 0;
        for(int i = 0; i < listaNotas.size();i++){
            if(listaNotas.get(i) < 5){
                cont++;
            }
        }
        return cont;
    }
    public Alumnos(String nombre, ArrayList<Integer> listaNotas){
        setNombre(nombre);
        setListaNotas(listaNotas);
    }
    public Alumnos(String nombre){
        setNombre(nombre);
    }

    public void remover(int index){
        if(listaNotas.size() < index){
            System.out.println("la posicion es superior al tamañano de la lista");
        }else{
            listaNotas.remove(index);
        }
    }
    public void removerNotas(int i){
        for(int j = 0; j < listaNotas.size();j++){
            if(listaNotas.get(j) == i){
                listaNotas.remove(j);
            }
        }
    }
    public double media(){
        double media = 0.0;
        for(int i = 0; i < listaNotas.size();i++){
            media += listaNotas.get(i);
        }
        media = media/(listaNotas.size()*1.0);
        media = LIB.redon(media, 1);
        return media;
    }
    @Override
    public Alumnos clone(){
        try{
            return (Alumnos) super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String toString(){
        String c = "Nombre: " + getNombre() + "\n";
        for(int i = 0; i < listaNotas.size();i++){
            c += "Nota " + (i+1) + ": " + getNotas(i) + "\n";
        }
        return c;
    }
}
