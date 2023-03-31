package practicas;

import clases.figuras.Cuadrado;

public class PR11 {
    Cuadrado c1,c2,c3,c4;
    public PR11(){
        c1 = new Cuadrado(6);
        c2 = new Cuadrado(6);
        c3 = new Cuadrado(6);
        c4 = new Cuadrado(2);
    }

    
    private void inicio() {
        c1.sumar(c4);
        c2.restar(c4);
        c3.multiplicar(c4);
        System.out.println(c1.dimension());
        System.out.println(c2.dimension());
        System.out.println(c3.dimension());
        System.out.println(c1.dibujar());
        System.out.println(c2.dibujar());
        System.out.println(c3.dibujar());
    }

    public static void main(String[] args) {
        PR11 app = new PR11();
        app.inicio();
    }
}
