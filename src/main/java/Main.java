import Modelo.Juego.ElementosPrincipales.Barco;
import Modelo.Juego.ElementosPrincipales.Tablero;
import Modelo.Juego.FactoryBarcos.BarcosParaAstilleroMilitar.Submarino;
import Modelo.Excepciones.InvalidPosicionBarco;

public class Main {
    public static void main (String[] args){
        Tablero tablero = new Tablero(13);
        Submarino submarino = new Submarino();
        try {
            tablero.setBarco(submarino, 'N', 5, 5);
        }catch (InvalidPosicionBarco e){
            e.printStackTrace();
        }
        tablero.activarTablero();

            if(true){
                System.out.println("puto");
            }
            else if(true){
                System.out.println("el que lee");
            }
    }
}
