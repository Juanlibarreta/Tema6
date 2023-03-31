package clases.figuras;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

import JLISV.LIB;

public class Circunferencia implements Cloneable, Comparable<Circunferencia>{
   private double radio = 1;
   public final double RADIO_INICIAL;
   private PropertyChangeSupport cambio= new PropertyChangeSupport(this);
   private VetoableChangeSupport cambiandose = new VetoableChangeSupport(this);

    //getters
    public VetoableChangeSupport getCambiandose(){
        return cambiandose;
    } 
    public PropertyChangeSupport getCambio(){
        return cambio;
    }
   public double getRadio(){
    return radio;
   }
   //setters

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

   public Circunferencia setRadio(double radio){
    if(radio < 0){
        throw new IllegalArgumentException("Tiene que ser positivo");
    }
    double radioAntiguo = this.radio;
    try{
        cambiandose.fireVetoableChange("radio",radioAntiguo,radio);
    }catch(PropertyVetoException e){
        return this;
    }
    this.radio = radio;
    cambio.firePropertyChange("radio", radioAntiguo,radio);
    return this;
   }
   //constructores
   public Circunferencia(double radio){
    setRadio(radio);
    RADIO_INICIAL = getRadio();
   }
   //cosntructor default
   public Circunferencia(){
    RADIO_INICIAL= getRadio();
   }
   //metodos calculos
   public double area(){
    return Math.PI*Math.pow(radio, 2);
   }
   public double longitud(){
    return 2*Math.PI*radio;
   }
   //metodos consultas
   public boolean esUnitaria(){
        return radio == 1;
   }
   //cambios estados
   public Circunferencia duplicar(){
    setRadio(radio*2);
    return this;
   }
   //overrides
   @Override
   public String toString(){
        return "RADIO_INICIAL: " + RADIO_INICIAL + "\n" +
               "RADIO: " + radio + "\n" +
               "LONGITUD: " + longitud() + "\n" +
               "AREA: " + area();
   }
   public String toString(int decimal){
     return "RADIO_INICIAL: " + RADIO_INICIAL + "\n" +
               "RADIO: " + radio + "\n" +
               "LONGITUD: " + LIB.redon(longitud(), decimal) + "\n" +
               "AREA: " + LIB.redon(area(), decimal);
   }
   @Override
    public Circunferencia clone(){
        try{
            return  (Circunferencia)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(radio);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Circunferencia other = (Circunferencia) obj;
        if (Double.doubleToLongBits(radio) != Double.doubleToLongBits(other.radio))
            return false;
        return true;
    }
    @Override
    public int compareTo(Circunferencia o){
        if(this.getRadio() < o.getRadio()) return -1;
        if(this.getRadio() > o.getRadio()) return 1;
        return 0;
    }
}
