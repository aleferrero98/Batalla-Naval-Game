package vistas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;


import paneles.PanelInicio;

public class VistaInicio implements ActionListener{
		private JFrame frame;
		private PanelInicio panel;
		private ArrayList<JButton> botones;
		
	public VistaInicio() {
		frame=new JFrame("Inicio");
	    frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(0,0,500,500);
	    panel = new PanelInicio();
		frame.add(panel,BorderLayout.CENTER);
		botones=panel.getBotones();
		setObserver();
		
	}
	public void hacerVisible(boolean b) {
		frame.setVisible(b);
	}
	public void ubicarAlMedio() {
		frame.setLocationRelativeTo(null);
	}
	private void setObserver() {
		for(JButton boton: botones) {
			boton.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==botones.get(0)) {
			System.exit(0);
		}else if(e.getSource()==botones.get(1)) {
			System.out.println("boton Iniciar Partida");
		}else if(e.getSource()==botones.get(2)) {
			System.out.println("boton Registrarse");
		}else if(e.getSource()==botones.get(3)) {
			System.out.println("boton Configuracion-Ayuda");
	}
		
	}

}

