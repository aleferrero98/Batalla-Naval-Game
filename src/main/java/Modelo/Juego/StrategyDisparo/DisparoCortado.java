package Modelo.Juego.StrategyDisparo;


import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Juego.ElementosPrincipales.Tablero;

public class DisparoCortado implements DisparoBehavior {

    @Override
    public void disparar(int fila, int columna, Tablero tableroDisparos) throws InvalidDisparoException {
        if(comprobarDisparo(fila,columna,tableroDisparos)){
            tableroDisparos.dispararUna(fila,columna);
            tableroDisparos.dispararUna(fila,columna+2);
        }
        else{throw new InvalidDisparoException();}
    }

    @Override
    public Disparo getTipo() {
        return Disparo.CORTADO;
    }

    public boolean comprobarDisparo(int fila,int columna, Tablero tableroDisparos){
        if(tableroDisparos.esValido(fila,columna+2)){
            return true;
        }
        return false;
    }
}
