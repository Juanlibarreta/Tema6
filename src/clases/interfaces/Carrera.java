package clases.interfaces;

public interface Carrera {
    int METROS_POR_KILOMETRO = 1000;
    float KILOMETROS_POR_METRO = 0.001F;
    Object correr();
    Object correr(float metros);
}
