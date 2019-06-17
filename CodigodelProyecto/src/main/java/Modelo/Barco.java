package Modelo;

import Modelo.Celda;
import Modelo.FactoryBarcos.TipoDeBarco;
import Modelo.Tablero;

import java.util.ArrayList;

public abstract class Barco {
    private ArrayList<Celda> celdasTotales;
    private ArrayList<Celda> celdasNoBombardeadas;
    private TipoDeBarco tipoDeBarco;
    private Celda celdaCabeza;
    private char orientacion;
    private int size;

    /**
     *
     */
    protected Barco(int size, TipoDeBarco tipoDeBarco){
        this.size = size;
        this.tipoDeBarco = tipoDeBarco;
    }

    /**
     * getters y setters
     * los setters son protected porque solo las subclases pueden decidir sobre estas celdas
     */
    public ArrayList<Celda> getCeldasTotales() {
        return celdasTotales;
    }

    protected void setCeldasTotales(ArrayList<Celda> celdasTotales){
        this.celdasTotales = celdasTotales;
    }

    public ArrayList<Celda> getCeldasNoBombardeadas() {
        return celdasNoBombardeadas;
    }

    protected void setCeldasNoBombardeadas(ArrayList<Celda> celdasNoBombardeadas) {
        this.celdasNoBombardeadas = celdasNoBombardeadas;
    }

    public Celda getCeldaCabeza() {
        return celdaCabeza;
    }

    public void setCeldaCabeza(Celda celdaCabeza) {
        this.celdaCabeza = celdaCabeza;
    }

    public char getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(char orientacion) {
        this.orientacion = orientacion;
    }

    /**
     * quita la celdaBombardeada de sus celdasNoBombardeadas
     * tira una excepcion si este proceso es invalido
     * @param celdaBombardeada
     * @throws Exception
     */
    public void bombardear(Celda celdaBombardeada) throws Exception{ //cuando se dispara un barco el que dispara debe
                                                                    //fijarse que se le pueda disparar, sino salta excepcion
        if (this.hundido()){
            throw new Exception("el barco esta hundido no se le puede disparar");
        }
        else if(!this.celdasNoBombardeadas.contains(celdaBombardeada)){
            throw new Exception("esta celda ya fue bombardeada");
        }
        else if(!this.celdasTotales.contains(celdaBombardeada)){
            throw new Exception("este barco no esta sobre esta celda");
        }
        else{
            this.celdasNoBombardeadas.remove(celdaBombardeada);

        }
    }

    /**
     * @return true si todas sus celdas ya fueron bombardeas sino false
     */
    public boolean hundido(){
        return this.celdasNoBombardeadas.isEmpty();
    }

    /**
     * Metodo que depende del tipo de barco por eso e abstracto
     * @param tablero
     * @param orientacion
     * @param celdaCabeza
     * @return true si es que se puede posicionar de esa manera en ese tablero
     */
    abstract public boolean puedePosicionar(Tablero tablero, char orientacion, Celda celdaCabeza);

    /**
     * Metodo que depende del tipo de barco por eso e abstracto
     * posiciona al barco sobre el tablero tomando las celdas para hacerlas suyas
     * cuando un barco se posiciona sus celdasTotales == celdasNoBombardeadas
     * @param tablero
     * @param orientacion
     * @param celdaCabeza
     * @throws Exception si no se puede posicionar
     */
    abstract public void posicionar(Tablero tablero, char orientacion, Celda celdaCabeza)throws Exception;



}
