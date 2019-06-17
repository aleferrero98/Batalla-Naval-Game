package Modelo;

import Modelo.FactoryBarcos.Barco;
import Modelo.StrategyDisparo.InvalidDisparoException;

import java.util.ArrayList;

public class Tablero {
    private int filas;
    private int columnas;
    private Celda[][] celdas;
    private ArrayList<Barco> barcosEnTablero;
    private ArrayList<Barco> barcosNoHundidos;


    /**
     * Constructor de un tablero Rectangular de dimension filas x columnas
     * @param filas
     * @param columnas
     */
    public Tablero(int filas, int columnas) {
        crearTablero(filas, columnas);
    }

    /**
     * Constructor de un tablero Cuadrado de dimension tamanio x tamanio
     * @param tamanio
     */
    public Tablero(int tamanio) {
        crearTablero(tamanio, tamanio);
    }

    /**
     * metodo que crea el contenido principal del tablero, es decir, sus celdas
     * estas son celdas simples que inicializan sin barco encima y desactivadas
     * @param filas
     * @param columnas
     */
    private void crearTablero(int filas, int columnas) {
        this.celdas = new Celda[filas][columnas];
        for(int i = 0; i < filas ; i++){
            for(int j = 0; j < columnas ; j++){
                this.celdas[i][j] = new Celda(i,j);
            }
        }
    }

    /**
     * agrega un barco al tablero pero no lo coloca encima de ninguna casilla
     * si el barco no esta hundido tambien se vuelve un barco de los no hundidos
     * del tablero, no se deberian agregar barcos hundidos pero eso lo cuida el cliente
     * @param barco
     */
    private void addBarco(Barco barco) {
        this.barcosEnTablero.add(barco);
        if(!barco.hundido()){
            this.barcosNoHundidos.add(barco);
        }
    }

    /**
     * @param fila
     * @param columna
     * @return  la Celda correspondiente a esa fila y columna
     * @throws IndexOutOfBoundsException si la fila o columna son invalidos para este tablero
     */
    public Celda getCelda(int fila, int columna)throws IndexOutOfBoundsException{
        if(existeCelda(fila, columna)){
            return this.celdas[fila][columna];
        }
        else{
            throw new IndexOutOfBoundsException("fila o columna invalidos el tablero no tiene esta posicion de celda");
        }
    }

    public boolean existeCelda(int fila, int columna){
        return (fila>=0 && fila < this.filas && columna>=0 && columna < this.columnas);
    }

    /**
     * //si es valido entonces la celda tambien existe
     * @param fila
     * @param columna
     * @return true a la celda se le puede disparar, es decir si esta activada
     */
    public boolean esValido(int fila, int columna){
        if(existeCelda(fila, columna)){
            return getCelda(fila, columna).isActivada();
        }
        else return false;
    }

    /**
     * dispara a una celda
     * @param fila
     * @param columna
     * @throws InvalidDisparoException lanzado desde la celda si es que no se le puede disparar
     * @throws IndexOutOfBoundsException lanzado desde getCelda si no existe la celda
     */
    public void dispararUna(int fila, int columna) throws InvalidDisparoException, IndexOutOfBoundsException{
            getCelda(fila, columna).bombardear();
            actualizarBarcos();
    }

    /**
     * si se hundio algun barco lo quita de la lista de los no hundidos
     */
    private void actualizarBarcos() {
        for(Barco barco: this.barcosNoHundidos){
            if(barco.hundido()){
                this.barcosNoHundidos.remove(barco);
            }
        }
    }

    /**
     * metodo que dice si todos los barcos del tablero se han hundido
     * @return true si no quedan barcos no hundidos
     */
    public boolean barcosTodosHundidos(){
        return this.barcosNoHundidos.isEmpty();
    }

    /**
     * posiciona un barco de esa manera en este tablero
     * @param barco
     * @param orientacion
     * @param celdaCabeza
     * @throws Exception si no puede posicionar, el cliente debe primero preguntarle al barco si
     *                      se puede posicionar en este tablero
     */
    public void setBarco(Barco barco, char orientacion, Celda celdaCabeza) throws Exception {
        barco.posicionar(this, orientacion, celdaCabeza);
        addBarco(barco);
    }

}
