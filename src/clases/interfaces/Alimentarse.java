package clases.interfaces;

public interface Alimentarse {
    int GRAMOS_POR_KILO = 1000;
    float KILOS_POR_GRAMO = 0.001F;
    Object comer();
    Object comer(float Kg);
    Object beber();
    Object beber(float litros);
}
