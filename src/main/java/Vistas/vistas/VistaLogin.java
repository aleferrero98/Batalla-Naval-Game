package Vistas.vistas;

import Controlador.Controlador;
import Modelo.Modelo;
import Modelo.Observer;
import Vistas.paneles.PanelLogin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class VistaLogin implements ActionListener, Observer {
    private JFrame frame;
    private PanelLogin panel;
    private ArrayList<JButton> botones;
    private ArrayList<JRadioButton> radioBotones;
    private JTextField campoTexto;
    private Controlador controlador;
    private Modelo modelo;

    public VistaLogin(Controlador controlador, Modelo modelo) {
        frame=new JFrame("Inicio");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,0,500,500);
        panel = new PanelLogin();
        frame.add(panel,BorderLayout.CENTER);
        botones=panel.getBotones();
        radioBotones=panel.getRadioBotones();
        campoTexto=panel.getCampoTexto();
        setObserver();
        this.controlador = controlador;
        this.modelo = modelo;
        this.modelo.addObserver(this);

    }
    public void hacerVisible(boolean b) {
        frame.setVisible(b);
    }
    public void ubicarAlMedio() {
        frame.setLocationRelativeTo(null);
    }
    private void setObserver() {
        for(JButton boton: botones) {
            boton.addActionListener(this);
        }
        for(JRadioButton radioBoton: radioBotones) {
            radioBoton.addActionListener(this);
        }
        campoTexto.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==radioBotones.get(0) && radioBotones.get(0).isSelected()) {
            System.out.println("radioboton flash");
            radioBotones.get(1).setSelected(false);
            radioBotones.get(2).setSelected(false);
            controlador.setAvatarJ1("FLASH");
        }else if(e.getSource()==radioBotones.get(1) && radioBotones.get(1).isSelected()) {
            System.out.println("radioboton batman");
            radioBotones.get(0).setSelected(false);
            radioBotones.get(2).setSelected(false);
            controlador.setAvatarJ1("BATMAN");
        }else if(e.getSource()==radioBotones.get(2) && radioBotones.get(2).isSelected()) {
            System.out.println("radioboton spiderman");
            radioBotones.get(0).setSelected(false);
            radioBotones.get(1).setSelected(false);
            controlador.setAvatarJ1("SPIDERMAN");
        }else if(e.getSource()==campoTexto) {
            controlador.setNombreJ1(campoTexto.getText());
            System.out.println("campotexto escrito");
        }else if(e.getSource()==botones.get(0)) {
            System.out.println("boton aceptar");
            controlador.registrarJugador();
            controlador.volverInicio();
        }else if(e.getSource()==botones.get(1)) {
            System.out.println("boton cancelar");
            this.controlador.volverInicio();
        }

    }
    public void cambiarFondo(Color color) { //cambia el color del fondo entre 5 valores posibles
        panel.setBackground(color);
    }

    public void update() {

    }

}
