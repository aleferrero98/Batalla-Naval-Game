package Modelo.StrategyDisparo;

import Modelo.Tablero;

public interface DisparoBehavior {
    public void disparar(int fila, int columna, Tablero tableroDisparos);
}
