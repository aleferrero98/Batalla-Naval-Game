package Modelo;

import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.FactoryBarcos.TipoDeBarco;
import Modelo.Excepciones.InvalidDisparoException;

import java.security.InvalidParameterException;
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
        celdasTotales = new ArrayList<Celda>();
        celdasNoBombardeadas = new ArrayList<Celda>();
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


    public int getSize() {
        return size;
    }

    public char getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(char orientacion) throws InvalidParameterException {
        if(orientacion!='N' && orientacion!='S' && orientacion!='O' && orientacion!='E'){
            throw new InvalidParameterException();
        }
        this.orientacion = orientacion;
    }

    /**
     * quita la celdaBombardeada de sus celdasNoBombardeadas
     * tira una excepcion si este proceso es invalido
     * @param celdaBombardeada
     * @throws InvalidDisparoException
     */
    public void bombardear(Celda celdaBombardeada) throws InvalidDisparoException { //cuando se dispara un barco el que dispara debe
                                                                    //fijarse que se le pueda disparar, sino salta excepcion
        if (this.hundido()){
            throw new InvalidDisparoException("el barco esta hundido no se le puede disparar");
        }
        else if(!this.celdasNoBombardeadas.contains(celdaBombardeada)){
            throw new InvalidDisparoException("esta celda ya fue bombardeada");
        }
        else if(!this.celdasTotales.contains(celdaBombardeada)){
            throw new InvalidDisparoException("este barco no esta sobre esta celda");
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
     * posiciona al barco sobre el tablero tomando las celdas para hacerlas suyas
     * cuando un barco se posiciona sus celdasTotales == celdasNoBombardeadas
     * @param tablero
     * @param orientacion
     * @param celdaCabeza
     * @throws Exception si no se puede posicionar
     */
    public void posicionar(Tablero tablero, char orientacion, Celda celdaCabeza) throws InvalidPosicionBarco {
        if(puedePosicionar(tablero,orientacion,celdaCabeza)){
            ArrayList<Celda> celdas = this.celdasParaEsteBarco(tablero, orientacion, celdaCabeza);
            for(Celda celda: celdas){
                celda.setBarco(this); }
            setCeldasTotales(celdas);
            setCeldasNoBombardeadas(celdas);
            setCeldaCabeza(celdaCabeza);
            setOrientacion(orientacion);
        }else{ throw new InvalidPosicionBarco();}
    }

    /**
     * Metodo que depende del tipo de barco por eso e abstracto
     * @param tablero
     * @param orientacion
     * @param celdaCabeza
     * @return true si es que se puede posicionar de esa manera en ese tablero
     */
    public boolean puedePosicionar(Tablero tablero, char orientacion, Celda celdaCabeza) {
        ArrayList<Celda> celdasPosibles;
        try {
            celdasPosibles = this.celdasParaEsteBarco(tablero, orientacion, celdaCabeza);
        }
        catch(IndexOutOfBoundsException e) {
            return false;   //la excepcion que puede saltar es la de getCelda, osea que no se puede posicionar porque me sali del tablero
        }
        for(Celda celda: celdasPosibles){
            if(celda.isCeldaConBarco() || celda.isActivada()){
                return false; //si alguna de las posibles celdas ya tiene barco o esta activada no se puede posicionar
            }
        }
        return true; //si llego hasta aca ninguna dio false, entonces puede posicionarse en estas celdas
    }
    private ArrayList<Celda> celdasParaEsteBarco(Tablero tablero,char orientacion, Celda celdaCabeza)throws IndexOutOfBoundsException
    {
        int[][] posiblesFilasColumnas = generarFilasColumnas(orientacion, celdaCabeza);
        ArrayList<Celda> celdasParaEsteBarco = tablero.parseToCeldasDelTablero(posiblesFilasColumnas);
        return celdasParaEsteBarco;
    }

    /**
     *
     * @param orientacion
     * @param celdaCabeza
     * @return
     */
    public abstract int[][] generarFilasColumnas(char orientacion, Celda celdaCabeza);

    public int[][] barcosRectos(char orientacion, Celda celdaCabeza,int tamanio){
        int[][] posiblesFilasColumnas = new int[tamanio][2];
        int filaCabeza = celdaCabeza.getFila();
        int columnaCabeza = celdaCabeza.getColumna();
        posiblesFilasColumnas[0][0] = filaCabeza;
        posiblesFilasColumnas[0][1] = columnaCabeza;

        for(int columna=0;columna<2;columna++){
            for(int fila=0;fila<tamanio;fila++){
                if(orientacion=='N'){
                    if(columna==0){
                        posiblesFilasColumnas[fila][columna]=filaCabeza-fila;
                    }else if(columna==1){
                        posiblesFilasColumnas[fila][columna]=columnaCabeza;
                    }
                }
                if(orientacion=='S'){
                    if(columna==0){
                        posiblesFilasColumnas[fila][columna]=filaCabeza+fila;
                    }else if(columna==1){
                        posiblesFilasColumnas[fila][columna]=columnaCabeza;
                    }
                }
                if(orientacion=='E'){
                    if(columna==0){
                        posiblesFilasColumnas[fila][columna]=filaCabeza;
                    }else if(columna==1){
                        posiblesFilasColumnas[fila][columna]=columnaCabeza+fila;
                    }
                }
                if(orientacion=='O'){
                    if(columna==0){
                        posiblesFilasColumnas[fila][columna]=filaCabeza;
                    }else if(columna==1){
                        posiblesFilasColumnas[fila][columna]=columnaCabeza-fila;
                    }
                }
            }
        }
        return posiblesFilasColumnas;
    }
    public TipoDeBarco getTipoDeBarco() {
        return tipoDeBarco;
    }
}
