package Modelo.Excepciones;

public class NoAddBarco extends Exception {
    public NoAddBarco(){
        super("*No se puede agregar Barco*");
    }
    public NoAddBarco(String mensaje){
        super(mensaje);
    }
}
