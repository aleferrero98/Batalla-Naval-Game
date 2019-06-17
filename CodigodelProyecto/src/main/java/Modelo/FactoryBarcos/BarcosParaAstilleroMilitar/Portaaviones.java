package Modelo.FactoryBarcos.BarcosParaAstilleroMilitar;

import Modelo.Celda;
import Modelo.Barco;
import Modelo.FactoryBarcos.TipoDeBarco;
import Modelo.Tablero;

public class Portaaviones extends Barco {
    private static final int PORTAAVIONES_SIZE = 5;

    public Portaaviones() {
        super(PORTAAVIONES_SIZE, TipoDeBarco.PORTAAVIONES);
    }

    @Override
    public boolean puedePosicionar(Tablero tablero, char orientacion, Celda celdaCabeza) {
        return false;
    }

    @Override
    public void posicionar(Tablero tablero, char orientacion, Celda celdaCabeza) throws Exception {

    }
}
