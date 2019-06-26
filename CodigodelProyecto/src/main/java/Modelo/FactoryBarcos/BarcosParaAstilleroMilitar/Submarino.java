package Modelo.FactoryBarcos.BarcosParaAstilleroMilitar;

import Modelo.Celda;
import Modelo.Barco;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.FactoryBarcos.TipoDeBarco;
import Modelo.Tablero;

import java.util.ArrayList;

public class Submarino extends Barco {

    private static final int SUBMARINO_SIZE = 4;

    public Submarino() {
        super(SUBMARINO_SIZE, TipoDeBarco.SUBMARINO);
    }

    @Override
    public int[][] generarFilasColumnas(char orientacion, Celda celdaCabeza) {
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
}
