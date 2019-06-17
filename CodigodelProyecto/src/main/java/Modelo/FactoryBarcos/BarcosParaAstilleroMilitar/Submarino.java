package Modelo.FactoryBarcos.BarcosParaAstilleroMilitar;

import Modelo.Celda;
import Modelo.Barco;
import Modelo.FactoryBarcos.TipoDeBarco;
import Modelo.Tablero;

import java.util.ArrayList;

public class Submarino extends Barco {
    private static final int SUBMARINO_SIZE = 4;

    public Submarino() {
        super(SUBMARINO_SIZE, TipoDeBarco.SUBMARINO);
    }
    @Override
    public boolean puedePosicionar(Tablero tablero, char orientacion, Celda celdaCabeza) {
        ArrayList<Celda> celdasPosibles;
        try {
            celdasPosibles = this.celdasParaEsteBarco(tablero, orientacion, celdaCabeza);
        }
        catch(IndexOutOfBoundsException e) {
            return false;   //la excepcion que puede saltar es la de getCelda, osea que no se puede posicionar porque me sali del tablero
        }
        for(Celda celda: celdasPosibles){
            if(celda.isCeldaConBarco() || celda.isActivada()){
                return false; //si alguna de las posibles celdas ya tiene barco o esta activada no se puede posicionar
            }
        }
        return true; //si llego hasta aca ninguna dio false, entonces puede posicionarse en estas celdas
    }

    private int[][] generarFilasColumnas(char orientacion, Celda celdaCabeza) {
        int[][] posiblesFilasColumnas = new int[SUBMARINO_SIZE][2];
        int filaCabeza = celdaCabeza.getFila();
        int columnaCabeza = celdaCabeza.getColumna();
        posiblesFilasColumnas[0][0] = filaCabeza;
        posiblesFilasColumnas[0][1] = columnaCabeza;
        if(orientacion == 'N'){                             //esta parte se entiende haciendo el dibujito
            posiblesFilasColumnas[1][0] = filaCabeza;
            posiblesFilasColumnas[1][1] = columnaCabeza-1;
            posiblesFilasColumnas[2][0] = filaCabeza+1;
            posiblesFilasColumnas[2][1] = columnaCabeza;
            posiblesFilasColumnas[3][0] = filaCabeza;
            posiblesFilasColumnas[3][1] = columnaCabeza+1;
        }
        else if(orientacion == 'S'){
            posiblesFilasColumnas[1][0] = filaCabeza;
            posiblesFilasColumnas[1][1] = columnaCabeza+1;
            posiblesFilasColumnas[2][0] = filaCabeza-1;
            posiblesFilasColumnas[2][1] = columnaCabeza;
            posiblesFilasColumnas[3][0] = filaCabeza;
            posiblesFilasColumnas[3][1] = columnaCabeza-1;
        }
        else if(orientacion == 'E'){
            posiblesFilasColumnas[1][0] = filaCabeza-1;
            posiblesFilasColumnas[1][1] = columnaCabeza;
            posiblesFilasColumnas[2][0] = filaCabeza;
            posiblesFilasColumnas[2][1] = columnaCabeza-1;
            posiblesFilasColumnas[3][0] = filaCabeza+1;
            posiblesFilasColumnas[3][1] = columnaCabeza;
        }
        else if(orientacion == 'O'){
            posiblesFilasColumnas[1][0] = filaCabeza+1;
            posiblesFilasColumnas[1][1] = columnaCabeza;
            posiblesFilasColumnas[2][0] = filaCabeza;
            posiblesFilasColumnas[2][1] = columnaCabeza+1;
            posiblesFilasColumnas[3][0] = filaCabeza-1;
            posiblesFilasColumnas[3][1] = columnaCabeza;
        }
        return posiblesFilasColumnas;
    }

    private ArrayList<Celda> celdasParaEsteBarco(Tablero tablero,char orientacion, Celda celdaCabeza)throws IndexOutOfBoundsException
    {
        int[][] posiblesFilasColumnas = generarFilasColumnas(orientacion, celdaCabeza);
        ArrayList<Celda> celdasParaEsteBarco = tablero.parseToCeldasDelTablero(posiblesFilasColumnas);
        return celdasParaEsteBarco;
    }


    @Override
    public void posicionar(Tablero tablero, char orientacion, Celda celdaCabeza) throws Exception {
        if(puedePosicionar(tablero,orientacion,celdaCabeza)){
            ArrayList<Celda> celdas = this.celdasParaEsteBarco(tablero, orientacion, celdaCabeza);
            for(Celda celda: celdas){
                celda.setBarco(this);
            }
            super.setCeldasTotales(celdas);
            super.setCeldasNoBombardeadas(celdas);
            super.setCeldaCabeza(celdaCabeza);
            super.setOrientacion(orientacion);
        }

    }
}
