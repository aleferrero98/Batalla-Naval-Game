package Modelo.FactoryBarcos.BarcosParaAstilleroMilitar;

import Modelo.Celda;
import Modelo.Barco;
import Modelo.FactoryBarcos.TipoDeBarco;
import Modelo.Tablero;

public class Canionero extends Barco {
    private static final int CANIONERO_SIZE = 4;

    public Canionero() {
        super(CANIONERO_SIZE, TipoDeBarco.CANIONERO);
    }

    @Override
    public boolean puedePosicionar(Tablero tablero, char orientacion, Celda celdaCabeza) {
        return false;
    }

    @Override
    public void posicionar(Tablero tablero, char orientacion, Celda celdaCabeza) throws Exception {

    }
}
