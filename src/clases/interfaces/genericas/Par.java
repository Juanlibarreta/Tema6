package clases.interfaces.genericas;

public class Par<T,S> {
    private T clave = null;
    private S valor = null;
    private static class ObjetoNuloException extends RuntimeException{
        ObjetoNuloException(String s){
            super(s);
        }
    }
    public T getClave(){
        return clave;
    }

    public S getValor(){
        return valor;
    }

    public Par setClave(T clave){
        if(clave == null){
            throw new ObjetoNuloException("No puede ser nulo");
        }
        this.clave = clave;
        return this;
    }

    public Par setValor(S valor){
        if(valor == null){
            throw new ObjetoNuloException("No puede ser nulo");
        }
        this.valor = valor;
        return this;
    }

    public Par(T clave, S valor){
        setClave(clave);
        setValor(valor);
    }
}
