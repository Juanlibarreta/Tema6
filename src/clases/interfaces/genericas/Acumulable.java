package clases.interfaces.genericas;

public interface Acumulable<T> {
    double PI = 3.1416;

    T acumular();
    T acumular(T o);
    boolean esNulo();
}