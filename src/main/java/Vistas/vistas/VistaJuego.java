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
    private String mensaje;
    private char charVacio;
    private String disparoActual;


    public VistaJuego(Controlador controlador, Modelo modelo) {

        frame=new JFrame("Juego Batalla Naval");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 1000, 560);
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

        mensaje = "Bienvenido al juego Batalla Naval";
        mensaje += "\nRecuerda colocar tus barcos antes de disparar.";
        mensaje += "\nTienes 1 portaavion, 2 destructores, 1 submarino, 1 fragata y 1 canionero.";
        mensaje += "\nLuego apretas el boton START y ya puedes comenzar a disparar.";
        mensaje += "\nTienes 1 disparo cruz, 1 disparo termodirigido, 2 disparos cortados y 2 disparos aleatorios.";
        mensaje += "\nEl disparo comun es ilimitado.";

        this.disparoActual = "COMUN";

    }
    public void hacerVisible(boolean b) {
        frame.setVisible(b);
        if(b){
            JOptionPane.showMessageDialog(null, this.mensaje, "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
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
    public void actionPerformed(ActionEvent e) throws IllegalStateException{
        // TODO Auto-generated method stub
        int[] resultMatLoc = buscarBotonApretado(e,btnMatrizLoc);
        int[] resultMatVis = buscarBotonApretado(e,btnMatrizVisit);
        int resultBarcos = buscarBotonApretado(e,btnBarcos);
        int resultPosicion = buscarBotonApretado(e,btnPosicion);
        int resultDisparo = buscarBotonApretado(e,btnDisparos);

        if(resultMatLoc!=null) {
            if(controlador.getUltimaOrientacion() != charVacio) {
                System.out.println("apreto boton matriz local: " + "fila " + resultMatLoc[0] + " columna " + resultMatLoc[1]);
                try {
                    controlador.ponerBarco(resultMatLoc[0], resultMatLoc[1]);
                } catch (InvalidPosicionBarco invalidPosicionBarco) {
                    invalidPosicionBarco.printStackTrace();
                }
            }else {
                JOptionPane.showMessageDialog(null, "Debes seleccionar la orientacion del barco antes de colocarlo!","Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }else if(resultMatVis!=null) {
            System.out.println("apreto boton matriz visitante: "+ "fila "+ resultMatVis[0] +" columna "+ resultMatVis[1]);
            if(!controlador.disparoDisponible(this.disparoActual)){
                JOptionPane.showMessageDialog(null, "No te quedan " + this.disparoActual + " disponibles\nPor favor cambia tu tipo de disparo","Error", JOptionPane.ERROR_MESSAGE);
            }else{
            try {
                controlador.dispararEnTablero(resultMatVis[0],resultMatVis[1]);
            } catch (InvalidDisparoException ex) {
                ex.printStackTrace();
            }}
        }else if(resultBarcos > -1) {
            String tipoBarco = null;
            try {
                tipoBarco = tipoBarco(resultBarcos);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if(controlador.barcoParaPonerDisponible(tipoBarco)){
                System.out.println("apreto boton tipo de barco: "+"posicion "+ resultBarcos);
                controlador.elegirBarco(tipoBarco);
            }else{
                JOptionPane.showMessageDialog(null, "No te quedan " + tipoBarco + " disponibles","Error", JOptionPane.ERROR_MESSAGE);
            }

        }else if(resultPosicion > -1) {
            if(btnPosicion[resultPosicion].isSelected()) {
                System.out.println("apreto boton orientacion: " + "posicion " + resultPosicion);
                for (int i = 0; i < btnPosicion.length; i++) {
                    if (i != resultPosicion) {
                        btnPosicion[i].setSelected(false);
                    }
                }
                try {
                    controlador.setOrientacionBarco(orientacionEnChar(resultPosicion));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }else{
                try {
                    controlador.setOrientacionBarco(charVacio);  //si desseleciono el radioboton, pongo el char vacio
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }else if(resultDisparo > -1) {
            String tipoDisparo = null;
            try {
                tipoDisparo = tipoDisparo(resultDisparo);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if(controlador.disparoDisponible(tipoDisparo)){
                System.out.println("apreto boton tipo de disparo: "+"posicion "+ resultDisparo);
                controlador.elegirDisparo(tipoDisparo);
                this.disparoActual = tipoDisparo;
            }else{
                JOptionPane.showMessageDialog(null, "No te quedan " + tipoDisparo + " disponibles","Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource()==btnPausa) {
            System.out.println("apreto boton de pausa");
            controlador.pausar();
        }else if(e.getSource()==btnStart){
            if(modelo.getEstadoDelJuego().getBarcosJ1Posicionados()) {
                System.out.println("apreto boton start");
                controlador.start();
            }else {
                JOptionPane.showMessageDialog(null, "Debes colocar todos tus barcos antes de comenzar a disparar!","Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }else if(e.getSource()==btnVolverInicio){
            System.out.println("apreto boton volver a inicio");
            switch(volverAInicio()){
                case 0:
                    controlador.volverInicio(); //opcion SI
                    break;
                case 1:
                    //opcion NO, no hace nada
                    break;
                default:
                    throw new IllegalStateException("Opcion de confirmacion no valida");
            }

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
        panel.cambiarFondo(color);
    }

    private int volverAInicio(){
        return JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Volver a inicio", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Ganaste " + modelo.getNombreJ1() + "!", "Fin de la partida", JOptionPane.INFORMATION_MESSAGE);
            volverAjugar();
        }else if(modelo.ganoJ2()){
            JOptionPane.showMessageDialog(null, "Perdiste " + modelo.getNombreJ1() + "!", "Fin de la partida", JOptionPane.INFORMATION_MESSAGE);
            volverAjugar();
        }
    }
    private void volverAjugar(){
        int revancha = JOptionPane.showConfirmDialog(null, "¿Desea volver a jugar?", "Partida finalizada", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(revancha == 0){ //si
            this.controlador.revancha();
        }else if(revancha == 1){ //no
            this.controlador.terminarJuego();
            this.controlador.volverInicio();
        }
    }
}

