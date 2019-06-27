package Modelo.Juego.ElementosPrincipales;


import Modelo.Excepciones.InvalidDisparoException;


/**
 * Una celda puede tener encima un barco o no
 * esta pensada para ir sobre un tablero pero puede existir sin el
 *
 */
public class Celda {
    private boolean celdaConBarco;
    private boolean activada;  //activada es si se puede hacer un disparo sobre ella
    private int fila;
    private int columna;
    private Barco barco; //referencia al barco parado encima de la celda, solo un barco por celda

    /**
     * crea una celda con su barco y su activacion
     * @param barco
     * @param activada
     * @param fila
     * @param columna
     */
    public Celda(Barco barco, boolean activada, int fila, int columna) {
        this.barco = barco;
        this.celdaConBarco = true;
        this.activada = activada;
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * crea una celda simple
     * @param fila
     * @param columna
     */

    public Celda(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.celdaConBarco = false;
        this.activada = false;
    }

    private void setCeldaConBarco() {
        if(this.barco instanceof Barco){
            this.celdaConBarco = true;
        }
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isCeldaConBarco() {
        return celdaConBarco;
    }

    public boolean isActivada() {
        return activada;
    }

    public void setActivada(boolean activada) {
        this.activada = activada;
    }

    public Barco getBarco() throws NullPointerException{
        if(this.celdaConBarco) {
            return barco;
        }
        else throw new NullPointerException("No Hay Barco!");
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
        setCeldaConBarco();
    }

    /**
     * metodo importante donde se bombardea a una
     * celda activada, esta a su vez si tiene un barco
     * le ejecuta su metodo golpe
     *
     * @throws InvalidDisparoException
     */
    public void bombardear()throws InvalidDisparoException {
        if(isActivada()){
            if(isCeldaConBarco()) {
                try {
                    this.barco.bombardear(this);
                } catch (Exception e) {
                    throw new InvalidDisparoException(e.getMessage());
                }
            }
            else{
                // avisar que no tenia barco o nose
            }
            setActivada(false);

        }
        else throw new InvalidDisparoException("Celda desactivada no se le puede bombardear");
    }


}
