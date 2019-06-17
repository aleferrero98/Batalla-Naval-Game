package Modelo.FactoryBarcos.BarcosParaAstilleroMilitar;

import Modelo.Celda;
import Modelo.Barco;
import Modelo.FactoryBarcos.TipoDeBarco;
import Modelo.Tablero;

public class Destructor extends Barco {
    private static final int DESTRUCTOR_SIZE = 3;

    public Destructor() {
        super(DESTRUCTOR_SIZE, TipoDeBarco.DESTRUCTOR);
    }

    @Override
    public boolean puedePosicionar(Tablero tablero, char orientacion, Celda celdaCabeza) {
        return false;
    }

    @Override
    public void posicionar(Tablero tablero, char orientacion, Celda celdaCabeza) throws Exception {

    }
}
