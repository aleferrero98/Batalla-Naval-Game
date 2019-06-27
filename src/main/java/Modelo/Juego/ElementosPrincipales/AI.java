package Modelo.Juego.ElementosPrincipales;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.Juego.FactoryBarcos.AstilleroMilitar;
import Modelo.Juego.FactoryBarcos.TipoDeBarco;
import Modelo.Juego.StrategyDisparo.Disparo;
import Modelo.Juego.StrategyDisparo.DisparoBehavior;
import java.util.HashMap;

public class AI {
    private Tablero tableroBarcos;
    private Tablero tableroDisparos;
    private Barco barcoSeleccionado;
    private HashMap<Disparo, Integer> disparosDisponibles;
    private HashMap<TipoDeBarco, Integer> barcosDisponibles;
    private AstilleroMilitar creadorBarcos;

    public AI(Tablero tableroBarcos, Tablero tableroDisparos) {
        this.tableroBarcos = tableroBarcos;
        this.tableroDisparos = tableroDisparos;
        this.disparosDisponibles = new HashMap<>();
        creadorBarcos = new AstilleroMilitar();
    }

    public void setDisparosDisponibles(HashMap<Disparo, Integer> disparosDisponibles) {
        this.disparosDisponibles = disparosDisponibles;
    }

    public void setBarcosDisponibles(HashMap<TipoDeBarco, Integer> barcosDisponibles) {
        this.barcosDisponibles = barcosDisponibles;
    }
    public void disparoAleatorio() throws InvalidDisparoException{
        int columnaAleatoria = (int) (Math.random() * tableroDisparos.getColumnas());
        int filaAleatoria = (int) (Math.random() * tableroDisparos.getFilas());
        Disparo disparoElegido = elegirDisparoAleatorio();
        if(disparoDisponible(disparoElegido) && tableroDisparos.esValido(filaAleatoria,columnaAleatoria)){
            tableroDisparos.dispararUna(filaAleatoria,columnaAleatoria);
            actualizarDisparosDisponibles(disparoElegido);
        }
        else{
            disparoAleatorio(); //llamada recursiva hasta que se pueda
        }
    }
    public boolean disparoDisponible(Disparo tipodeDisparo){
        if(disparosDisponibles.get(tipodeDisparo) < 1) {
            return false;
        }
        else return true;
    }
    private Disparo elegirDisparoAleatorio() {
        Disparo disparoAleatorio;
        int eleccion = (int) (Math.random() * disparosDisponibles.size()) + 1;
        switch (eleccion) {
            case 1:
                disparoAleatorio = Disparo.COMUN;
                return disparoAleatorio;
            case 2:
                disparoAleatorio = Disparo.CORTADO;
                return disparoAleatorio;
            case 3:
                disparoAleatorio = Disparo.ALEATORIO;
                return disparoAleatorio;
            case 4:
                disparoAleatorio = Disparo.CRUZ;
                return disparoAleatorio;
            case 5:
                disparoAleatorio = Disparo.TERMODIRIGIDO;
                return disparoAleatorio;
        }
        return null;
    }
    public void actualizarDisparosDisponibles(Disparo disparoElegido){
        disparosDisponibles.put(disparoElegido, disparosDisponibles.get(disparoElegido) -1);
    }

    public void barcosAleatorio() throws InvalidPosicionBarco {
        this.barcoSeleccionado = elegirBarcoAleatorio();
        int columnaAleatoria = (int) (Math.random() * tableroBarcos.getColumnas());
        int filaAleatoria = (int) (Math.random() * tableroBarcos.getFilas());
        char orientacionAleatoria = elegirOrientacionAleatoria();
        if(barcoDisponible(this.barcoSeleccionado) && this.barcoSeleccionado.puedePosicionar(tableroBarcos, orientacionAleatoria, tableroBarcos.getCelda(filaAleatoria,columnaAleatoria))){
                tableroBarcos.setBarco(this.barcoSeleccionado,orientacionAleatoria,filaAleatoria,columnaAleatoria);
                actualizarBarcosDisponibles(this.barcoSeleccionado);
        }
        else{
            barcosAleatorio();  //Llamada Recursiva
        }
    }
    private Barco elegirBarcoAleatorio(){
        Barco barcoElegido;
        int eleccion = (int) (Math.random() * barcosDisponibles.size()) + 1;
        switch (eleccion) {
            case 1:
                barcoElegido = creadorBarcos.construirBarco(TipoDeBarco.SUBMARINO);
                return barcoElegido;
            case 2:
                barcoElegido = creadorBarcos.construirBarco(TipoDeBarco.PORTAAVIONES);
                return barcoElegido;
            case 3:
                barcoElegido = creadorBarcos.construirBarco(TipoDeBarco.FRAGATA);
                return barcoElegido;
            case 4:
                barcoElegido = creadorBarcos.construirBarco(TipoDeBarco.DESTRUCTOR);
                return barcoElegido;
            case 5:
                barcoElegido = creadorBarcos.construirBarco(TipoDeBarco.CANIONERO);
                return barcoElegido;
        }
        return null;
    }
    private char elegirOrientacionAleatoria(){
        char[] orientaciones = {'N','S','E','O'};
        int eleccionOrientacion = (int) (Math.random() *orientaciones.length) + 1;
        return orientaciones[eleccionOrientacion];
    }
    private boolean barcoDisponible(Barco barcoSeleccionado){
        if(barcosDisponibles.get(barcoSeleccionado.getTipoDeBarco())>0){
            return true;
        }
        return false;
    }
    private void actualizarBarcosDisponibles(Barco elegido){
        barcosDisponibles.put(elegido.getTipoDeBarco(),(barcosDisponibles.get(elegido.getTipoDeBarco())-1));
    }

}

