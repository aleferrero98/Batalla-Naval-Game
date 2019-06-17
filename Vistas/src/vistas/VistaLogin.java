package vistas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import paneles.PanelLogin;

public class VistaLogin implements ActionListener{
		private JFrame frame;
		private PanelLogin panel;
		private ArrayList<JButton> botones;
		private ArrayList<JRadioButton> radioBotones;
		private JTextField campoTexto;
		
	public VistaLogin() {
		frame=new JFrame("Inicio");
	    frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(0,0,500,500);
	    panel = new PanelLogin();
		frame.add(panel,BorderLayout.CENTER);
		botones=panel.getBotones();
		radioBotones=panel.getRadioBotones();
		campoTexto=panel.getCampoTexto();
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
		for(JRadioButton radioBoton: radioBotones) {
			radioBoton.addActionListener(this);
		}
		campoTexto.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==radioBotones.get(0)) {
			System.out.println("radioboton flash");
		}else if(e.getSource()==radioBotones.get(1)) {
			System.out.println("radioboton batman");
		}else if(e.getSource()==radioBotones.get(2)) {
			System.out.println("radioboton spiderman");
		}else if(e.getSource()==campoTexto) {
			System.out.println("campotexto escrito");
		}else if(e.getSource()==botones.get(0)) {
			System.out.println("boton aceptar");
		}else if(e.getSource()==botones.get(1)) {
			System.out.println("boton cancelar");
		}
		
	}

}
