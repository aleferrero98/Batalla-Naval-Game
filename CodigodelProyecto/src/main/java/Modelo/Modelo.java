package Modelo;

import Controlador.Avatar;
import Controlador.Controlador;
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

    public void pausar() {
    }

    public void salirDePausa() {
    }

    public void selecBarco(TipoDeBarco b) {
    }

    public void setBarcoActual(char orientacion, int fila, int columna) {
    }

    public void abrirRegistro() {
    }

    public void abrirConfig() {
    }

    public void irJuego() {
    }

    public void PuedePonerBarcos(boolean b) {
    }

    public void PuedeDisparar(boolean b) {
    }

    public void registrarJugador1(Avatar avatar, String nombre) {
    }

    public void irInicio() {
    }

    public void setColor(Color c) {
    }

    public void sonido(boolean b) {
    }
}
