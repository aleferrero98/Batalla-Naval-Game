package Modelo.FactoryBarcos;

import Modelo.Celda;
import Modelo.Tablero;

public class Portaaviones extends Barco{




    @Override
    public boolean puedePosicionar(Tablero tablero, char orientacion, Celda celdaCabeza) {
        return false;
    }

    @Override
    public void posicionar(Tablero tablero, char orientacion, Celda celdaCabeza) throws Exception {

    }
}
