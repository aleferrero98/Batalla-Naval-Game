package Modelo;

import Controlador.Avatar;
import Modelo.Juego.ElementosPrincipales.JuegoBatallaNaval;
import Modelo.Juego.FactoryBarcos.TipoDeBarco;
import Modelo.Juego.StrategyDisparo.Disparo;

import java.awt.*;
import java.util.ArrayList;

public class Modelo implements Observable {
    private ArrayList<Observer> observers;
    private JuegoBatallaNaval juegoBatallaNaval;


    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) o.update();
    }

    public void setDisparo(Disparo d) {
    }

    public void dispararEn(int fila, int columna) {
    }

    public void pausar(boolean b) {
    }

    public void selecBarco(TipoDeBarco b) {
    }

    public void setBarcoActual(char orientacion, int fila, int columna) {
    }

    public void puedePonerBarcos(boolean b) {
    }

    public void puedeDisparar(boolean b) {
    }

    public void registrarJugador1(Avatar avatar, String nombre) {
    }

    public void sonido(boolean b) {
    }

    public boolean estaRegistrado() {
    }

    public void crearJuego() {
    }

    public boolean listoParaJugar() {
        boolean listo = true;

        return listo;
    }

    public void runJuego() {
    }
}
