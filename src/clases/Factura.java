package clases;

import java.util.ArrayList;

public class Factura implements Cloneable{
    private int codigo = 0;
    private ArrayList<Linea> reporte = new ArrayList<>();

    public int getCodigo(){
        return codigo;
    }
    public ArrayList<Linea> getLinea(){
        return reporte;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setReporte(ArrayList<Linea> reporte){
        this.reporte = reporte;
    }

    @Override
    public Factura clone(){
        try{
            return  (Factura) super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
}
