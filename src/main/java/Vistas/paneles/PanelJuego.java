package Vistas.paneles;

import javax.swing.JPanel;

import java.awt.Color;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class PanelJuego extends JPanel {

    private PanelMatriz mLocal;
    private PanelMatriz mVisit;
    private JButton btnPausa;
    private JButton btnStart;
    private JButton btnVolverAInicio;
    private PanelBarcos panelBarco;
    private PanelOrientacion panelOrient;
    private PanelDisparo panelDisparo;

    /**
     * Create the panel.
     */
    public PanelJuego() {
        this.setSize(1000,490);

        mLocal = new PanelMatriz(300);

        mVisit = new PanelMatriz(500);

        btnPausa = new JButton("Pausa");

        btnStart = new JButton("Start");

        btnVolverAInicio = new JButton("Volver a inicio");

        panelBarco = new PanelBarcos();

        panelOrient = new PanelOrientacion();

        panelDisparo = new PanelDisparo();



        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                                                .addComponent(mLocal, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(btnStart)
                                                        .addComponent(btnVolverAInicio)
                                                        .addComponent(btnPausa))
                                                .addGap(46))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(panelBarco, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(panelOrient, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(panelDisparo, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(mVisit, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(btnPausa)
                                                                .addGap(11)
                                                                .addComponent(btnStart)
                                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                                .addComponent(btnVolverAInicio))
                                                        .addComponent(mLocal, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
                                                .addGap(11)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(panelDisparo, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                                        .addComponent(panelOrient, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(panelBarco, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)))
                                        .addComponent(mVisit, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
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
        return panelBarco.getBotonesBarc();
    }
    public JRadioButton[] getBotonesPosicion(){
        return panelOrient.getBotonesPosicion();
    }
    public JButton[] getBotonesDisp(){
        return panelDisparo.getBotonesDisp();
    }
    public JButton getBotonPausa(){
        return btnPausa;
    }
    public JButton getBotonStart(){
        return btnStart;
    }
    public JButton getVolverInicio() {
        return btnVolverAInicio;
    }
    public void cambiarFondo(Color color) { //cambia el color del fondo entre 5 valores posibles
        this.setBackground(color);
        panelBarco.setBackground(color);
        panelOrient.cambiarFondo(color);
        panelDisparo.setBackground(color);
    }
}



