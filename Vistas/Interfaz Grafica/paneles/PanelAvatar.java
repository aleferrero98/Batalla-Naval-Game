package paneles;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
	
public class PanelAvatar extends JPanel {

		private ImageIcon imagen;
		/**
		 * Create the panel.
		 */
		public PanelAvatar(ImageIcon imagen) {
			this.setSize(112,140);
			this.imagen = imagen;
		}
		public void paintComponent(Graphics g) {
			Dimension tamanio=getSize();
			g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
			setOpaque(false);
			super.paintComponent(g);
		}

}

