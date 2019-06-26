package Modelo.Juego.ElementosPrincipales;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Juego.FactoryBarcos.TipoDeBarco;
import Modelo.Juego.StrategyDisparo.Disparo;
import Modelo.Juego.StrategyDisparo.DisparoBehavior;

import java.util.HashMap;


public class Jugador {
    private Tablero tableroBarcos;
    private Tablero tableroDisparos;
    private DisparoBehavior maneraDeDisparar;
    private HashMap<Disparo, Integer> disparosDisponibles;
    private HashMap<TipoDeBarco, Integer> barcosDisponibles;

    public Jugador(Tablero tableroBarcos, Tablero tableroDisparos) {
        this.tableroBarcos = tableroBarcos;
        this.tableroDisparos = tableroDisparos;

        this.disparosDisponibles = new HashMap<>();
    }

    public void setDisparosDisponibles(HashMap<Disparo, Integer> disparosDisponibles) {
        this.disparosDisponibles = disparosDisponibles;
    }

    public void setBarcosDisponibles(HashMap<TipoDeBarco, Integer> barcosDisponibles) {
        this.barcosDisponibles = barcosDisponibles;
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
     *
     * @return la disponibilidad del tipo de disparo que tiene actualmente
     */
    public boolean disparoDisponible(){
        if(disparosDisponibles.get(maneraDeDisparar.getTipo()) < 1) {
            return false;
        }
        else return true;
    }

    /**
     * devuelve true si le quedan barcos de ese tipo por posicionar
     * @param barco
     * @return
     */
    public boolean barcoParaPonerDisponible(TipoDeBarco barco){

    }

    /**
     * devuelve true si puede posicionar ese barco en ese lugar en su tablero de barcos
     * @param barco
     * @param orientacion
     * @param fila
     * @param columna
     * @return
     */
    public boolean puedePosicionarBarco(Barco barco, char orientacion, int fila, int columna){
        Celda c =tableroBarcos.getCelda(fila,columna);
        return (barcoParaPonerDisponible(barco.getTipoDeBarco()) && barco.puedePosicionar(tableroBarcos, orientacion, c));
    }

    /**
     * devuelve true si no le quedan barcos para colocar
     * @return
     */
    public boolean todosLosBarcosColocados(){

    }

    /**
     * coloca un barco sobre su tablero
     * @param barco
     * @param orientacion
     * @param fila
     * @param columna
     */
    public void colocarBarco(Barco barco, char orientacion, int fila, int columna){
        if(puedePosicionarBarco(barco,orientacion,fila,columna)){

        }

    }



    /**
     * resta 1 a la cantidad de disparos disponibles del tipo actual
     */
    private void gastarDisparo() {
        disparosDisponibles.put(maneraDeDisparar.getTipo(), disparosDisponibles.get(maneraDeDisparar.getTipo()) -1 );
    }

    /**
     * resta uno a la cantidad de barcos disponibles de ese tipo de barco
     * @param barco
     */
    private void gastarBarco(TipoDeBarco barco){

    }

}
