package Modelo.Juego.ElementosPrincipales;

import Modelo.Juego.FactoryBarcos.FabricaDeBarcos;
import Modelo.Juego.FactoryBarcos.TipoDeBarco;
import Modelo.Juego.StrategyDisparo.Disparo;
import Modelo.Juego.StrategyDisparo.DisparoComun;

import java.util.HashMap;

public class JuegoBatallaNaval {

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
    private FabricaDeBarcos Asttillero;
    private EstadoDelJuego estado;
    private AI ai;

    public JuegoBatallaNaval(EstadoDelJuego estado) {
        this.estado = estado;
        crearTableros();
        crearJugadores();
        setearDisparosDisponibles();
        setearBarcosDisponibles();
    }

    /*
    crear los jugadores
    crear los barcos
    crear los tableros
    setear los disparos disponibles
    setear los barcos disponibles
    crear un estado e ir modificandolo
     */

    private void crearTableros(){
        tableroBarcosJ1 = new Tablero(TABLERO_SIZE);
        tableroBarcosJ2 = new Tablero(TABLERO_SIZE);
    }

    private void crearJugadores(){
        jugador1 = new Jugador(tableroBarcosJ1,tableroBarcosJ2);
        jugador2 = new Jugador(tableroBarcosJ2,tableroBarcosJ1);
        jugador1.setManeraDeDisparar(new DisparoComun());
        jugador2.setManeraDeDisparar(new DisparoComun());

        this.ai = new AI();
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
}
