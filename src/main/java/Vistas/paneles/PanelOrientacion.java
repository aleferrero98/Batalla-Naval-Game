package Vistas.paneles;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelOrientacion extends JPanel {
    private JRadioButton[] btnPosicion;

    /**
     * Create the panel.
     */
    public PanelOrientacion() {
        this.setSize(105, 136);

        JLabel lblElegirOrientacion = new JLabel("Elegir orientacion:");

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
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(rdbtnOeste)
                                        .addComponent(rdbtnEste)
                                        .addComponent(rdbtnSur)
                                        .addComponent(lblElegirOrientacion)
                                        .addComponent(rdbtnNorte))
                                .addContainerGap(331, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblElegirOrientacion)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(rdbtnNorte)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(rdbtnSur)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(rdbtnEste)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(rdbtnOeste)
                                .addContainerGap(176, Short.MAX_VALUE))
        );
        setLayout(groupLayout);

    }
    public JRadioButton[] getBotonesPosicion(){
        return btnPosicion;
    }
    public void cambiarFondo(Color color){
        this.setBackground(color);
        btnPosicion[0].setBackground(color);
        btnPosicion[1].setBackground(color);
        btnPosicion[2].setBackground(color);
        btnPosicion[3].setBackground(color);
    }
}
