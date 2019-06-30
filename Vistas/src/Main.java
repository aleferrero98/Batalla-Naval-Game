import vistas.VistaInicio;
import vistas.VistaLogin;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import paneles.PanelJuego;
import vistas.VistaConfig;
import vistas.VistaJuego;

public class Main extends JFrame{

	public static void main(String[] args) {
        JFrame frame=new JFrame("Juego Batalla Naval");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 1000, 570);
        PanelJuego panel = new PanelJuego();
        frame.add(panel);
        frame.setLayout(new GridLayout(1,1));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
		}
}


