package clases.interfaces;

public interface ICoche {
    enum Colores{
        blanco,
        negro,
        azul,
        verde,
        amarillo,
        rosa,
        naranja,
        rojo
    }
    String getMatricula();
    Object setMatricula(String s);
    Colores getColor();
    Object setColor(Colores color);
    double getVelocidad();
    Object setVelocidad(double velocidad);
    Object acelerar();
    Object frenar();
    Object clone();
}
