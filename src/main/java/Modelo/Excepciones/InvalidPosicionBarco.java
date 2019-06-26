package Modelo.Excepciones;

public class InvalidPosicionBarco extends Exception {
    public InvalidPosicionBarco(){
        super("*No se puede agregar Barco*");
    }
    public InvalidPosicionBarco(String mensaje){
        super(mensaje);
    }
}
