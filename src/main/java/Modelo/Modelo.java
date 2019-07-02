package Modelo;

import Controlador.Avatar;
import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.Juego.ElementosPrincipales.EstadoDelJuego;
import Modelo.Juego.ElementosPrincipales.JuegoBatallaNaval;
import Modelo.Juego.ElementosPrincipales.Jugador;
import Modelo.Juego.FactoryBarcos.TipoDeBarco;
import Modelo.Juego.StrategyDisparo.Disparo;
import Modelo.Juego.StrategyDisparo.DisparoBehavior;

import java.awt.*;
import java.util.ArrayList;

public class Modelo implements Observable {
    private ArrayList<Observer> observers;
    private JuegoBatallaNaval juegoBatallaNaval;
    private EstadoDelJuego estadoDelJuego;

    private String nombreJ1;
    private Avatar avatarJ1;
    private boolean estaRegistradoJ1;

    public Modelo(){
        observers = new ArrayList<>();
    }


    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) o.update();
    }

    public JuegoBatallaNaval getJuego(){return null;} //HACER

    public void setDisparo(Disparo d) {
        if(juegoBatallaNaval.getJugador1().disparoDisponible(d)){
            juegoBatallaNaval.setDisparoJ1(d);
            notifyObservers();
        }
        else{
            juegoBatallaNaval.setDisparoJ1(Disparo.COMUN);
            notifyObservers();
        }
    }

    public void puedeDisparar(boolean b) {
        if(b)juegoBatallaNaval.habilitarDisparos();
        else juegoBatallaNaval.desHabilitarDisparos();
    }

    public void dispararEn(int fila, int columna) throws InvalidDisparoException {
        juegoBatallaNaval.getJugador1().disparar(fila,columna);
        juegoBatallaNaval.actualizarMatrizJ2();
        checkGanador();
        notifyObservers();
        juegoBatallaNaval.disparaMaquina();
        juegoBatallaNaval.actualizarMatrizJ1();
        checkGanador();
        notifyObservers();
    }

    public void pausar(boolean b) {
        //si true parar el cronometro
        //si false seguir contando
        notifyObservers();
    }

    public void selecBarco(TipoDeBarco b) {
        juegoBatallaNaval.barcoActualJ1(b);
    }
    public JuegoBatallaNaval getJuegoBatallaNaval(){
        return juegoBatallaNaval;
    }

    public void setBarcoActual(char orientacion, int fila, int columna) throws InvalidPosicionBarco {
        juegoBatallaNaval.colocarBarcoJ1(orientacion,fila,columna);
        juegoBatallaNaval.actualizarMatrizJ1();
        if(juegoBatallaNaval.getJugador1().todosLosBarcosColocados()){
            estadoDelJuego.setBarcosJ1Posicionados(true);
        }
        notifyObservers();
    }

    public void puedePonerBarcos(boolean b) {
        if(b) juegoBatallaNaval.habilitarBarcos();
        else juegoBatallaNaval.deshabilitarBarcos();
    }

    public void registrarJugador1(Avatar avatar, String nombre) {
        this.nombreJ1 = nombre;
        this.avatarJ1 = avatar;
        this.estaRegistradoJ1 = true;
        notifyObservers();
    }

    public void sonido(boolean b) {
        //true habilita sonido
        //false deshabilita sonido
        notifyObservers();
    }

    public boolean estaRegistrado() {
        return estaRegistradoJ1;
    }

    public void crearJuego(){
        this.estadoDelJuego = new EstadoDelJuego();
        this.juegoBatallaNaval = new JuegoBatallaNaval(estadoDelJuego);
        notifyObservers();
        try {
            this.juegoBatallaNaval.setBarcosMaquina();
        }catch(InvalidPosicionBarco e){
            System.out.println("ERROR: NO SE PUEDEN SETEAR BARCOS DE LA MAQUINA");
        }
        notifyObservers();
    }

    public boolean estaListoParaJugar() {
        return (this.estadoDelJuego.todosPosicionados());
        //return true;

    }

    /**
     * deberia iniciar el cronometro(no lo hace)
     * incicia la seccion de disparos del juego
     * comenzando por el jugador 1
     */
    public void runJuego() {
        estadoDelJuego.setEsTurnoDelJ1(true);
        juegoBatallaNaval.habilitarDisparos();
        notifyObservers();
    }

    public EstadoDelJuego getEstadoDelJuego(){
        return this.estadoDelJuego;
    }

    public void checkGanador(){
        if(juegoBatallaNaval.getJugador1().getTableroBarcos().barcosTodosHundidos())
            this.estadoDelJuego.setGanoJ2(true);
        else if(juegoBatallaNaval.getJugador1().getTableroBarcos().barcosTodosHundidos())
            this.estadoDelJuego.setGanoJ1(true);
    }

    public boolean ganoJ1(){
        return this.estadoDelJuego.isGanoJ1();
    }

    public boolean ganoJ2(){
        return this.estadoDelJuego.isGanoJ2();
    }

    public String getNombreJ1() {
        return nombreJ1;
    }
}
