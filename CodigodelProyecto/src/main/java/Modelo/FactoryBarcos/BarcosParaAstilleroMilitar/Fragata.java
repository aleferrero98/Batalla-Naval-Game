package Modelo.FactoryBarcos.BarcosParaAstilleroMilitar;

import Modelo.Celda;
import Modelo.Barco;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.FactoryBarcos.TipoDeBarco;
import Modelo.Tablero;

public class Fragata extends Barco {

    private static final int FRAGATA_SIZE = 2;

    public Fragata() {
        super(FRAGATA_SIZE, TipoDeBarco.FRAGATA);
    }

    public int[][] generarFilasColumnas(char orientacion, Celda celdaCabeza) {
        return super.barcosRectos(orientacion,celdaCabeza,getFragataSize());
    }
    public static int getFragataSize() {
        return FRAGATA_SIZE;
    }
}
