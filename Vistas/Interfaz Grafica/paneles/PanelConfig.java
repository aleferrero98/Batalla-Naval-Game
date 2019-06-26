package paneles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelConfig extends JPanel {
		ArrayList<JButton> listaBotones;
	/**
	 * Create the panel.
	 */
	public PanelConfig() {
		this.setSize(500,500);
		
		JButton btnSilenciarJuego = new JButton("Silenciar Juego");
		JButton btnInstrucciones = new JButton("Instrucciones");
		JButton btnVolverAlInicio = new JButton("Volver al Inicio");
		JButton btnGris = new JButton("Gris");
		JButton btnVerde = new JButton("Verde");
		JButton btnAmarillo = new JButton("Amarillo");
		JButton btnNaranja = new JButton("Naranja");
		JButton btnBlanco = new JButton("Blanco");
		
		listaBotones = new ArrayList<JButton>();
		listaBotones.add(btnSilenciarJuego);
		listaBotones.add(btnInstrucciones);
		listaBotones.add(btnGris);
		listaBotones.add(btnVerde);
		listaBotones.add(btnAmarillo);
		listaBotones.add(btnNaranja);
		listaBotones.add(btnBlanco);
		listaBotones.add(btnVolverAlInicio);
		
		
		

		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(171)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnSilenciarJuego, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
						.addComponent(btnInstrucciones, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
					.addGap(176))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(327, Short.MAX_VALUE)
					.addComponent(btnVolverAlInicio, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(btnGris)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnVerde)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAmarillo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNaranja)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBlanco)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(129)
					.addComponent(btnSilenciarJuego)
					.addGap(18)
					.addComponent(btnInstrucciones)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGris)
						.addComponent(btnVerde)
						.addComponent(btnAmarillo)
						.addComponent(btnNaranja)
						.addComponent(btnBlanco))
					.addPreferredGap(ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
					.addComponent(btnVolverAlInicio)
					.addGap(48))
		);
		setLayout(groupLayout);

	}
	
/*	@Override
	public void paintComponent(Graphics g) { //metodo que agrega una imagen de fondo
		Dimension tamanio=getSize();
		ImageIcon imagen=new ImageIcon(getClass().getResource("/imagenesFondo/batallanaval3.jpg"));
		g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paintComponent(g);
	}*/
	public ArrayList<JButton> getBotones(){
		return listaBotones;
	}
}

