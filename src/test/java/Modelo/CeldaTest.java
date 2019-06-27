package Modelo;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Juego.ElementosPrincipales.Celda;
import Modelo.Juego.FactoryBarcos.BarcosParaAstilleroMilitar.Submarino;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CeldaTest {

    Celda c1;
    Celda c2;
    Submarino s1;

    @Before
    public void setUp() throws Exception {
        c1 = new Celda(4,6);
        c2 = new Celda(2,4);
        s1 = new Submarino();
    }

    @Test(expected = InvalidDisparoException.class)
    public void bombardear_porDefecto() throws InvalidDisparoException{
        c1.bombardear();
    }
    @Test
    public void bombardear_conActivado()throws InvalidDisparoException{
        c1.setActivada(true);
        c1.bombardear();
        assertFalse("No esta activada la celda, no hay Barco",c1.isActivada());
    }
    @Test
    public void celdaconBarco(){
        c1.setBarco(s1);
        assertTrue("La celda tiene Barco",true);
    }
    @Test
    public void celdasinBarco(){
        c1.setBarco(null);
        assertFalse("No recibe barcos Nulls",c1.isCeldaConBarco());
        assertFalse("No tiene barcos",c2.isCeldaConBarco());
    }
    @Test
    public void esBarco(){
        c1.setBarco(s1);
        assertEquals(s1,c1.getBarco());
    }
}