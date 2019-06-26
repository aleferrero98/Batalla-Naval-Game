package Controlador;

import Modelo.Juego.FactoryBarcos.TipoDeBarco;
import Modelo.Juego.StrategyDisparo.Disparo;
import Modelo.*;

import java.awt.*;
import java.util.ArrayList;

public class Controlador implements Observer {
    private Modelo modelo;
    private Vista vista;


    public Controlador() {
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
    }

    public void accion(AccionEnVista accion, ArrayList<String> s){
        switch (accion){
            case DISPARAR: {
                int fila = Integer.parseInt(s.get(0));
                int columna = Integer.parseInt(s.get(1));
                modelo.dispararEn(fila,columna);
            }
            break;
            case ELIJE_DISPARO:{
                    Disparo d = toDisparo(s.get(0));
                    modelo.setDisparo(d);
            }
            break;
            case PAUSAR:{
                modelo.pausar();
            }
            break;
            case CONTINUAR:{
                modelo.salirDePausa();
            }
            break;
            case ELIJE_BARCO:{
                TipoDeBarco b = toBarco(s.get(0));
                modelo.selecBarco(b);
            }
            break;
            case PONE_BARCO:{
                char orientacion = s.get(0).charAt(0);
                int fila = Integer.parseInt(s.get(1));
                int columna = Integer.parseInt(s.get(2));
                modelo.setBarcoActual(orientacion,fila,columna);
            }
            break;
            case IR_A_REGISTRO:{
                modelo.abrirRegistro();
            }
            break;
            case CONFIG_AYUDA:{
                modelo.abrirConfig();
            }
            break;
            case INICIAR_JUEGO:{
                modelo.irJuego();
                modelo.PuedePonerBarcos(true);
                modelo.PuedeDisparar(false);
            }
            break;
            case JUGAR:{
                modelo.PuedePonerBarcos(false);
                modelo.PuedeDisparar(true);

            }
            break;
            case REGISTRARSE:{
                Avatar avatar = toAvatar(s.get(0));
                String nombre = s.get(1);
                modelo.registrarJugador1(avatar, nombre);
                modelo.irInicio();
            }
            break;
            case SELEC_COLOR:{
                Color c = toColor(s.get(0));
                modelo.setColor(c);
            }
            break;
            case MUTE:{
                modelo.sonido(true);
            }
            break;
            case UNMUTE:{
                modelo.sonido(false);
            }

            default:
                throw new IllegalStateException("Unexpected value: " + accion);
        }

    }


    private Disparo toDisparo(String s) {
        s = s.toUpperCase();
        switch (s){
            case "ALEATORIO": return Disparo.ALEATORIO;
            case "COMUN": return Disparo.COMUN;
            case "CORTADO": return Disparo.CORTADO;
            case "CRUZ": return Disparo.CRUZ;
            case "TERMODIRIGIDO": return Disparo.TERMODIRIGIDO;
            default: throw new IllegalStateException("Unexpected value: " + s);
        }
    }

    private TipoDeBarco toBarco(String s) {
        s = s.toUpperCase();
        switch (s){
            case "CANIONERO": return TipoDeBarco.CANIONERO;
            case "DESTRUCTOR": return TipoDeBarco.DESTRUCTOR;
            case "FRAGATA": return TipoDeBarco.FRAGATA;
            case "PORTAAVIONES": return TipoDeBarco.PORTAAVIONES;
            case "SUBMARINO": return TipoDeBarco.SUBMARINO;
            default: throw new IllegalStateException("Unexpected value: " + s);
        }
    }

    private Color toColor(String s){
        s = s.toUpperCase();
        switch (s){
            case "GRIS": return Color.GRAY;
            case "VERDE": return Color.GREEN;
            case "AMARILLO": return Color.YELLOW;
            case "NARANJA": return Color.ORANGE;
            case "BLANCO": return Color.WHITE;
            default: throw new IllegalStateException("Unexpected value: " + s);
        }
    }

    private Avatar toAvatar(String s) {
        s = s.toUpperCase();
        switch (s){
            case "FALSH": return Avatar.FLASH;
            case "SPIDERMAN": return Avatar.SPIDERMAN;
            case "BATMAN": return Avatar.BATMAN;
            default: throw new IllegalStateException("Unexpected value: " + s);
        }
    }

    @Override
    public void update() {

    }
}
