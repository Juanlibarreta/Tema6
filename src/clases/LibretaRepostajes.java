package clases;

import java.util.*;

import JLISV.LIB;
import clases.enumerados.Semana;

public class LibretaRepostajes implements Cloneable{
    ArrayList<Repostar> libreta = new ArrayList<>();

    public void añadirRepostaje(Repostar repostaje){
        this.libreta.add(repostaje);
    }

    public void añadirRepostajeAntes(int v){
        Repostar r = new Repostar(Semana.valueOf(LIB.lString("Insertar dia de la semana: ")),
                                    LIB.lDouble("Insertar la cantidad de gasolina: "),
                                    LIB.lDouble("Introducir precio: "));
        this.libreta.add(v, r);
    }

    public void modiRepostaje(int v){
        v--;
        Repostar r = new Repostar(Semana.valueOf(LIB.lString("Insertar dia de la semana: ")),
                                    LIB.lDouble("Insertar la cantidad de gasolina: "),
                                    LIB.lDouble("Introducir precio: "));
        this.libreta.set(v, r);
    }

    public void elimiRepostaje(int v){
        this.libreta.remove(v);
    }

    public void elimiRepostajeCoste(double v){
        for (int i = 0; i < libreta.size(); i++) {
            if(this.libreta.get(i).getPrecio() > v){
                this.libreta.remove(i);
            }
        }
    }

    public void limpiarLibreta(){
        libreta.clear();
    }

    public ArrayList<Repostar> copiaSeguridad(){
        return libreta;
    }

    public void restaurar(ArrayList<Repostar> backup){
        double coste = 0;
        for (int i = 0; i < libreta.size(); i++) {
            System.out.println("Dia " + (i+1)+": ");
            System.out.println(this.libreta.get(i).toString());
            coste += this.libreta.get(i).coste(2);
        }
        System.out.println("Coste total: " + coste);
        libreta = backup;
    }

    //overrides 
    @Override
    public LibretaRepostajes clone(){
        try{
            return  (LibretaRepostajes)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }    
}
