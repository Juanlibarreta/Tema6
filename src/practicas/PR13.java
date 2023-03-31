package practicas;

import clases.figuras.Cuadrado;
import clases.figuras.Rectangulo;
import clases.interfaces.Acumulable;

public class PR13 {
    Rectangulo r1;
    Rectangulo r2;

    public PR13(){
        r1 = new Rectangulo(6,3);
        r2 = new Cuadrado();
    }
    
    private void inicio(){
        Acumulable[] ac = {r1, new Rectangulo(2,4), new Cuadrado(3), new Rectangulo()};
        System.out.println(r2 instanceof Rectangulo);
        for (int i = 0; i < ac.length; i++) {
            if(ac[i] instanceof Rectangulo){
                ac[i].acumular(r2);
            }
        }
        for (int i = 0; i < ac.length; i++) {
            if(ac[i] instanceof Rectangulo){
                System.out.println(((Rectangulo) ac[i]).dimension());
            }
        }
    }

    public static void main(String[] args) {
        PR13 app = new PR13();
        app.inicio();
    }
}
