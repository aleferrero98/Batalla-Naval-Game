package Modelo.Test;

import Modelo.FactoryBarcos.BarcosParaAstilleroMilitar.Submarino;
import Modelo.Celda;
import Modelo.StrategyDisparo.InvalidDisparoException;
import Modelo.Tablero;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CeldaTest {

    Submarino s1;
    Celda c1;
    Celda c2;
    Tablero t1;

    @Before
    public void setUp() throws Exception {
        s1 = new Submarino();
        c1 = new Celda(s1,true,4,5);
        c2 = new Celda(4,5);
        t1 = new Tablero(13);
    }

    @Test
    public void bombardear(){
        try {
            t1.setBarco(s1,'N',t1.getCelda(6,6));
        } catch (Exception e) {
            e.printStackTrace();
        }
        t1.activarTablero();
        try {
            t1.dispararUna(6,6);
        } catch (InvalidDisparoException e) {
            e.printStackTrace();
        }
        assertFalse("Se pudo BOMBARDEAR",t1.getCelda(6,6).isActivada());
    }
}