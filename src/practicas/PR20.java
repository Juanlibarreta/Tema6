package practicas;

import clases.interfaces.Operable;

public class PR20 {
    private Operable op;
    PR20(){
        op = new Operable() {

            @Override
            public Integer sumar(Object a, Object b) {
                if(!(a instanceof Integer) || !(b instanceof Integer)){
                    throw new IllegalArgumentException("Algun valor no es un entero");
                }
                int v = (Integer) a + (Integer) b;
                return v;
            }

            @Override
            public Integer restar(Object a, Object b) {
                if(!(a instanceof Integer) || !(b instanceof Integer)){
                    throw new IllegalArgumentException("Algun valor no es un entero");
                }
                int v =(int) a - (int) b;
                return v;
            }

            @Override
            public Integer multiplicar(Object a, Object b) {
                if(!(a instanceof Integer) || !(b instanceof Integer)){
                    throw new IllegalArgumentException("Algun valor no es un entero");
                }
                int v =(int) a * (int) b;
                return v;
            }
            
        };
    }
    public static void main(String[] args) {
        PR20 app = new PR20();
        app.inicio();
    }

    private void inicio() {
        int a = 5;
        int b = 3;
        System.out.println(op.sumar(a, b));
    }
}
