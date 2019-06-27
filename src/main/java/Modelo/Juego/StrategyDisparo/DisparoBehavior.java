package Modelo.Juego.StrategyDisparo;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Juego.ElementosPrincipales.Tablero;

public interface DisparoBehavior {

    public void disparar(int fila, int columna, Tablero tableroDisparos) throws InvalidDisparoException;

    public Disparo getTipo();
}
