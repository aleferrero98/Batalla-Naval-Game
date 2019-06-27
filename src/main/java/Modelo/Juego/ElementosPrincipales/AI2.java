package Modelo.Juego.ElementosPrincipales;

import Modelo.Excepciones.InvalidDisparoException;

import java.util.Random;

public class AI2 {

    public void disparoAleatorio(Jugador jugador2) {
        int tamanio = jugador2.getTableroDisparos().getFilas();
        Random r = new Random();
        int filaRandom = r.nextInt(tamanio);
        int colRandom = r.nextInt(tamanio);
        try {
            jugador2.disparar(filaRandom, colRandom);
        }catch (InvalidDisparoException e){
            System.out.println("no se pudo disparar AI2");
        }
    }
}
