package Modelo.Juego.FactoryBarcos.BarcosParaAstilleroMilitar;

import Modelo.Juego.ElementosPrincipales.Barco;
import Modelo.Juego.ElementosPrincipales.Celda;
import Modelo.Juego.FactoryBarcos.TipoDeBarco;

public class Portaaviones extends Barco {

    private static final int PORTAAVIONES_SIZE = 5;

    public Portaaviones() {
        super(PORTAAVIONES_SIZE, TipoDeBarco.PORTAAVIONES);
    }

    @Override
    public int[][] generarFilasColumnas(char orientacion, Celda celdaCabeza)  {
        return super.barcosRectos(orientacion,celdaCabeza,getPortaavionesSize());
    }
    public static int getPortaavionesSize() {
        return PORTAAVIONES_SIZE;
    }
}
