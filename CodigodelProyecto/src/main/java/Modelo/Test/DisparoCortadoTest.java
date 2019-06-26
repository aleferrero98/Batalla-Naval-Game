package Modelo.Test;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.StrategyDisparo.Disparo;
import Modelo.StrategyDisparo.DisparoCortado;
import Modelo.Tablero;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisparoCortadoTest {
    DisparoCortado d1;
    Tablero t1;

    @Before
    public void setUp() throws Exception {
        d1 = new DisparoCortado();
        t1 = new Tablero(13);
    }

    @Test
    public void disparar() throws InvalidDisparoException {
        t1.activarTablero();
        d1.disparar(4,3,t1);
        assertFalse(t1.getCelda(4,3).isActivada());
        assertFalse(t1.getCelda(4,5).isActivada());
    }
    @Test
    public void disparar_Fallido() throws InvalidDisparoException{
        boolean disparo_fallo=false;
        t1.activarTablero();
        for(int filas=0;filas<t1.getFilas();filas++){
            try {
                d1.disparar(filas,13,t1);
            }catch (InvalidDisparoException e){
                disparo_fallo = true;
            }
        }
        assertTrue(disparo_fallo);
    }
    @Test
    public void getTipo() {
        assertEquals(Disparo.CORTADO,d1.getTipo());
    }
}