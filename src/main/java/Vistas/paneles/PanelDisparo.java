package Vistas.paneles;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelDisparo extends JPanel {
    private JButton[] btnDisparos;

    /**
     * Create the panel.
     */
    public PanelDisparo() {
        this.setSize(154, 187);

        JLabel lblElegirTipoDe = new JLabel("Elegir tipo de disparo:");

        JButton btnDisparoComun = new JButton("Disparo Comun");

        JButton btnDisparoCruz = new JButton("Disparo Cruz");

        JButton btnDisparoRandom = new JButton("Disparo Random");

        JButton btnDisparoCortado = new JButton("Disparo Cortado");

        JButton btnDisparoTermodirigido = new JButton("Disparo Termodirigido");

        btnDisparos = new JButton[5];   //hay 5 tipos de disparos (botones)
        btnDisparos[0] = btnDisparoComun;
        btnDisparos[1] = btnDisparoCruz;
        btnDisparos[2] = btnDisparoRandom;
        btnDisparos[3] = btnDisparoCortado;
        btnDisparos[4] = btnDisparoTermodirigido;

        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblElegirTipoDe)
                                        .addComponent(btnDisparoComun)
                                        .addComponent(btnDisparoCruz)
                                        .addComponent(btnDisparoRandom)
                                        .addComponent(btnDisparoCortado)
                                        .addComponent(btnDisparoTermodirigido))
                                .addContainerGap(329, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblElegirTipoDe)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnDisparoComun)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnDisparoCruz)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnDisparoRandom)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnDisparoCortado)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnDisparoTermodirigido)
                                .addContainerGap(125, Short.MAX_VALUE))
        );
        setLayout(groupLayout);

    }
    public JButton[] getBotonesDisp(){
        return btnDisparos;
    }

}