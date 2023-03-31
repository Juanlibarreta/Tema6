package practicas;

import clases.figuras.Rectangulo;
import clases.interfaces.Acumulable;

public class PR12 {
    private Rectangulo r;
    private Acumulable a;

    public PR12(){
        r = new Rectangulo(3,4);
        a = r;
    }

    private void inicio(){
        a.acumular();
        r = (Rectangulo) a;
        System.out.println(r.dibujar());
    }

    public static void main(String[] args) {
        PR12 app = new PR12();
        app.inicio();
    }
}
