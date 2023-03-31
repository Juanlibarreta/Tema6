package practicas;

import clases.Perro;

public class PR19 {
    Perro p;
    public PR19(){
        p = new Perro("PIPO", 5F);
    }

    public static void main(String[] args) {
        PR19 app = new PR19();
        app.inicio();
    }

    private void inicio() {
        System.out.println(p.getPeso());
        p.comer();
        System.out.println(p.getPeso());
        System.out.println(p.toString());
    }
}
