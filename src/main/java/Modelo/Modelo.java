package Modelo;

import Controlador.Controlador;
import Modelo.Juego.ElementosPrincipales.JuegoBatallaNaval;

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
}
