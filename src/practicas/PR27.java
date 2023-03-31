package practicas;

import java.util.ArrayList;

import clases.figuras.*;
import clases.interfaces.genericas.*;

public class PR27 {
    Par<String,Rectangulo> p1;
    String s;
    Rectangulo r;
    ArrayList<Object> notas;
    PR27(){
        s = "********* ESTO ES UN RECTANGULO *********";
        r = new Rectangulo(6,3);
        p1 = new Par(s,r);
        notas = new ArrayList<>();
        notas.add(new Par<String,Integer>("PRO", 7));
        notas.add(new Par<String,Integer>("BD", 6));
        notas.add(new Par<String,Integer>("SI", 9));
    }

    public static void main(String[] args) {
        PR27 app = new PR27();
        app.inicio();
    }

    private void inicio() {
        System.out.println(p1.getClave());
        System.out.println(p1.getValor().dibujar());
        System.out.println("******* NOTAS *******");
        for (Object o : notas) {
           System.out.println(((Par) o).getClave() + ": " + ((Par) o).getValor()); 
        }
    }
}
