package Modelo.StrategyDisparo;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Tablero;
import Modelo.Barco;
import Modelo.Celda;

public class DisparoTermodirigido implements DisparoBehavior { //Controlar, NO HARIA FALTA RECIBIR FILA Y COLUMNA SI ES TERMIDIRIGIDO
    @Override
    public void disparar(int fila, int columna, Tablero tableroDisparos)throws InvalidDisparoException{
        tableroDisparos.getBarcosNoHundidos().get(0).bombardear(tableroDisparos.getBarcosNoHundidos().get(0).getCeldasNoBombardeadas().get(0));
    }
    @Override
    public Disparo getTipo(){ return Disparo.TERMODIRIGIDO; }
}
