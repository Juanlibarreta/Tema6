package JLISV;

import java.util.function.*;

public class LibArray {
    
    //mostrar int
    public static void mostrar(int[] v){
        for(int i = 0; i < v.length; i++){
            if(i > 0){
                System.out.print(", ");
            }
            System.out.print(v[i]);
        }
        System.out.println();
    }

    //mostrar tabla int
    public static void mostrarTabla(int[][] v){
        for(int i = 0; i < v.length; i++){
            for(int j = 0; j < v[i].length; j++){
                if(j > 0){
                    System.out.print(", ");
                }
                System.out.print(v[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //mostrar tabla double
    public static void mostrarTabla(double[][] v){
        for(int i = 0; i < v.length; i++){
            for(int j = 0; j < v[i].length; j++){
                if(j > 0){
                    System.out.print(", ");
                }
                System.out.print(v[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //mostrar double
    public static void mostrar(double[] v){
        for(int i = 0; i < v.length; i++){
            if(i > 0){
                System.out.print(", ");
            }
            System.out.print(v[i]);
        }
        System.out.println();
    }

    //mostrar char
    public static void mostrar(char[] v){
        for(int i = 0; i < v.length; i++){
            if(i > 0){
                System.out.print(", ");
            }
            System.out.print(v[i]);
        }
        System.out.println();
    }

    //mostrar string
    public static void mostrar(String[] v){
        for(int i = 0; i < v.length; i++){
            if(i > 0){
                System.out.print(", ");
            }
            System.out.print(v[i]);
        }
        System.out.println();
    }

    //rellenar array tipo int
    public static void rellInt(int[] v, int t){
        v = new int[t];
        for(int i = 0; i < v.length; i++){
            v[i] = LIB.lInt("Introducir int a insertar: ");
        }
    }

    //generar array tipo int
    public static int[] genIntAle(int tam,int min, int max){
        int[] v = new int[tam];
        for(int i = 0; i < v.length; i++){
            v[i] = LIB.randomInt(min, max);
        }
        return v;
    }

    //generar array tipo double
    public static double[] genDoubleAle(int tam,int min, int max){
        double[] v = new double[tam];
        for(int i = 0; i < v.length; i++){
            v[i] = LIB.redon(LIB.randomDouble(min, max), 3);
        }
        return v;
    }

    //rellenar array tipo double
    public static void rellDouble(double[] v, int t){
        v = new double[t];
        for(int i = 0; i < v.length; i++){
            v[i] = LIB.lDouble("Introducir double a insertar: ");
        }
    }

    //rellenar array tipo String
    public static void rellString(String[] v, int t){
        v = new String[t];
        for(int i = 0; i < v.length; i++){
            v[i] = LIB.lString("Introducir palabra a insertar: ");
        }
    }

    //aumentar en 1 la longitud y rellenarla int
    public static int[] añadirInt(int[] v, int n){
        if(v == null){
            v = new int[0];
        }
        int[] s = new int[v.length+1];
        for(int i = 0; i < v.length; i++){
            s[i] = v[i];
        }
        s[s.length-1] = n;
        return s;
    }

    //aumentar en 1 la longitud y rellenarla double
    public static double[] añadirDouble(double[] v, double n){
        if(v == null){
            v = new double[0];
        }
        double[] s = new double[v.length+1];
        for(int i = 0; i < v.length; i++){
            s[i] = v[i];
        }
        s[s.length-1] = n;
        return s;
    }

    //aumentar en 1 la longitud y rellenarla string
    public static String[] añadirString(String[] v, String n){
        if(v == null){
            v = new String[0];
        }
        String[] s = new String[v.length+1];
        for(int i = 0; i < v.length; i++){
            s[i] = v[i];
        }
        s[s.length-1] = n;
        return s;
    }

    //restar en 1 la longitud(perdiendo ultimo dato)
    public static int[] restar(int[] v){
        int[] s = new int[v.length-1];
        for(int i = 0; i < s.length; i++){
            s[i] = v[i];
        }
        return s;
    }

    //ordenar  arrays tipo int
    public static void ordenar(int[] v, BiFunction<Integer, Integer,Boolean> intercambio){
        for(int i = 0; i < v.length; i++){
            for(int j = 1; j < v.length-i; j++){
                if(intercambio.apply(v[j-1], v[j])){
                    int aux = v[j-1];
                    v[j-1] = v[j];
                    v[j] = aux;
                }
            }
        }
    }

    //ordenar  arrays tipo double
    public static void ordenar(double[] v, BiFunction<Double,Double,Boolean> intercambio){
        for(int i = 0; i < v.length; i++){
            for(int j = 1;j < v.length-i; j++){
                if(intercambio.apply(v[j-1], v[j])){
                    double aux = v[j-1];
                    v[j-1] = v[j];
                    v[j] = aux;
                }
            }
        }
    }
}
