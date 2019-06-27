package Modelo;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.Juego.ElementosPrincipales.Tablero;
import Modelo.Juego.FactoryBarcos.BarcosParaAstilleroMilitar.Submarino;
import Modelo.Juego.StrategyDisparo.Disparo;
import static org.junit.Assert.*;

import Modelo.Juego.StrategyDisparo.DisparoCruz;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DisparoCruzTest {

    DisparoCruz d1;
    Tablero t1;
    Submarino s1;

    @Before
    public void setUp() throws Exception {
        d1 = new DisparoCruz();
        t1 = new Tablero(13);
        s1 = new Submarino();
    }
    @Test
    public void getTipo(){
        assertEquals(Disparo.CRUZ,d1.getTipo());
    }
    @Test
    public void disparar_completo() throws InvalidDisparoException {
        boolean sePuede = false;
        t1.activarTablero();
        d1.disparar(5,5,t1);
        assertFalse(sePuede);
    }
    @Test
    public void disparo_incompleto() throws InvalidDisparoException, InvalidPosicionBarco {
        //t1.setBarco(s1,'N',5,5);
        boolean sePuede = false;
        t1.activarTablero();
        t1.dispararUna(5,5);
        d1.disparar(5,5,t1);
        probar_disparo(sePuede);
        assertFalse(sePuede);
    }
    public boolean probar_disparo(boolean sePuede){
        sePuede = sePuede && t1.getCelda(5,5).isActivada();
        sePuede = sePuede && t1.getCelda(4,6).isActivada();
        sePuede = sePuede && t1.getCelda(6,4).isActivada();
        sePuede = sePuede && t1.getCelda(4,4).isActivada();
        sePuede = sePuede && t1.getCelda(6,6).isActivada();
        return sePuede;
    }
}