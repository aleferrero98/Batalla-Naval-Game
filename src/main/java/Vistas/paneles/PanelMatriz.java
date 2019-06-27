package Vistas.paneles;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;

public class PanelMatriz extends JPanel {

    static final int filas = 13;
    static final int columnas = 13;
    private JButton[][] botones;

    /**
     * Create the panel.
     */
    public PanelMatriz(int tamanio) {
        this.setSize(tamanio, tamanio);//tamanio
        setLayout(new GridLayout(13, 13, -1, -1));
        botones = new JButton[filas][columnas];
        crearBotonesMatriz();
        agregarBotonesPanel();

    }
    public void crearBotonesMatriz(){
        //Se recorren las filas
        for (int fila = 0; fila < this.filas; fila++) {
            //Estando en la fila se recorrer las columnas
            for (int columna = 0; columna < this.columnas; columna++) {
                //Se crea el boton y se agrega a las celda de la matriz
                botones[fila][columna] = new JButton();
            }
        }
    }
    public void agregarBotonesPanel() {
        for (int fila = 0; fila < this.filas; fila++) {
            for (int columna = 0; columna < this.columnas; columna++) {
                add(getBoton(fila, columna));
            }
        }
    }
    public JButton getBoton(int f,int c) {
        return botones[f][c];
    }

    public JButton[][] getBotones() {
        return botones;
    }

}


