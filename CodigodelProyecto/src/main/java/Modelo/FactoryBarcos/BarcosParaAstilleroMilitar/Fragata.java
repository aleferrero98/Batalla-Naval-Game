package Modelo.FactoryBarcos.BarcosParaAstilleroMilitar;

import Modelo.Celda;
import Modelo.Barco;
import Modelo.FactoryBarcos.TipoDeBarco;
import Modelo.Tablero;

public class Fragata extends Barco {

    private static final int FRAGATA_SIZE = 2;

    public Fragata() {
        super(FRAGATA_SIZE, TipoDeBarco.FRAGATA);
    }

    @Override
    public boolean puedePosicionar(Tablero tablero, char orientacion, Celda celdaCabeza) {
        return false;
    }

    @Override
    public void posicionar(Tablero tablero, char orientacion, Celda celdaCabeza) throws Exception {

    }
}
