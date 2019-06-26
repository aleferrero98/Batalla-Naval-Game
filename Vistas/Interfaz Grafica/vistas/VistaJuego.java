package vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import paneles.PanelJuego;

public class VistaJuego implements ActionListener{
	private JFrame frame;
	private PanelJuego panel;
	private JButton[][] btnMatrizLoc;
	private JButton[][] btnMatrizVisit;
	private JButton[] btnBarcos;
	private JRadioButton[] btnPosicion;
	
	
	
public VistaJuego() {
	
/*	 contentPane = new JPanel();
     contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
     setContentPane(contentPane);*/
     
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
	setObserver();
	
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
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	int[] resultMatLoc = buscarBotonApretado(e,btnMatrizLoc);
	int[] resultMatVis = buscarBotonApretado(e,btnMatrizVisit);
	int resultBarcos = buscarBotonApretado(e,btnBarcos);
	int resultPosicion = buscarBotonApretado(e,btnPosicion);
	
	if(resultMatLoc!=null) {
		System.out.println("apreto boton matriz local: "+ "fila "+resultMatLoc[0] +" columna "+resultMatLoc[1]);
		cambiarColorBoton(btnMatrizLoc[resultMatLoc[0]][resultMatLoc[1]]);
	}else if(resultMatVis!=null) {
		System.out.println("apreto boton matriz visitante: "+ "fila "+resultMatVis[0] +" columna "+resultMatVis[1]);
	}else if(resultBarcos > -1) {
		System.out.println("apreto boton tipo de barco: "+"posicion "+ resultBarcos);
	}else if(resultPosicion > -1) {
		System.out.println("apreto boton orientacion: "+"posicion "+resultPosicion);
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
public void cambiarColorBoton(JButton boton) {
	boton.setBackground(new java.awt.Color(255,50,50)); //cambia el color del boton a rojo
}
}
