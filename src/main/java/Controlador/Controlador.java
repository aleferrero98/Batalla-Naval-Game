package Controlador;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.Juego.FactoryBarcos.TipoDeBarco;
import Modelo.Juego.StrategyDisparo.Disparo;
import Modelo.*;

import java.awt.*;
import java.util.ArrayList;

public class Controlador implements Observer {
    private Modelo modelo;
    private VistaConfig vistaConfig;
    private VistaInicio vistaInicio;
    private VistaLogin vistaLogin;
    private VistaJuego vistaJuego;


    public Controlador() {
        vistaInicio = new VistaInicio(this);
        vistaConfig = new VistaConfig(this);
        vistaLogin = new VistaLogin(this);
        vistaJuego = new VistaJuego(this);
        vistaInicio.ubicarAlMedio();
        vistaConfig.ubicarAlMedio();
        vistaLogin.ubicarAlMedio();
        vistaJuego.ubicarAlMedio();

        vistaInicio.hacerVisible(true);
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
    }

    public void dispararEnTablero(int fila, int columna) throws InvalidDisparoException {
        modelo.dispararEn(fila,columna);
    }
    public void elegirDisparo(String disparo){
        modelo.setDisparo(toDisparo(disparo));
    }
    public void pausar(){
        modelo.pausar(true);
    }
    public void continuar(){
        modelo.pausar(false);
    }
    public void elegirBarco(String tipoDeBarco){
        modelo.selecBarco(toBarco(tipoDeBarco));
    }
    public void ponerBarco(char orientacion, int fila, int columna)throws InvalidPosicionBarco {
        modelo.setBarcoActual(orientacion,fila,columna);
    }
    public void irLogIn(){
        /*
        se apaga la vista de inicio
        se enciende la vista de LogIn
         */
        vistaInicio.hacerVisible(false);
        vistaLogin.hacerVisible(true);

    }
    public void volverInicio(){
        /*
        se apaga la vista de login o configuracion
        se enciende la vista de LogIn
         */
        vistaLogin.hacerVisible(false);
        vistaConfig.hacerVisible(false);
        vistaInicio.hacerVisible(true);
    }
    public void irConfigAyuda(){
        /*
        se apaga la vista de inicio
        se enciende la vista de configuracion y ayuda
         */
        vistaInicio.hacerVisible(false);
        vistaConfig.hacerVisible(true);
    }
    public void irJuego(){
        if(modelo.estaRegistrado()){
            /*
            se apaga la vista de inicio
            se enciende la vista de juego
             */
            vistaInicio.hacerVisible(false);
            vistaJuego.hacerVisible(true);
            modelo.crearJuego();
            modelo.puedePonerBarcos(true);
            modelo.puedeDisparar(false);
        }
    }

    public void start(){
        if(modelo.estaListoParaJugar()){
            modelo.puedeDisparar(true);
            modelo.puedePonerBarcos(false);
            modelo.runJuego();
        }
    }

    public void registrarJugador(String nombre, String avatar){
        if(nombre != null && avatar !=null) {
            modelo.registrarJugador1(toAvatar(avatar), nombre);
        }
    }

    /**
     * setear el mismo color a las vistas menos la de inicio
     * @param color
     */
    public void selecColor(Color color){
        vistaConfig.cambiarFondo(color);
        vistaLogin.cambiarFondo(color);
        vistaJuego.cambiarFondo(color);

    }

    public void mute(){
    }
    public void unmute(){

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


    private Avatar toAvatar(String s) {
        s = s.toUpperCase();
        switch (s){
            case "FLASH": return Avatar.FLASH;
            case "SPIDERMAN": return Avatar.SPIDERMAN;
            case "BATMAN": return Avatar.BATMAN;
            default: throw new IllegalStateException("Unexpected value: " + s);
        }
    }

    @Override
    public void update() {

    }

}