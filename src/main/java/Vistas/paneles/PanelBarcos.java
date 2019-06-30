package Vistas.paneles;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelBarcos extends JPanel {
    private JButton[] btnBarcos;

    /**
     * Create the panel.
     */
    public PanelBarcos() {
        this.setSize(120, 177);

        JLabel lblElegirTipoDe = new JLabel("Elegir tipo de barcos:");

        JButton btnPortaaviones = new JButton("Portaaviones");

        JButton btnSubmarino = new JButton("Submarino");

        JButton btnCaonero = new JButton("Ca\u00F1onero");

        JButton btnDestructor = new JButton("Destructor");

        JButton btnFragata = new JButton("Fragata");

        btnBarcos = new JButton[5];   //hay 5 tipos de barcos (botones)
        btnBarcos[0] = btnPortaaviones;
        btnBarcos[1] = btnSubmarino;
        btnBarcos[2] = btnCaonero;
        btnBarcos[3] = btnDestructor;
        btnBarcos[4] = btnFragata;

        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lblElegirTipoDe))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnPortaaviones))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnSubmarino))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnCaonero))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnDestructor))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnFragata)))
                                .addContainerGap(42, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblElegirTipoDe)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnPortaaviones)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnSubmarino)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnCaonero)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnDestructor)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnFragata)
                                .addContainerGap(33, Short.MAX_VALUE))
        );
        setLayout(groupLayout);

    }
    public JButton[] getBotonesBarc(){
        return btnBarcos;
    }
}