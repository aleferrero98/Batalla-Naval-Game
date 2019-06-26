package Modelo.Juego.StrategyDisparo;


import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Juego.ElementosPrincipales.Tablero;

import java.util.Random;


public class DisparoAleatorio implements DisparoBehavior {

    boolean seDisparo;
    int numeroAleatorioFila;
    int numeroAleatorioColumna;

    @Override
    public void disparar(int fila, int columna, Tablero tableroDisparos) throws InvalidDisparoException {
         seDisparo = false;
         busquedaCeldaYDisparo(fila,columna,tableroDisparos);
    }
    @Override
    public Disparo getTipo(){return Disparo.ALEATORIO;}

    public void busquedaCeldaYDisparo(int fila, int columna,Tablero tableroDisparos)throws InvalidDisparoException{
        Random rnd = new Random();
        this.numeroAleatorioFila=(int)(rnd.nextDouble()*tableroDisparos.getFilas());             //Generacion de numero aleatorio para disparar en toda la matriz
        this.numeroAleatorioColumna = ((int)(rnd.nextDouble()*tableroDisparos.getColumnas()));

        if(tableroDisparos.esValido(numeroAleatorioFila,numeroAleatorioColumna)){
            tableroDisparos.dispararUna(numeroAleatorioFila,numeroAleatorioColumna);
            this.seDisparo = true;
        }else{
            disparar(columna,fila,tableroDisparos);     //Busca hasta que puede disparar una celda
        }
    }
    public boolean isSeDisparo() {
        return seDisparo;
    }
    public int getNumeroAleatorioFila() {
        return numeroAleatorioFila;
    }

    public int getNumeroAleatorioColumna() {
        return numeroAleatorioColumna;
    }


}
