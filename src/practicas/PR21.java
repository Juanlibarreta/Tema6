package practicas;

import clases.Operaciones;
import clases.figuras.Rectangulo;

public class PR21 {
    Operaciones op;
    Rectangulo r1;
    Rectangulo r2;

    PR21(){
        op = new Operaciones() {

            @Override
            public Object sumar(Object a, Object b) {
                if(!(a instanceof Rectangulo) || !(b instanceof Rectangulo)){
                    throw new IllegalArgumentException("Algun objeto no es un rectangulo");
                }
                Rectangulo a1 = (Rectangulo) a;
                Rectangulo b1 = (Rectangulo) b;
                Rectangulo r = new Rectangulo();
                r.setAlto(a1.getAlto() > b1.getAlto()?a1.getAlto():b1.getAlto());
                r.setAncho(a1.getAncho() > b1.getAncho()?a1.getAncho():b1.getAncho());
                return r;
            }

            @Override
            public Object restar(Object a, Object b) {
                if(!(a instanceof Rectangulo) || !(b instanceof Rectangulo)){
                    throw new IllegalArgumentException("Algun objeto no es un rectangulo");
                }
                Rectangulo a1 = (Rectangulo) a;
                Rectangulo b1 = (Rectangulo) b;
                Rectangulo r = new Rectangulo();
                r.setAlto(a1.getAlto() < b1.getAlto()?a1.getAlto():b1.getAlto());
                r.setAncho(a1.getAncho() < b1.getAncho()?a1.getAncho():b1.getAncho());
                return r;
            }

            @Override
            public Object multiplicar(Object a, Object b) {
                if(!(a instanceof Rectangulo) || !(b instanceof Rectangulo)){
                    throw new IllegalArgumentException("Algun objeto no es un rectangulo");
                }
                Rectangulo a1 = (Rectangulo) a;
                Rectangulo b1 = (Rectangulo) b;
                Rectangulo r = new Rectangulo();
                r.setAlto((a1.getAlto() + b1.getAlto())/2);
                r.setAncho((a1.getAncho()+b1.getAncho())/2);
                return r;
            }
            
        };
    }

    public static void main(String[] args) {
        PR21 app = new PR21();
        app.inicio();
    }

    private void inicio() {
        Rectangulo r = new Rectangulo(5,4);
        Rectangulo r1 = new Rectangulo(3,9);

        System.out.println(((Rectangulo) op.sumar(r, r1)).dibujar());
    }
}
