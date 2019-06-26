package Modelo.StrategyDisparo;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Tablero;

public class DisparoComun implements DisparoBehavior{

    @Override
    public void disparar(int fila, int columna, Tablero tableroDisparos) throws InvalidDisparoException {
        if(tableroDisparos.esValido(fila, columna)){
            tableroDisparos.dispararUna(fila, columna);
        }
        else throw new InvalidDisparoException("No puedes disparar alli");
}

    @Override
    public Disparo getTipo() {
        return Disparo.COMUN;
    }
}
