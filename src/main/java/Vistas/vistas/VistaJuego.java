package Vistas.vistas;

import Controlador.Controlador;
import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.Modelo;
import Modelo.Observer;
import Vistas.paneles.PanelJuego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class VistaJuego implements ActionListener, Observer {
    private JFrame frame;
    private PanelJuego panel;
    private JButton[][] btnMatrizLoc;
    private JButton[][] btnMatrizVisit;
    private JButton[] btnBarcos;
    private JRadioButton[] btnPosicion;
    private JButton[] btnDisparos;
    private JButton btnPausa;
    private JButton btnStart;
    private JButton btnVolverInicio;
    private Controlador controlador;
    private Modelo modelo;

    public VistaJuego(Controlador controlador, Modelo modelo) {

        frame=new JFrame("Juego Batalla Naval");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 1000, 570);
        panel = new PanelJuego();
        frame.add(panel);
        frame.setLayout(new GridLayout(1,1));

        btnMatrizLoc=panel.getBotonesMatLoc();
        btnMatrizVisit=panel.getBotonesMatVis();
        btnBarcos=panel.getBotonesBarc();
        btnPosicion = panel.getBotonesPosicion();
        btnDisparos = panel.getBotonesDisp();
        btnPausa = panel.getBotonPausa();
        btnStart = panel.getBotonStart();
        btnVolverInicio = panel.getVolverInicio();
        setObserver();
        this.controlador = controlador;
        this.modelo = modelo;
        this.modelo.addObserver(this);

    }
    public void hacerVisible(boolean b) {
        frame.setVisible(b);
    }
    public void ubicarAlMedio() {
        frame.setLocationRelativeTo(null);
    }
    private void setObserver() {
        for(int i=0; i < btnMatrizLoc.length; i++) {
            for(int j=0; j < btnMatrizLoc[0].length; j++) {
                btnMatrizLoc[i][j].addActionListener(this);
            }
        }
        for(int i=0; i < btnMatrizVisit.length; i++) {
            for(int j=0; j < btnMatrizVisit[0].length; j++) {
                btnMatrizVisit[i][j].addActionListener(this);
            }
        }
        for(int i=0; i < btnBarcos.length; i++) {
            btnBarcos[i].addActionListener(this);
        }
        for(int i=0; i < btnPosicion.length; i++) {
            btnPosicion[i].addActionListener(this);
        }
        for(int i=0; i < btnDisparos.length; i++) {
            btnDisparos[i].addActionListener(this);
        }
        btnPausa.addActionListener(this);
        btnStart.addActionListener(this);
        btnVolverInicio.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        int[] resultMatLoc = buscarBotonApretado(e,btnMatrizLoc);
        int[] resultMatVis = buscarBotonApretado(e,btnMatrizVisit);
        int resultBarcos = buscarBotonApretado(e,btnBarcos);
        int resultPosicion = buscarBotonApretado(e,btnPosicion);
        int resultDisparo = buscarBotonApretado(e,btnDisparos);

        if(resultMatLoc!=null) {
            System.out.println("apreto boton matriz local: "+ "fila "+resultMatLoc[0] +" columna "+resultMatLoc[1]);
            try {
                controlador.ponerBarco(resultMatLoc[0],resultMatLoc[1]);
            } catch (InvalidPosicionBarco invalidPosicionBarco) {
                invalidPosicionBarco.printStackTrace();
            }
        }else if(resultMatVis!=null) {
            System.out.println("apreto boton matriz visitante: "+ "fila "+resultMatVis[0] +" columna "+resultMatVis[1]);
            try {
                controlador.dispararEnTablero(resultMatVis[0],resultMatVis[1]);
            } catch (InvalidDisparoException ex) {
                ex.printStackTrace();
            }
        }else if(resultBarcos > -1) {
            System.out.println("apreto boton tipo de barco: "+"posicion "+ resultBarcos);
            try {
                controlador.elegirBarco(tipoBarco(resultBarcos));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }else if(resultPosicion > -1 && btnPosicion[resultPosicion].isSelected()) {
            System.out.println("apreto boton orientacion: "+"posicion "+ resultPosicion);
            for(int i=0; i<btnPosicion.length; i++){
                if(i != resultPosicion){
                    btnPosicion[i].setSelected(false);
                }
            }
            try {
                controlador.setOrientacionBarco(orientacionEnChar(resultPosicion));
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }else if(resultDisparo > -1) {
            System.out.println("apreto boton tipo de disparo: "+"posicion "+ resultDisparo);
            try {
                controlador.elegirDisparo(tipoDisparo(resultDisparo));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==btnPausa) {
            System.out.println("apreto boton de pausa");
            controlador.pausar();
        }else if(e.getSource()==btnStart){
            System.out.println("apreto boton start");
            controlador.start();
        }else if(e.getSource()==btnVolverInicio){
            System.out.println("apreto boton volver a inicio");
            controlador.volverInicio();
        }

    }
    private String tipoBarco(int i) throws Exception {
        switch(i) {
            case 0: return "PORTAAVIONES";
            case 1: return "SUBMARINO";
            case 2: return "CANIONERO";
            case 3: return "DESTRUCTOR";
            case 4: return "FRAGATA";
            default:
                throw new Exception("Error tipo de barco-interfaz");
        }
    }
    private String tipoDisparo(int i) throws Exception {
        switch(i) {
            case 0: return "COMUN";
            case 1: return "CRUZ";
            case 2: return "ALEATORIO";
            case 3: return "CORTADO";
            case 4: return "TERMODIRIGIDO";
            default:
                throw new Exception("Error tipo de disparo-interfaz");
        }
    }
    private char orientacionEnChar(int i) throws Exception {
        switch(i) {
            case 0: return 'N';
            case 1: return 'S';
            case 2: return 'E';
            case 3: return 'O';
            default:
                throw new Exception("Orientacion mal indicada");
        }
    }


    private int[] buscarBotonApretado(ActionEvent e, JButton[][] matrizBotones) {
        int[] filaColumna = new int[2];
        for(int i=0; i < matrizBotones.length; i++) {
            for(int j=0; j < matrizBotones[0].length; j++) {
                if(matrizBotones[i][j] == e.getSource()) {
                    filaColumna[0] = i;
                    filaColumna[1] = j;
                    return filaColumna;
                }
            }
        }
        return null;
    }
    private int buscarBotonApretado(ActionEvent e, JButton[] arrayBotones) {
        for(int i=0; i < arrayBotones.length; i++) {
            if(arrayBotones[i] == e.getSource()) {
                return i;
            }
        }
        return -1;
    }
    private int buscarBotonApretado(ActionEvent e, JRadioButton[] arrayBotones) {
        for(int i=0; i < arrayBotones.length; i++) {
            if(arrayBotones[i] == e.getSource()) {
                return i;
            }
        }
        return -1;
    }

    public void cambiarColorBoton(JButton boton, Color color) {
        boton.setBackground(color);
    }


    public void cambiarFondo(Color color) { //cambia el color del fondo entre 5 valores posibles
        panel.setBackground(color);
    }

    public void update() {
        int[][] matrizDisparos = modelo.getEstadoDelJuego().getMatrizJugadorN2();
        int[][] matrizBarcos = modelo.getEstadoDelJuego().getMatrizJugadorN1();

        for(int i=0; i < matrizDisparos.length; i++) {
            for(int j=0; j < matrizDisparos[0].length; j++) {
                try{
                    switch(matrizDisparos[i][j]) {
                        case 0:        //color base, celda activada pero no disparada
                            break;
                        case 1:            //hay barco pero no disparado, no se pinta en la matriz grande
                            break;
                        case 2:
                            cambiarColorBoton(btnMatrizVisit[i][j], Color.YELLOW);  //disparo agua
                            break;
                        case 3:
                            cambiarColorBoton(btnMatrizVisit[i][j], Color.RED);  //disparo en  barco
                            break;
                        default:
                            throw new Exception("numero invalido");
                    }
                }catch(Exception e){}
            try{
                switch(matrizBarcos[i][j]) {
                    case 0:		//color base, celda activada pero no disparada
                        break;
                    case 1:			//hay barco pero no disparado, no se pinta en la matriz grande
                        cambiarColorBoton(btnMatrizLoc[i][j], Color.BLUE);
                        break;
                    case 2:
                        cambiarColorBoton(btnMatrizLoc[i][j], Color.YELLOW); //disparo agua
                        break;
                    case 3:
                        cambiarColorBoton(btnMatrizLoc[i][j], Color.RED); //disparo en  barco
                        break;
                    default:
                        throw new Exception("numero invalido");
                }
            }catch(Exception e){}

            }

        }
        if(modelo.ganoJ1()){
            JOptionPane.showMessageDialog(null, "Ganaste " + modelo.getNombreJ1() + " !");
        }else if(modelo.ganoJ2()){
            JOptionPane.showMessageDialog(null, "Perdiste " + modelo.getNombreJ1() + " !");
        }
    }
}

