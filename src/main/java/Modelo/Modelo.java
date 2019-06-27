package Modelo;

import Controlador.Avatar;
import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.Juego.ElementosPrincipales.EstadoDelJuego;
import Modelo.Juego.ElementosPrincipales.JuegoBatallaNaval;
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
        else{}
    }

    public void puedeDisparar(boolean b) {
        if(b)juegoBatallaNaval.habilitarDisparos();
        else juegoBatallaNaval.desHabilitarDisparos();
    }

    public void dispararEn(int fila, int columna) throws InvalidDisparoException {
        juegoBatallaNaval.getJugador1().disparar(fila,columna);
        juegoBatallaNaval.actualizarMatrizJ2();
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

    public void setBarcoActual(char orientacion, int fila, int columna) throws InvalidPosicionBarco {
        juegoBatallaNaval.colocarBarcoJ1(orientacion,fila,columna);
        juegoBatallaNaval.actualizarMatrizJ1();
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

    public void crearJuego() {
        this.estadoDelJuego = new EstadoDelJuego();
        this.juegoBatallaNaval = new JuegoBatallaNaval(estadoDelJuego);
        notifyObservers();
    }

    public boolean estaListoParaJugar() {
        return (this.estadoDelJuego.todosPosicionados());
    }

    /**
     * deberia iniciar el cronometro(no lo hace)
     * incicia la seccion de disparos del juego
     * comenzando por el jugador 1
     */
    public void runJuego() {
        estadoDelJuego.setEsTurnoDelJ1(true);
        notifyObservers();
    }

    public EstadoDelJuego getEstadoDelJuego(){
        return this.estadoDelJuego;
    }

}
