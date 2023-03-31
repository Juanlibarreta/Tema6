
package JLISV;
import java.util.*;
import java.util.function.*;
import java.io.*;

public class LIB {
    public static final Scanner sc = new Scanner(System.in);
    /*
     * lee un int con texto predefinido
     */
    public static int lInt(){
        return lInt("Introduce un numero entero: ");
    }
    /*
     * Lee un Int con un texto añadido por el usuario
     * @param mens texto a mostrar al pedir el num
     * @return     Numero introducido y verificado
     */
    public static int lInt(String mens){
        boolean correcto = false;
        int v = 0;
        String flush;
        while(!correcto){
            System.out.print(mens);
            if(sc.hasNextInt()){    
                v = sc.nextInt();
                flush = sc.nextLine();
                if(flush.equals("")){
                        correcto = true;
                }else{
                    System.out.println("multiples valores detectados.");
                }
            }else {
                System.out.println("Valor incorrecto");
                sc.nextLine();
            }
        }
        return v;
    }
    //leer byte
    public static byte lByte(){
        return lByte("Intoduce 1 byte: ");
    }

    public static byte lByte(String mens){
        boolean correcto = false;
        byte v = 0;
        String flush;
        while(!correcto){
            System.out.print(mens);
            if(sc.hasNextByte()){
                v = sc.nextByte();
                flush = sc.nextLine();
                if(flush.equals("")){
                        correcto = true;
                }else{
                    System.out.println("multiples valores detectados.");
                }
            }else {
                System.out.println("Valor incorrecto");
                sc.nextLine();
            }
        }
        return v;
    }
    //leer long
    public static long lLong(){
        return lLong("Insertar long: ");
    }

    public static long lLong(String mens){
        boolean correcto = false;
        long v = 0;
        String flush;
        while(!correcto){
            System.out.print(mens);
            if(sc.hasNextLong()) {
                v = sc.nextLong();
                flush = sc.nextLine();
                if(flush.equals("")){
                        correcto = true;
                }else{
                    System.out.println("multiples valores detectados.");
                }
            }else {
                System.out.println("Valor incorrecto");
                sc.nextLine();
            }
        }
        return v;
    }
    //leer double
    public static double lDouble(){
        return lDouble("Insertar real: ");
    }

    public static double lDouble(String mens){
        boolean correcto = false;
        double v = 0;
        String flush;
        while(!correcto){
            System.out.print(mens);
            if(sc.hasNextDouble()) {
                v = sc.nextDouble();
                flush = sc.nextLine();
                if(flush.equals("")){
                        correcto = true;
                }else{
                    System.out.println("multiples valores detectados.");
                }
            }else {
                System.out.println("Valor incorrecto");
                sc.nextLine();
            }
        }
        return v;
    }
    //leer char
    public static char lChar(){
        return lChar("Introducir cararter: ");
    }

    public static char lChar(String mens){
        char c = 0;
            System.out.print(mens);
            c = sc.next().charAt(0);
            sc.nextLine();
        return c;
    }
    //leer short
    public static short lShort(){
        return lShort("Introduce un numero short: ");
    }
    
    public static short lShort(String mens){
        boolean correcto = false;
        short v = 0;
        String flush;
        System.out.print(mens);
        while(!correcto){
            if(sc.hasNextShort()){
                v = sc.nextShort();
                flush = sc.nextLine();
                if(flush.equals("")){
                    correcto = true;
                }else{
                    System.out.println("multiples valores detectados.");
                }
            }else {
                System.out.println("Valor incorrecto");
                sc.nextLine();
            }
        }
        return v;
    }
    //leer String
    public static String lString(){
        return lString("Introduce una palabra: ");
    }
    
    public static String lString(String mens){
        String v = "";
        System.out.print(mens);
        v = sc.next();
        sc.nextLine();
        return v;
    }
    //leer linea
    public static String lLinea(){
        return lLinea("Introduzca linea: ");
    }

    public static String lLinea(String mens){
        String v = "";
        System.out.print(mens);
        v = sc.nextLine();
        return v;
    }
    //leer bolean
    public static boolean lBoolean(){
        return lBoolean("Introduzca valor boolean: ");
    }

    public static boolean lBoolean(String mens){
        boolean correcto = false;
        boolean v = false;
        String flush;
        while(!correcto){
            System.out.print(mens);
            if(sc.hasNextBoolean()) {
                v = sc.nextBoolean();
                flush = sc.nextLine();
                if(flush.equals("")){
                    correcto = true;
                }else{
                    System.out.println("multiples valores detectados.");
                }
            }else {
                System.out.println("Valor incorrecto");
                sc.nextLine();
            }
        }
        return v;
    }
    //limpiar
    public static void cln(){
        String s = System.getProperty("os.name");
        if(s.indexOf("Window") != -1){
            try{
               ProcessBuilder pb = new ProcessBuilder("cmd","/c","cls");
               pb.inheritIO().start().waitFor();
            } catch (IOException e){        
               e.printStackTrace();
            } catch (InterruptedException e){        
               e.printStackTrace();
            }
        }else{
            for(int i = 0; i< 100; i++){
                System.out.println("");
            }
        }
    }
    //esperar
    public static void dormir(long tiempo){
        try {
            Thread.sleep(tiempo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //detener
    public static void detener(){
        detener("Pulsa enter para continuar ... ");
    }

    public static void detener(String mens){
        System.out.println(mens);
        sc.nextLine();
    }
    
    /*
     * Funciones mas usadas
     */

    public static double trun(double num, double deci){ 
        return (int) (num*Math.pow(10, deci))/(Math.pow(10, deci)*1.0);
    }

    public static double redon(double num, double deci){
        if(num > 0){
            return (int) (num*Math.pow(10, deci)+0.5)/(Math.pow(10, deci)*1.0);
        }else{
            return (int) (num*Math.pow(10, deci)-0.5)/(Math.pow(10, deci)*1.0);
        }
    }

    public static int randomInt(int min, int max){
        if(min < max){
            return (int) (Math.random()*(max-min+1) + min);
        }else{
            return (int) (Math.random()*(min-max+1) + max);
        }
    }

    public static double randomDouble(double min, double max){
        if(min < max){
            return Math.random()*(max-min+1) + min;
        }else{
            return Math.random()*(min-max+1) + max;
        }
    }

    /*
     * Validaciones de datos
     */
    //validar int
    public static int lInt(String mens, Predicate<Integer> v, String ... error){
        int valor = 0;
        while(!v.test(valor=lInt(mens))){
            if(error.length>0){
                System.out.println(error[0]);
            }else{
                System.out.println("Valor incorrecto");
            }
        }
        return valor;
    }
    //validar double
    public static double lDouble(String mens, Predicate<Double> v,String ... error){
        double valor = 0;
        while(!v.test(valor=lDouble(mens))){
            if(error.length>0){
                System.out.println(error[0]);
            }else{
                System.out.println("Valor incorrecto");
            }
        }
        return valor;
    }
    //validar long
    public static long lLong(String mens, Predicate<Long> v,String ... error){
        long valor = 0;
        while(!v.test(valor=lLong(mens))){
            if(error.length>0){
                System.out.println(error[0]);
            }else{
                System.out.println("Valor incorrecto");
            }
        }
        return valor;
    }
}
