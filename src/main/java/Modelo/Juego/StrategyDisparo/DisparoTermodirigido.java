package Modelo.Juego.StrategyDisparo;


import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Juego.ElementosPrincipales.Tablero;
import Modelo.Juego.ElementosPrincipales.Barco;

public class DisparoTermodirigido implements DisparoBehavior { //Controlar, NO HARIA FALTA RECIBIR FILA Y COLUMNA SI ES TERMIDIRIGIDO
    @Override
    public void disparar(int fila, int columna, Tablero tableroDisparos)throws InvalidDisparoException {
        if(!tableroDisparos.getBarcosNoHundidos().isEmpty()){
            Barco barcoADisparar = tableroDisparos.getBarcosNoHundidos().get(0);
            if(!barcoADisparar.getCeldasNoBombardeadas().isEmpty()){
                fila = barcoADisparar.getCeldasNoBombardeadas().get(0).getFila();
                columna = barcoADisparar.getCeldasNoBombardeadas().get(0).getColumna();
                tableroDisparos.dispararUna(fila,columna);
            }
        }
        else{
            System.out.println("No hay mas lugar");
        }
    }

    @Override
    public Disparo getTipo(){ return Disparo.TERMODIRIGIDO; }
}
