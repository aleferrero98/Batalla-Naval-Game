package Modelo.Juego.FactoryBarcos.BarcosParaAstilleroMilitar;

import Modelo.Juego.ElementosPrincipales.Barco;
import Modelo.Juego.ElementosPrincipales.Celda;
import Modelo.Juego.FactoryBarcos.TipoDeBarco;

public class Destructor extends Barco {

    private static final int DESTRUCTOR_SIZE = 3;

    public Destructor() {
        super(DESTRUCTOR_SIZE, TipoDeBarco.DESTRUCTOR);
    }

    @Override
    public int[][] generarFilasColumnas(char orientacion, Celda celdaCabeza)  {
        return super.barcosRectos(orientacion,celdaCabeza,getDestructorSize());
    }
    public static int getDestructorSize() {
        return DESTRUCTOR_SIZE;
    }
}
