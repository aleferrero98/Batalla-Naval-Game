import Controlador.Controlador;
import Modelo.Juego.ElementosPrincipales.Barco;
import Modelo.Juego.ElementosPrincipales.Tablero;
import Modelo.Juego.FactoryBarcos.BarcosParaAstilleroMilitar.Submarino;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.Modelo;

public class Main {
    public static void main (String[] args){

        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador();
        controlador.setModelo(modelo);

    }
}
