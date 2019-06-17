package vistas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

import paneles.PanelConfig;


public class VistaConfig implements ActionListener{
		private JFrame frame;
		private PanelConfig panel;
		private ArrayList<JButton> botones;
		
	public VistaConfig() {
		frame=new JFrame("Configuración - Ayuda");
	    frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(0,0,500,500);
	    panel = new PanelConfig();
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
			System.out.println("boton Silenciar juego");
		}else if(e.getSource()==botones.get(1)) {
			System.out.println("boton Instrucciones");
		}else if(e.getSource()==botones.get(2)) {
			System.out.println("boton Cambiar fondo");
		}else if(e.getSource()==botones.get(3)) {
			System.out.println("boton Volver a inicio");
		}
		
	}

}
