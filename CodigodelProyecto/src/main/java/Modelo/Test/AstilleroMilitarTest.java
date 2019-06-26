package Modelo.Test;

import Modelo.Barco;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.FactoryBarcos.AstilleroMilitar;
import Modelo.FactoryBarcos.TipoDeBarco;
import Modelo.Tablero;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AstilleroMilitarTest {

    AstilleroMilitar a1;
    Tablero t1;
    @Before
    public void setUp() throws Exception {
        a1 = new AstilleroMilitar();
        t1 = new Tablero(13);
    }

    @Test
    public void construirBarco() {
        ArrayList<Barco> listaBarcos = generarListaBarcos();
        assertEquals(5,listaBarcos.size());
        assertEquals(TipoDeBarco.CANIONERO,listaBarcos.get(0).getTipoDeBarco());
        assertEquals(TipoDeBarco.DESTRUCTOR,listaBarcos.get(1).getTipoDeBarco());
        assertEquals(TipoDeBarco.FRAGATA,listaBarcos.get(2).getTipoDeBarco());
        assertEquals(TipoDeBarco.PORTAAVIONES,listaBarcos.get(3).getTipoDeBarco());
        assertEquals(TipoDeBarco.SUBMARINO,listaBarcos.get(4).getTipoDeBarco());
    }
    public ArrayList<Barco> generarListaBarcos(){
        ArrayList<Barco> listaBarcos = new ArrayList<>();
        for(TipoDeBarco recorrer : TipoDeBarco.values()){
            listaBarcos.add(a1.construirBarco(recorrer));
        }
        return listaBarcos;
    }
    @Test
    public void comprobar_Lugares_NORTE_validos() throws InvalidPosicionBarco {
        ArrayList<Barco> listaBarcos = generarListaBarcos();
        t1.setBarco(listaBarcos.get(0),'N',4,3);
        t1.setBarco(listaBarcos.get(1),'N',7,7);
        t1.setBarco(listaBarcos.get(2),'N',10,10);
        t1.setBarco(listaBarcos.get(3),'N',6,6);
        t1.setBarco(listaBarcos.get(4),'N',8,1);
        assertEquals(5,t1.getBarcosEnTablero().size());
        t1.activarTablero();
        //CANIONERO
        assertTrue(t1.getCelda(4,3).isCeldaConBarco());
        assertTrue(t1.getCelda(3,3).isCeldaConBarco());
        assertTrue(t1.getCelda(2,3).isCeldaConBarco());
        assertTrue(t1.getCelda(1,3).isCeldaConBarco());
        //DESTRUCTOR
        assertTrue(t1.getCelda(5,7).isCeldaConBarco());
        assertTrue(t1.getCelda(6,7).isCeldaConBarco());
        assertTrue(t1.getCelda(7,7).isCeldaConBarco());
        //FRAGATA
        assertTrue(t1.getCelda(9,10).isCeldaConBarco());
        assertTrue(t1.getCelda(10,10).isCeldaConBarco());
        //PORTAAVIONES
        assertTrue(t1.getCelda(2,6).isCeldaConBarco());
        assertTrue(t1.getCelda(3,6).isCeldaConBarco());
        assertTrue(t1.getCelda(4,6).isCeldaConBarco());
        assertTrue(t1.getCelda(5,6).isCeldaConBarco());
        assertTrue(t1.getCelda(6,6).isCeldaConBarco());
        //SUBMARINO
        assertTrue(t1.getCelda(8,0).isCeldaConBarco());
        assertTrue(t1.getCelda(8,1).isCeldaConBarco());
        assertTrue(t1.getCelda(8,2).isCeldaConBarco());
        assertTrue(t1.getCelda(9,1).isCeldaConBarco());
    }
    @Test
    public void comprobar_Lugares_SUR_validos() throws InvalidPosicionBarco {
        ArrayList<Barco> listaBarcos = generarListaBarcos();
        t1.setBarco(listaBarcos.get(0),'S',4,3);
        t1.setBarco(listaBarcos.get(1),'S',7,7);
        t1.setBarco(listaBarcos.get(2),'S',10,10);
        t1.setBarco(listaBarcos.get(3),'S',6,6);
        t1.setBarco(listaBarcos.get(4),'S',8,1);
        assertEquals(5,t1.getBarcosEnTablero().size());
        t1.activarTablero();
        //CANIONERO
        assertTrue(t1.getCelda(4,3).isCeldaConBarco());
        assertTrue(t1.getCelda(5,3).isCeldaConBarco());
        assertTrue(t1.getCelda(6,3).isCeldaConBarco());
        assertTrue(t1.getCelda(7,3).isCeldaConBarco());
        //DESTRUCTOR
        assertTrue(t1.getCelda(7,7).isCeldaConBarco());
        assertTrue(t1.getCelda(8,7).isCeldaConBarco());
        assertTrue(t1.getCelda(9,7).isCeldaConBarco());
        //FRAGATA
        assertTrue(t1.getCelda(10,10).isCeldaConBarco());
        assertTrue(t1.getCelda(11,10).isCeldaConBarco());
        //PORTAAVIONES
        assertTrue(t1.getCelda(6,6).isCeldaConBarco());
        assertTrue(t1.getCelda(7,6).isCeldaConBarco());
        assertTrue(t1.getCelda(8,6).isCeldaConBarco());
        assertTrue(t1.getCelda(9,6).isCeldaConBarco());
        assertTrue(t1.getCelda(10,6).isCeldaConBarco());
        //SUBMARINO
        assertTrue(t1.getCelda(8,0).isCeldaConBarco());
        assertTrue(t1.getCelda(8,1).isCeldaConBarco());
        assertTrue(t1.getCelda(8,2).isCeldaConBarco());
        assertTrue(t1.getCelda(7,1).isCeldaConBarco());
    }
    @Test
    public void comprobar_Lugares_ESTE_validos() throws InvalidPosicionBarco {
        ArrayList<Barco> listaBarcos = generarListaBarcos();
        t1.setBarco(listaBarcos.get(0),'E',4,3);
        t1.setBarco(listaBarcos.get(1),'E',7,7);
        t1.setBarco(listaBarcos.get(2),'E',10,10);
        t1.setBarco(listaBarcos.get(3),'E',6,6);
        t1.setBarco(listaBarcos.get(4),'E',8,1);
        assertEquals(5,t1.getBarcosEnTablero().size());
        t1.activarTablero();
        //CANIONERO
        assertTrue(t1.getCelda(4,3).isCeldaConBarco());
        assertTrue(t1.getCelda(4,4).isCeldaConBarco());
        assertTrue(t1.getCelda(4,5).isCeldaConBarco());
        assertTrue(t1.getCelda(4,6).isCeldaConBarco());
        //DESTRUCTOR
        assertTrue(t1.getCelda(7,7).isCeldaConBarco());
        assertTrue(t1.getCelda(7,8).isCeldaConBarco());
        assertTrue(t1.getCelda(7,9).isCeldaConBarco());
        //FRAGATA
        assertTrue(t1.getCelda(10,10).isCeldaConBarco());
        assertTrue(t1.getCelda(10,11).isCeldaConBarco());
        //PORTAAVIONES
        assertTrue(t1.getCelda(6,6).isCeldaConBarco());
        assertTrue(t1.getCelda(6,7).isCeldaConBarco());
        assertTrue(t1.getCelda(6,8).isCeldaConBarco());
        assertTrue(t1.getCelda(6,9).isCeldaConBarco());
        assertTrue(t1.getCelda(6,10).isCeldaConBarco());
        //SUBMARINO
        assertTrue(t1.getCelda(7,1).isCeldaConBarco());
        assertTrue(t1.getCelda(8,1).isCeldaConBarco());
        assertTrue(t1.getCelda(9,1).isCeldaConBarco());
        assertTrue(t1.getCelda(8,0).isCeldaConBarco());
    }
    @Test
    public void comprobar_Lugares_OESTE_validos() throws InvalidPosicionBarco {
        ArrayList<Barco> listaBarcos = generarListaBarcos();
        t1.setBarco(listaBarcos.get(0),'O',4,3);
        t1.setBarco(listaBarcos.get(1),'O',7,7);
        t1.setBarco(listaBarcos.get(2),'O',10,10);
        t1.setBarco(listaBarcos.get(3),'O',6,6);
        t1.setBarco(listaBarcos.get(4),'O',8,1);
        assertEquals(5,t1.getBarcosEnTablero().size());
        t1.activarTablero();
        //CANIONERO
        assertTrue(t1.getCelda(4,3).isCeldaConBarco());
        assertTrue(t1.getCelda(4,2).isCeldaConBarco());
        assertTrue(t1.getCelda(4,1).isCeldaConBarco());
        assertTrue(t1.getCelda(4,0).isCeldaConBarco());
        //DESTRUCTOR
        assertTrue(t1.getCelda(7,7).isCeldaConBarco());
        assertTrue(t1.getCelda(7,6).isCeldaConBarco());
        assertTrue(t1.getCelda(7,5).isCeldaConBarco());
        //FRAGATA
        assertTrue(t1.getCelda(10,9).isCeldaConBarco());
        assertTrue(t1.getCelda(10,10).isCeldaConBarco());
        //PORTAAVIONES
        assertTrue(t1.getCelda(6,6).isCeldaConBarco());
        assertTrue(t1.getCelda(6,5).isCeldaConBarco());
        assertTrue(t1.getCelda(6,4).isCeldaConBarco());
        assertTrue(t1.getCelda(6,3).isCeldaConBarco());
        assertTrue(t1.getCelda(6,2).isCeldaConBarco());
        //SUBMARINO
        assertTrue(t1.getCelda(8,1).isCeldaConBarco());
        assertTrue(t1.getCelda(8,2).isCeldaConBarco());
        assertTrue(t1.getCelda(7,1).isCeldaConBarco());
        assertTrue(t1.getCelda(9,1).isCeldaConBarco());
    }
}