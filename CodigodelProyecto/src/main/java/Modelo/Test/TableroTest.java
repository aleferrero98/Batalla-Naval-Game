package Modelo.Test;

import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.FactoryBarcos.BarcosParaAstilleroMilitar.Submarino;
import Modelo.Celda;
import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Tablero;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableroTest {

    Submarino s1;
    Celda c1;
    Celda c2;
    Tablero t1;
    Submarino s2;
    @Before
    public void setUp() throws Exception {
        s1 = new Submarino();
        c1 = new Celda(s1,true,4,5);
        c2 = new Celda(4,5);
        t1 = new Tablero(13);
        s2 = new Submarino();
    }

    @Test
    public void bombardear_conBarco(){
        try {
            t1.setBarco(s1,'N',6,6);
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

    @Test
    public void celdasEnTablero(){
        for(int i=0;i<t1.getFilas();i++) {
            for(int j=0;j<t1.getColumnas();j++) {
                assertNotEquals(c2, t1.getCelda(i,j));
            }
        }
    }
    @Test
    public void setBarco()throws InvalidPosicionBarco {
        t1.desactivarTablero();
        t1.setBarco(s1,'N',4,5);
        assertFalse(t1.getBarcosEnTablero().isEmpty());
    }
    @Test
    public void disparoCeldas() throws IndexOutOfBoundsException{
        t1.activarTablero();
        for(int i=0;i<t1.getFilas();i++) {
            for(int j=0;j<t1.getColumnas();j++) {
                try {
                    t1.dispararUna(i,j);
                    assertFalse(t1.getCelda(i,j).isActivada());
                } catch (InvalidDisparoException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test(expected = InvalidPosicionBarco.class)
    public void interseccionBarcos() throws InvalidPosicionBarco{
        t1.desactivarTablero();
        t1.setBarco(s1,'N',5,6);
        t1.setBarco(s2,'N',5,6);
    }

}