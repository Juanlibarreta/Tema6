package practicas;

import clases.figuras.Caja;

public class PR10 {
    Caja c;
    Caja c1;
    Caja c2;

    public PR10(){
        c = new Caja(12,5,8);
        c1 = new Caja(17, 43, 45);
        c2 = new Caja(20, 3, 45);
    }

    public static void main(String[] args) {
        PR10 app = new PR10();
        app.inicio();
    }

    private void inicio() {
        System.out.println(c1.dimension());
        System.out.println(c2.dimension());
        System.out.println(c.dimension());

        c1.sumar(c);
        System.out.println(c1.dimension());
        c2.restar(c);
        System.out.println(c2.dimension());
    }
}
