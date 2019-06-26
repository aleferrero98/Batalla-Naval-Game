package paneles;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.util.ArrayList;


public class PanelJuego extends JPanel {
	
	private JButton[] btnBarcos;
	private JRadioButton[] btnPosicion;
	private PanelMatriz mLocal;
	private PanelMatriz mVisit;

    /**
     * Create the panel.
     */
    public PanelJuego() {
    	this.setSize(1000,500);
    
    	mLocal = new PanelMatriz(300);
    	
    	mVisit = new PanelMatriz(500);
    	
    	JButton btnPortaaviones = new JButton("Portaaviones");
    	
    	JButton btnSubmarino = new JButton("Submarino");
    	
    	JButton btnCaonero = new JButton("Ca\u00F1onero");
    	
    	JButton btnDestructores = new JButton("Destructores");
    	
    	JButton btnFragatas = new JButton("Fragatas");
    	
    	btnBarcos = new JButton[5];   //hay 5 tipos de barcos (botones)
    	btnBarcos[0] = btnPortaaviones;
    	btnBarcos[1] = btnSubmarino;
    	btnBarcos[2] = btnCaonero;
    	btnBarcos[3] = btnDestructores;
    	btnBarcos[4] = btnFragatas;
    	
    	JRadioButton rdbtnNorte = new JRadioButton("Norte");
    	
    	JRadioButton rdbtnSur = new JRadioButton("Sur");
    	
    	JRadioButton rdbtnEste = new JRadioButton("Este");
    	
    	JRadioButton rdbtnOeste = new JRadioButton("Oeste");
    	btnPosicion = new JRadioButton[4];
    	btnPosicion[0] = rdbtnNorte;
    	btnPosicion[1] = rdbtnSur;
    	btnPosicion[2] = rdbtnEste;
    	btnPosicion[3] = rdbtnOeste;
    	
    	
    	GroupLayout groupLayout = new GroupLayout(this);
    	groupLayout.setHorizontalGroup(
    		groupLayout.createParallelGroup(Alignment.TRAILING)
    			.addGroup(groupLayout.createSequentialGroup()
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addComponent(mLocal, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
    					.addGroup(groupLayout.createSequentialGroup()
    						.addContainerGap()
    						.addComponent(btnPortaaviones))
    					.addGroup(groupLayout.createSequentialGroup()
    						.addContainerGap()
    						.addComponent(btnFragatas))
    					.addGroup(groupLayout.createSequentialGroup()
    						.addContainerGap()
    						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    							.addComponent(btnSubmarino)
    							.addComponent(btnCaonero)
    							.addComponent(btnDestructores))
    						.addGap(91)
    						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    							.addComponent(rdbtnOeste)
    							.addComponent(rdbtnEste)
    							.addComponent(rdbtnSur)
    							.addComponent(rdbtnNorte))))
    				.addPreferredGap(ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
    				.addComponent(mVisit, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
    	);
    	groupLayout.setVerticalGroup(
    		groupLayout.createParallelGroup(Alignment.LEADING)
    			.addComponent(mVisit, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
    			.addGroup(groupLayout.createSequentialGroup()
    				.addComponent(mLocal, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addGroup(groupLayout.createSequentialGroup()
    						.addGap(11)
    						.addComponent(btnPortaaviones)
    						.addPreferredGap(ComponentPlacement.UNRELATED)
    						.addComponent(btnSubmarino)
    						.addPreferredGap(ComponentPlacement.UNRELATED)
    						.addComponent(btnCaonero)
    						.addPreferredGap(ComponentPlacement.UNRELATED)
    						.addComponent(btnDestructores)
    						.addPreferredGap(ComponentPlacement.UNRELATED)
    						.addComponent(btnFragatas))
    					.addGroup(groupLayout.createSequentialGroup()
    						.addGap(35)
    						.addComponent(rdbtnNorte)
    						.addPreferredGap(ComponentPlacement.UNRELATED)
    						.addComponent(rdbtnSur)
    						.addPreferredGap(ComponentPlacement.UNRELATED)
    						.addComponent(rdbtnEste)
    						.addPreferredGap(ComponentPlacement.UNRELATED)
    						.addComponent(rdbtnOeste)))
    				.addGap(30))
    	);
    	setLayout(groupLayout);

    }
	public JButton[][] getBotonesMatLoc(){
		return mLocal.getBotones();
		
	}
	public JButton[][] getBotonesMatVis(){
		return mVisit.getBotones();
	}
	public JButton[] getBotonesBarc(){
		return btnBarcos;
	}
	public JRadioButton[] getBotonesPosicion(){
		return btnPosicion;
	}
}
