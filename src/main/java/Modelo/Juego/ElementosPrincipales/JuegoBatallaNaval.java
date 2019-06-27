package Modelo.Juego.ElementosPrincipales;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Excepciones.InvalidPosicionBarco;
import Modelo.Juego.FactoryBarcos.AstilleroMilitar;
import Modelo.Juego.FactoryBarcos.FabricaDeBarcos;
import Modelo.Juego.FactoryBarcos.TipoDeBarco;
import Modelo.Juego.StrategyDisparo.*;

import java.util.HashMap;

public class JuegoBatallaNaval {

    private final int BLANCO = 0;
    private final int AZUL = 1;
    private final int AMARILLO = 2;
    private final int ROJO = 3;

    private final int TABLERO_SIZE = 13;

    private final int CANT_D_ALEATORIO = 2;
    private final int CANT_D_TERMODIRIGIDO = 1;
    private final int CANT_D_CRUZ = 1;
    private final int CANT_D_CORTADO = 2;
    private final int CANT_D_COMUN = (TABLERO_SIZE * TABLERO_SIZE) + 1;

    private final int CANT_B_PORTAAVIONES = 1;
    private final int CANT_B_DESTRUCTORES = 2;
    private final int CANT_B_CANIONEROS = 1;
    private final int CANT_B_FRAGATAS = 1;
    private final int CANT_B_SUBMARINOS = 1;

    private Jugador jugador1; //usuario
    private Jugador jugador2; //maquina
    private Tablero tableroBarcosJ1;
    private Tablero tableroBarcosJ2;
    private FabricaDeBarcos asttillero;
    private EstadoDelJuego estado;
    private AI ai;

    private boolean turnoJugador1;

    public JuegoBatallaNaval(EstadoDelJuego estado) {
        this.estado = estado;
        this.estado.crearMatrizJugadorN1(TABLERO_SIZE,TABLERO_SIZE);
        this.asttillero = new AstilleroMilitar();
        crearTableros();
        crearJugadores();
        setearDisparosDisponibles();
        setearBarcosDisponibles();
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Tablero getTableroBarcosJ1() {
        return tableroBarcosJ1;
    }

    public Tablero getTableroBarcosJ2() {
        return tableroBarcosJ2;
    }

    public EstadoDelJuego getEstado() {
        return estado;
    }

    public boolean isTurnoJugador1() {
        return turnoJugador1;
    }

    private void crearTableros(){
        tableroBarcosJ1 = new Tablero(TABLERO_SIZE);
        tableroBarcosJ2 = new Tablero(TABLERO_SIZE);
    }

    private void crearJugadores(){
        jugador1 = new Jugador(tableroBarcosJ1,tableroBarcosJ2);
        //jugador2 = new Jugador(tableroBarcosJ2,tableroBarcosJ1);
        jugador1.setManeraDeDisparar(new DisparoComun());
        //jugador2.setManeraDeDisparar(new DisparoComun());
        this.ai = new AI(tableroBarcosJ2,tableroBarcosJ1);
    }

    private void setearDisparosDisponibles() {
        jugador1.setDisparosDisponibles(crearHashMapDeDisparos());
        jugador2.setDisparosDisponibles(crearHashMapDeDisparos());
    }

    private void setearBarcosDisponibles() {
        jugador1.setBarcosDisponibles(crearHashMapDeBarcos());
        jugador2.setBarcosDisponibles(crearHashMapDeBarcos());
    }

    private HashMap<Disparo, Integer> crearHashMapDeDisparos() {
        HashMap<Disparo, Integer> disparos = new HashMap<>();
        disparos.put(Disparo.ALEATORIO, CANT_D_ALEATORIO);
        disparos.put(Disparo.COMUN, CANT_D_COMUN);
        disparos.put(Disparo.CORTADO, CANT_D_CORTADO);
        disparos.put(Disparo.CRUZ, CANT_D_CRUZ);
        disparos.put(Disparo.TERMODIRIGIDO, CANT_D_TERMODIRIGIDO);

        return disparos;
    }

    private HashMap<TipoDeBarco, Integer> crearHashMapDeBarcos() {
        HashMap<TipoDeBarco, Integer> barcos = new HashMap<>();
        barcos.put(TipoDeBarco.CANIONERO, CANT_B_CANIONEROS);
        barcos.put(TipoDeBarco.DESTRUCTOR, CANT_B_DESTRUCTORES);
        barcos.put(TipoDeBarco.FRAGATA, CANT_B_FRAGATAS);
        barcos.put(TipoDeBarco.PORTAAVIONES, CANT_B_PORTAAVIONES);
        barcos.put(TipoDeBarco.SUBMARINO, CANT_B_SUBMARINOS);

        return barcos;
    }

    public void setDisparoJ1(Disparo d) {
        jugador1.setManeraDeDisparar(toDisparoBehavior(d));
    }

    private DisparoBehavior toDisparoBehavior(Disparo d){
        switch (d){
            case ALEATORIO: return new DisparoAleatorio();
            case COMUN: return new DisparoComun();
            case CRUZ: return new DisparoCruz();
            case CORTADO: return new DisparoCortado();
            case TERMODIRIGIDO: return new DisparoTermodirigido();
            default:
                throw new IllegalStateException("Unexpected value: " + d);
        }
    }

    public void barcoActualJ1(TipoDeBarco b) {
        if(jugador1.barcoParaPonerDisponible(b)){
            jugador1.setBarcoSeleccionado(asttillero.encargarBarco(b)); //FACTORY !!!
        }
    }

    public void colocarBarcoJ1(char orientacion, int fila, int columna) throws InvalidPosicionBarco {
        if(estado.isColocandoBarcos()) {
            this.jugador1.colocarBarco(orientacion, fila, columna);
        }
    }

    public void habilitarBarcos() {
        estado.setColocandoBarcos(true);
    }

    public void deshabilitarBarcos() {
        estado.setColocandoBarcos(false);
    }

    public void habilitarDisparos(){
        estado.setDisparando(true);
        jugador1.getTableroBarcos().activarTablero();
        jugador2.getTableroBarcos().activarTablero();
        /* Deberia bastar con lo de arriba
        jugador1.getTableroDisparos().activarTablero();
        jugador2.getTableroDisparos().activarTablero();
         */
    }

    public void desHabilitarDisparos(){
        estado.setDisparando(false);
    }


    public void actualizarMatrizJ1(){
        int[][] mat = estado.getMatrizJugadorN1();
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                Celda c = tableroBarcosJ1.getCelda(i,j);
                if(estado.isDisparando() && (c.isActivada()==false)){
                    if(c.isCeldaConBarco()) mat[i][j] = ROJO;
                    else mat[i][j] = AMARILLO;
                }
                else if(estado.isColocandoBarcos()){
                    if(c.isCeldaConBarco()) mat[i][j] = AZUL;
                }
            }
        }
        estado.setMatrizJugadorN1(mat);
    }

    public void actualizarMatrizJ2(){
        int[][] mat = estado.getMatrizJugadorN2();
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                Celda c = tableroBarcosJ2.getCelda(i,j);
                if(estado.isDisparando() && (c.isActivada()==false)){
                    if(c.isCeldaConBarco()) mat[i][j] = ROJO;
                    else mat[i][j] = AMARILLO;
                }
            }
        }
        estado.setMatrizJugadorN2(mat);
    }




    public void disparaMaquina() throws InvalidDisparoException {
        this.ai.disparoAleatorio();
        actualizarMatrizJ1();
    }

    public void setBarcosMaquina(){
        this.ai.colocarTodosBarcos();
    }


}
