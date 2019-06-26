package Modelo;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.Juego.ElementosPrincipales.Tablero;
import Modelo.Juego.FactoryBarcos.BarcosParaAstilleroMilitar.Submarino;
import Modelo.Juego.StrategyDisparo.Disparo;
import Modelo.Juego.StrategyDisparo.DisparoAleatorio;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DisparoAleatorioTest {

    DisparoAleatorio d1;
    Submarino s1;
    Tablero t1;

    @Before
    public void setUp() throws Exception {
        d1 = new DisparoAleatorio();
        s1 = new Submarino();
        t1 = new Tablero(13);
    }

    @Test
    public void disparar() throws InvalidPosicionBarco, InvalidDisparoException {
        t1.setBarco(s1,'N',4,5);
        t1.activarTablero();
        d1.disparar(4,5,t1);
        String disparosFC = "Fila: "+d1.getNumeroAleatorioFila()+" Columna: "+d1.getNumeroAleatorioColumna();
        System.out.println(disparosFC);
        assertTrue(d1.isSeDisparo());
    }

    @Test
    public void getTipo() {
        assertEquals(Disparo.ALEATORIO,d1.getTipo());
    }
}