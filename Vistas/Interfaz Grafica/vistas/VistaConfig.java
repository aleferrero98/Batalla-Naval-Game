package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import paneles.PanelConfig;


public class VistaConfig implements ActionListener, Observer{
		private JFrame frame;
		private PanelConfig panel;
		private ArrayList<JButton> botones;
		private Controlador controlador;
		private Modelo modelo;
		
	public VistaConfig(Controlador controlador, Modelo modelo) {
		frame=new JFrame("Configuración - Ayuda");
	    frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBounds(0,0,500,500);
	    panel = new PanelConfig();
		frame.add(panel,BorderLayout.CENTER);
		botones=panel.getBotones();
		setObserver();
		this.controlador = controlador;
		this.modelo = modelo;
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
			mostrarInstrucciones();
			
		}else if(e.getSource()==botones.get(2)) {
			System.out.println("color gris");
			this.controlador.selecColor(Color.GRAY);
			
		}else if(e.getSource()==botones.get(3)) {
				System.out.println("color verde");
			this.controlador.selecColor(Color.GREEN);
			
		}else if(e.getSource()==botones.get(4)) {
				System.out.println("color amarillo");
			this.controlador.selecColor(Color.YELLOW);
			
		}else if(e.getSource()==botones.get(5)) {
			System.out.println("color naranja");
			this.controlador.selecColor(Color.ORANGE);
			
		}else if(e.getSource()==botones.get(6)) {
			System.out.println("color blanco");
			this.controlador.selecColor(Color.WHITE);
			
		}else if(e.getSource()==botones.get(7)) {
			System.out.println("boton Volver a inicio");
			this.controlador.volverInicio();
		}
	}
	
	public void cambiarFondo(Color color) { //cambia el color del fondo entre 5 valores posibles
		panel.setBackground(color);
	}
	
	public void mostrarInstrucciones() {
	
		 // Preparamos la ventana de ejemplo
        JFrame v = new JFrame("Instrucciones del Juego Batalla Naval");
        v.setBounds(0, 0, 500, 700);
        v.setLocationRelativeTo(null);
        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(); 
        scroll.setViewportView(areaTexto);
        v.add(scroll);
    
        Leer(areaTexto);
        // Se visualiza la ventana
        v.setVisible(true);
		
	}
	 private void Leer(JTextArea area) {
		 String aux = "";
		 String texto = "";
		 String resultado = "";
		 try {
		 File archivo = new File("C:\\Users\\alejandro\\Documents\\GitHub\\Ing-de-Software\\Vistas\\Interfaz Grafica\\instrucciones\\instrucciones.txt");
		 if (archivo != null) {
		 FileReader archivos = new FileReader(archivo);
		 BufferedReader leer = new BufferedReader(archivos);
		 while ((aux = leer.readLine()) != null) {
		 texto += aux + "\n";
		 }
		 leer.close();
		 }
		 } catch (IOException ex) {
		 JOptionPane.showMessageDialog(null, "Error Importando - " + ex);
		 }
		 area.setText(texto);
		 }
	
	public void update() {
		
	}

}
