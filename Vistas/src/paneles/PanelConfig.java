package paneles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;

public class PanelConfig extends JPanel {
		ArrayList<JButton> listaBotones;
	/**
	 * Create the panel.
	 */
	public PanelConfig() {
		this.setSize(500,500);
		
		JButton btnSilenciarJuego = new JButton("Silenciar Juego");
		JButton btnInstrucciones = new JButton("Instrucciones");
		JButton btnCambiarFondo = new JButton("Cambiar fondo");
		JButton btnVolverAlInicio = new JButton("Volver al Inicio");
		
		listaBotones = new ArrayList<JButton>();
		listaBotones.add(btnSilenciarJuego);
		listaBotones.add(btnInstrucciones);
		listaBotones.add(btnCambiarFondo);
		listaBotones.add(btnVolverAlInicio);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(171)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnVolverAlInicio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
						.addComponent(btnSilenciarJuego, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCambiarFondo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnInstrucciones, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
					.addGap(176))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(129)
					.addComponent(btnSilenciarJuego)
					.addGap(18)
					.addComponent(btnInstrucciones)
					.addGap(18)
					.addComponent(btnCambiarFondo)
					.addGap(18)
					.addComponent(btnVolverAlInicio)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
	
	@Override
	public void paintComponent(Graphics g) {
		Dimension tamanio=getSize();
		ImageIcon imagen=new ImageIcon(getClass().getResource("/imagenes/batallanaval3.jpg"));
		g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}
	public ArrayList<JButton> getBotones(){
		return listaBotones;
	}
}
