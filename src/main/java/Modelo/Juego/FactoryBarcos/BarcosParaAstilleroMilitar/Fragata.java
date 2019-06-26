package Modelo.Juego.FactoryBarcos.BarcosParaAstilleroMilitar;

import Modelo.Juego.ElementosPrincipales.Barco;
import Modelo.Juego.ElementosPrincipales.Celda;
import Modelo.Juego.FactoryBarcos.TipoDeBarco;

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
