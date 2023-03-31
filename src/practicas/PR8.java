package practicas;

import clases.Persona;

public class PR8 {
    Persona p;
    public PR8(){
        p = new Persona("JUAN");
    }

    public static void main(String[] args) {
        PR8 app = new PR8();
        app.inicio();
    }

    private void inicio() {
        p.setPeso(55);
        p.comer(0.5F);
        System.out.println(p.getPeso());
        p.beber(0.75F);
        System.out.println(p.getPeso());
        p.correr(3);
        System.out.println(p.getPeso());
    }
}
