package clases.util;

public class Excepciones{
    
    public Excepciones(){
    }

    public void valorNegativoException(String s){
        throw new valorNegativoException(s);
    }

    public void numeroInvalidoDeDecimalesException(String s){
        throw new numeroInvalidoDeDecimalesException(s);
    }
    public void VerticesInvalidosException(String s){
        throw new VerticesInvalidosException(s);
    }
}

class valorNegativoException extends RuntimeException{
    public valorNegativoException(String s){
        super(s);
    }
}

class numeroInvalidoDeDecimalesException extends RuntimeException{
    public numeroInvalidoDeDecimalesException(String s){
        super(s);
    }
}

class VerticesInvalidosException extends RuntimeException{
    public VerticesInvalidosException(String s){
        super (s);
    }
}
