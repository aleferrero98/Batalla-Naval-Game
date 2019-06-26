package Modelo.Juego.ElementosPrincipales;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Juego.StrategyDisparo.Disparo;
import Modelo.Juego.StrategyDisparo.DisparoBehavior;

import java.util.HashMap;


public class Jugador {
    private Tablero tableroBarcos;
    private Tablero tableroDisparos;
    private DisparoBehavior maneraDeDisparar;
    private HashMap<Disparo, Integer> disparosDisponibles;

    public Jugador(Tablero tableroBarcos, Tablero tableroDisparos) {
        this.tableroBarcos = tableroBarcos;
        this.tableroDisparos = tableroDisparos;

        this.disparosDisponibles = new HashMap<>();
        this.disparosDisponibles.put(Disparo.COMUN, 100000);
    }

    public void setDisparosDisponibles(HashMap<Disparo, Integer> disparosDisponibles) {
        this.disparosDisponibles = disparosDisponibles;
    }

    /**
     * cambia el algoritmo de disparo
     * @param maneraDeDisparar
     */
    public void setManeraDeDisparar(DisparoBehavior maneraDeDisparar) {
        this.maneraDeDisparar = maneraDeDisparar;
    }

    /**
     * realiza un disparo en la celda en esa posicion
     * o salta la excepcion de que no puede disparar
     * @param fila
     * @param columna
     * @throws InvalidDisparoException
     */

    public void disparar(int fila, int columna)throws InvalidDisparoException{
        if(disparoDisponible()){
            this.maneraDeDisparar.disparar(fila, columna, this.tableroDisparos);
            gastarDisparo();
        }
        else throw new InvalidDisparoException();
    }

    /**
     * resta 1 a la cantidad de disparos disponibles del tipo actual
     */
    private void gastarDisparo() {
        disparosDisponibles.put(maneraDeDisparar.getTipo(), disparosDisponibles.get(maneraDeDisparar.getTipo()) -1 );
    }

    /**
     *
     * @return la disponibilidad del tipo de disparo que tiene actualmente
     */

    public boolean disparoDisponible(){
        if(disparosDisponibles.get(maneraDeDisparar.getTipo()) < 1) {
            return false;
        }
        else return true;
    }

}
