package Modelo.StrategyDisparo;

import Modelo.Excepciones.InvalidDisparoException;
import Modelo.Tablero;

public class DisparoCruz implements DisparoBehavior{
    @Override
    public void disparar(int fila,int columna,Tablero tableroDisparos)throws InvalidDisparoException {
        if(comprobarDisparo_Completo(fila,columna,tableroDisparos)){
            tableroDisparos.dispararUna(fila, columna);
            tableroDisparos.dispararUna(fila+1,columna+1);
            tableroDisparos.dispararUna(fila+1,columna-1);
            tableroDisparos.dispararUna(fila-1,columna+1);
            tableroDisparos.dispararUna(fila-1,columna-1);
        }
        else disparo_Incompleto(fila,columna,tableroDisparos);
    }
    @Override
    public Disparo getTipo(){
        return Disparo.CRUZ;
    }
    public boolean comprobarDisparo_Completo(int fila,int columna,Tablero tableroDisparos){
        if(tableroDisparos.esValido(fila,columna))
            if(tableroDisparos.esValido(fila+1,columna+1))
                if(tableroDisparos.esValido(fila-1,columna-1))
                    if(tableroDisparos.esValido(fila-1,columna+1))
                        if(tableroDisparos.esValido(fila+1,columna-1))
                            return true;
        return false;
    }
    public void disparo_Incompleto(int fila, int columna,Tablero tableroDisparos){
        try {
            if (tableroDisparos.esValido(fila, columna))
                tableroDisparos.dispararUna(fila, columna);
            if (tableroDisparos.esValido(fila + 1, columna + 1))
                tableroDisparos.dispararUna(fila + 1, columna + 1);
            if (tableroDisparos.esValido(fila - 1, columna - 1))
                tableroDisparos.dispararUna(fila - 1, columna - 1);
            if (tableroDisparos.esValido(fila - 1, columna + 1))
                tableroDisparos.dispararUna(fila - 1, columna + 1);
            if (tableroDisparos.esValido(fila + 1, columna - 1))
                tableroDisparos.dispararUna(fila + 1, columna - 1);
        }catch (InvalidDisparoException e){
            e.printStackTrace();
        }
    }
}
