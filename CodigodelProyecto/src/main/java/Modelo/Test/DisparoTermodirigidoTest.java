package Modelo.StrategyDisparo;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.FactoryBarcos.BarcosParaAstilleroMilitar.Submarino;
import Modelo.Tablero;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisparoTermodirigidoTest {
    DisparoTermodirigido d1;
    Tablero t1;
    Submarino s1;
    Tablero t2;
    @Before
    public void setUp() throws Exception {
        d1 = new DisparoTermodirigido();
        t1 = new Tablero(13);
        s1 = new Submarino();
        t2 = new Tablero(13);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void disparar_fallo() throws InvalidDisparoException, InvalidPosicionBarco {
        t1.setBarco(s1,'N',5,5);
        t1.activarTablero();
        d1.disparar(3,5,t1);
        d1.disparar(1,5,t1);
        d1.disparar(1,4,t1);
        d1.disparar(1,5,t1);
        d1.disparar(5,1,t1); //Disparo mas veces de las celdas del barco
    }
    @Test
    public void disparar()throws  InvalidPosicionBarco,InvalidDisparoException{
        t1.setBarco(s1,'N',5,5);
        t1.activarTablero();
        d1.disparar(5,6,t1);
        assertNotEquals(4,t1.getBarcosNoHundidos().get(0).getCeldasNoBombardeadas().size());
    }
    @Test
    public void getTipo() {
    }
}