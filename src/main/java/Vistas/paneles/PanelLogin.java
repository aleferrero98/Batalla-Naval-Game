package Vistas.paneles;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class PanelLogin extends JPanel {
    private JTextField txtCampotexto;
    private ArrayList<JButton> listaBotones;
    private ArrayList<JRadioButton> listaRadioBotones;
    private JPanel avatar1;
    private JPanel avatar2;
    private JPanel avatar3;
    /**
     * Create the panel.
     */
    public PanelLogin() {
        this.setSize(500,500);

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");
        JLabel lblEligeTuAvatar = new JLabel("Elige tu avatar");
        JLabel lblNombre = new JLabel("Nombre:");

        //JPanel avatar1 = new PanelAvatar(new ImageIcon("C:\\Users\\alejandro\\Documents\\GitHub\\Ing-de-Software\\src\\main\\java\\Vistas\\imagenesAvatar\\flash.jpg"));
        //JPanel avatar2 = new PanelAvatar(new ImageIcon("C:\\Users\\alejandro\\Documents\\GitHub\\Ing-de-Software\\src\\main\\java\\Vistas\\imagenesAvatar\\batman.jpg"));
        //JPanel avatar3 = new PanelAvatar(new ImageIcon(("C:\\Users\\alejandro\\Documents\\GitHub\\Ing-de-Software\\src\\main\\java\\Vistas\\imagenesAvatar\\spiderman.jpg")));

        avatar1 = new PanelAvatar(new ImageIcon("src\\main\\java\\Vistas\\imagenesAvatar\\flash.jpg"));
        avatar2 = new PanelAvatar(new ImageIcon("src\\main\\java\\Vistas\\imagenesAvatar\\batman.jpg"));
        avatar3 = new PanelAvatar(new ImageIcon("src\\main\\java\\Vistas\\imagenesAvatar\\spiderman.jpg"));

        txtCampotexto = new JTextField();
        txtCampotexto.setColumns(10);

        JRadioButton rdbtnFlash = new JRadioButton("flash");
        JRadioButton rdbtnBatman = new JRadioButton("batman");
        JRadioButton rdbtnSpiderman = new JRadioButton("spiderman");

        listaBotones = new ArrayList<JButton>();
        listaRadioBotones = new ArrayList<JRadioButton>();
        listaRadioBotones.add(rdbtnFlash);
        listaRadioBotones.add(rdbtnBatman);
        listaRadioBotones.add(rdbtnSpiderman);
        listaBotones.add(btnAceptar);
        listaBotones.add(btnCancelar);

        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(43)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(lblNombre)
                                                                .addGap(8))
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addComponent(avatar1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(32))))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(82)
                                                .addComponent(btnAceptar)))
                                .addGap(8)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGap(18)
                                                .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                                        .addComponent(btnCancelar)
                                                        .addComponent(txtCampotexto, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(groupLayout.createSequentialGroup()
                                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblEligeTuAvatar)
                                                        .addGroup(groupLayout.createSequentialGroup()
                                                                .addGap(10)
                                                                .addComponent(avatar2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(36)
                                                .addComponent(avatar3, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
                                .addGap(195))
                        .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                                .addGap(68)
                                .addComponent(rdbtnFlash)
                                .addGap(102)
                                .addComponent(rdbtnBatman)
                                .addGap(79)
                                .addComponent(rdbtnSpiderman)
                                .addContainerGap(214, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(35)
                                .addComponent(lblEligeTuAvatar)
                                .addGap(42)
                                .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                        .addComponent(avatar3, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                        .addComponent(avatar1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                        .addComponent(avatar2, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                                .addGap(18)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(rdbtnFlash)
                                        .addComponent(rdbtnBatman)
                                        .addComponent(rdbtnSpiderman))
                                .addGap(115)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNombre)
                                        .addComponent(txtCampotexto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnAceptar)
                                        .addComponent(btnCancelar))
                                .addGap(24))
        );
        setLayout(groupLayout);
    }
    /*
    @Override
    public void paintComponent(Graphics g) {
        Dimension tamanio=getSize();
        ImageIcon imagen=new ImageIcon(getClass().getResource("/imagenesFondo/batallanaval4.jpg"));
        g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        setOpaque(false);
        super.paintComponent(g);
    }*/
    public ArrayList<JButton> getBotones(){
        return listaBotones;
    }
    public ArrayList<JRadioButton> getRadioBotones(){
        return listaRadioBotones;
    }
    public JTextField getCampoTexto() {
        return txtCampotexto;
    }

    public void cambiarFondo(Color color){
        this.setBackground(color);
        for(JRadioButton radioboton: listaRadioBotones){
            radioboton.setBackground(color);
        }
        avatar1.setBackground(color);
        avatar2.setBackground(color);
        avatar3.setBackground(color);
    }
}


