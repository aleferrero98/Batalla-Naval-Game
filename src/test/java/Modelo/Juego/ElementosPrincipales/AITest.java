package Modelo;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.Juego.ElementosPrincipales.AI;
import Modelo.Juego.ElementosPrincipales.Barco;
import Modelo.Juego.ElementosPrincipales.Tablero;
import Modelo.Juego.StrategyDisparo.*;
import Modelo.Juego.FactoryBarcos.TipoDeBarco;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class AITest {
    Tablero tableroDisparo;
    Tablero tableroBarcos;
    HashMap<Disparo,Integer> disparosDisponibles;
    HashMap<TipoDeBarco,Integer> barcosDisponibles;
    AI jugador2;

    @Before
    public void setUp() throws Exception {
        tableroBarcos = new Tablero(13);
        tableroDisparo = new Tablero(13);
        jugador2 = new AI(tableroBarcos,tableroDisparo);
/*
        - 2 disparos Aleatorios
        - 1 disparo Termodirigido
        - 1 disparo Cruz
        - 2 disparos Cortados
        - Ilimitados disparos comunes
        */
        disparosDisponibles = new HashMap<>();
        disparosDisponibles.put(Disparo.ALEATORIO,2);
        disparosDisponibles.put(Disparo.TERMODIRIGIDO,1);
        disparosDisponibles.put(Disparo.CRUZ,1);
        disparosDisponibles.put(Disparo.CORTADO,2);
        disparosDisponibles.put(Disparo.COMUN,tableroDisparo.getFilas()*tableroDisparo.getColumnas());

        /*
            - 1 Portaaviones: ocupa 5 casillas
            - 1 Submarinos: ocupa 4 casillas(formando una T).
            - 1 Cañonero: ocupa 4 casillas.
            - 2 Destructores: ocupan 3 casillas.
            - 1 Fragatas: ocupan 2 casilla.
         */
        barcosDisponibles = new HashMap<>();
        barcosDisponibles.put(TipoDeBarco.PORTAAVIONES,1);
        barcosDisponibles.put(TipoDeBarco.SUBMARINO,1);
        barcosDisponibles.put(TipoDeBarco.CANIONERO,1);
        barcosDisponibles.put(TipoDeBarco.DESTRUCTOR,2);
        barcosDisponibles.put(TipoDeBarco.FRAGATA,1);
    }

    @Test
    public void setDisparosDisponibles() {
        jugador2.setDisparosDisponibles(disparosDisponibles);
        assertTrue(jugador2.getDisparosDisponibles().size()==5);
    }

    @Test
    public void setBarcosDisponibles() {
        jugador2.setBarcosDisponibles(barcosDisponibles);
        assertTrue(jugador2.getBarcosDisponibles().size()==5);
    }

    @Test
    public void disparoAleatorio() {
        try{
            jugador2.setDisparosDisponibles(disparosDisponibles);
            jugador2.getTableroDisparos().activarTablero();
            jugador2.disparoAleatorio();
        }catch(InvalidDisparoException e){
            e.printStackTrace();
        }
        assertTrue(cambioTablero());
    }

    @Test
    public void multiplesDisparos(){
        try{
            jugador2.setDisparosDisponibles(disparosDisponibles);
            jugador2.getTableroDisparos().activarTablero();
            for(int i=0;i<15;i++){
                jugador2.disparoAleatorio();
            }
        }catch(InvalidDisparoException e){
            e.printStackTrace();
        }
        assertTrue(cambioTablero());
    }
    private boolean cambioTablero(){
        for(int i = 0 ; i<tableroDisparo.getFilas();i++) {
            for(int j=0;j<tableroDisparo.getColumnas();j++){
                if(!tableroDisparo.getCelda(i,j).isActivada()){
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void disparoDisponible() {
        jugador2.setDisparosDisponibles(disparosDisponibles);
        jugador2.getTableroDisparos().activarTablero();
        jugador2.actualizarDisparosDisponibles(Disparo.TERMODIRIGIDO);
        assertFalse(jugador2.disparoDisponible(Disparo.TERMODIRIGIDO));
        jugador2.actualizarDisparosDisponibles(Disparo.CRUZ);
        assertFalse(jugador2.disparoDisponible(Disparo.CRUZ));
        jugador2.actualizarDisparosDisponibles(Disparo.CORTADO);
        assertTrue(jugador2.disparoDisponible(Disparo.CORTADO));
        jugador2.actualizarDisparosDisponibles(Disparo.ALEATORIO);
        assertTrue(jugador2.disparoDisponible(Disparo.ALEATORIO));
        jugador2.actualizarDisparosDisponibles(Disparo.COMUN);
        assertTrue(jugador2.disparoDisponible(Disparo.COMUN));
    }

    @Test
    public void actualizarDisparosDisponibles() {
        jugador2.setDisparosDisponibles(disparosDisponibles);
        jugador2.actualizarDisparosDisponibles(Disparo.TERMODIRIGIDO);
        assertEquals(0,jugador2.getDisparosDisponibles().get(Disparo.TERMODIRIGIDO),0.5);
        jugador2.actualizarDisparosDisponibles(Disparo.CRUZ);
        assertEquals(0,jugador2.getDisparosDisponibles().get(Disparo.CRUZ),0.5);
        jugador2.actualizarDisparosDisponibles(Disparo.CORTADO);
        assertEquals(1,jugador2.getDisparosDisponibles().get(Disparo.CORTADO),0.5);
        jugador2.actualizarDisparosDisponibles(Disparo.ALEATORIO);
        assertEquals(1,jugador2.getDisparosDisponibles().get(Disparo.ALEATORIO),0.5);
        jugador2.actualizarDisparosDisponibles(Disparo.COMUN);
        assertEquals(jugador2.getTableroDisparos().getColumnas()*jugador2.getTableroDisparos().getFilas()-1,jugador2.getDisparosDisponibles().get(Disparo.COMUN),0.5);
    }

    @Test
    public void colocarTodosBarcos() {
        try{
            jugador2.setBarcosDisponibles(barcosDisponibles);
            jugador2.colocarTodosBarcos();
        }catch (InvalidPosicionBarco e) {
            e.printStackTrace();
        }
        assertEquals(6,jugador2.getTableroBarcos().getBarcosEnTablero().size(),0.4);
    }
}