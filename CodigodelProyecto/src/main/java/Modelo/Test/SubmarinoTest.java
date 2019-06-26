package Modelo.Test;

import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.FactoryBarcos.BarcosParaAstilleroMilitar.Submarino;
import Modelo.Tablero;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubmarinoTest {
    Submarino s1;
    Tablero t1;

    @Before
    public void setUp() throws Exception {
        s1 = new Submarino();
        t1 = new Tablero(13);
    }

    @Test
    public void puedePosicionar() {
        assertTrue(s1.puedePosicionar(t1,'N',t1.getCelda(5,6)));
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void noPuedePosicionar(){
        assertTrue(s1.puedePosicionar(t1,'N',t1.getCelda(13,13)));
        assertTrue(s1.puedePosicionar(t1,'N',t1.getCelda(0,0)));
        assertTrue(s1.puedePosicionar(t1,'N',t1.getCelda(0,13)));
        assertTrue(s1.puedePosicionar(t1,'N',t1.getCelda(13,0)));
    }

    @Test
    public void posicionar() throws InvalidPosicionBarco {
        s1.posicionar(t1,'N',t1.getCelda(5,6));
        assertFalse(s1.hundido());
        assertTrue(s1.getCeldasNoBombardeadas().size()==s1.getSize());
        assertTrue(s1.getCeldasTotales().size()==s1.getSize());
        assertTrue(s1.getOrientacion()=='N');
        assertTrue(s1.getCeldaCabeza()==t1.getCelda(5,6));
    }
}