package Modelo;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Juego.ElementosPrincipales.Tablero;
import Modelo.Juego.StrategyDisparo.Disparo;
import Modelo.Juego.StrategyDisparo.DisparoComun;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DisparoComunTest {
    DisparoComun d1;
    Tablero t1;

    @Before
    public void setUp() throws Exception {
        d1 = new DisparoComun();
        t1 = new Tablero(13);
    }

    @Test
    public void disparar() throws InvalidDisparoException {
        t1.activarTablero();
        d1.disparar(5,2,t1);
        assertFalse(t1.getCelda(5,2).isActivada());
    }

    @Test
    public void getTipo() {
        assertTrue(d1.getTipo()==Disparo.COMUN);
    }
}