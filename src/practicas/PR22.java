package practicas;

import JLISV.LIB;
import clases.Operar;
import clases.Persona;

public class PR22 {
    Operar op;
    Persona p1;
    Persona p2;
    PR22(){
        op = new Operar(){
            @Override
            public Object sumar(Object a, Object b){
                if(!(a instanceof Persona) || !(b instanceof Persona)){
                    throw new IllegalArgumentException("Algun objeto no es una persona");
                }
                Persona j = new Persona();
                int edad = (((Persona) a).getEdad() + ((Persona) b).getEdad())/2;
                j.setEdad(edad);
                return j;
            }

            @Override
            public Object restar(Object a, Object b){
                if(!(a instanceof Persona) || !(b instanceof Persona)){
                    throw new IllegalArgumentException("Algun objeto no es una persona");
                }
                Persona j = new Persona();
                int edad = ((Persona) a).getEdad() - ((Persona) b).getEdad();
                if(edad < 0) edad *= -1;
                j.setEdad(edad);
                return j;
            }
        };
        p1 = new Persona();
        p1.setEdad(LIB.randomInt(20, 80));
        p2 = new Persona();
        p2.setEdad(LIB.randomInt(20, 80));
        
    }

    public static void main(String[] args) {
        PR22 app = new PR22();
        app.inicio();
    }

    private void inicio() {
        System.out.println(p1.getEdad());
        System.out.println(p2.getEdad());
        System.out.println(op.sumar(p1, p2));
        System.out.println(op.restar(p1, p2));
    }
}
