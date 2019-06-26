package Modelo.Juego.ElementosPrincipales;

public class EstadoDelJuego {
    boolean esTurnoDelJ1;
    boolean esTurnoDelJ2;
    boolean barcosJ1Posicionados;
    boolean barcosJ2Posicionados;
    boolean ganoJ1;
    boolean ganoJ2;
    boolean colocandoBarcos;
    boolean disparando;

    public EstadoDelJuego(){
        barcosJ1Posicionados=false;
        barcosJ2Posicionados=false;
        colocandoBarcos=true;
        disparando=false;
        ganoJ1=false;
        ganoJ2=false;
        esTurnoDelJ1=false;
        esTurnoDelJ2=false;
    }
    public boolean isColocandoBarcos() {
        return colocandoBarcos;
    }

    public boolean isDisparando() {
        return disparando;
    }
    public boolean todosPosicionados(){
        return (barcosJ1Posicionados && barcosJ2Posicionados);
    }
    public boolean hayGanador(){
        return (ganoJ1||ganoJ2);
    }
    public boolean isEsTurnoDelJ1() {
        return esTurnoDelJ1;
    }

    public boolean isEsTurnoDelJ2() {
        return esTurnoDelJ2;
    }
    public void setEsTurnoDelJ1(boolean esTurnoDelJ1) {
        this.esTurnoDelJ1 = esTurnoDelJ1;
    }

    public void setEsTurnoDelJ2(boolean esTurnoDelJ2) {
        this.esTurnoDelJ2 = esTurnoDelJ2;
    }
    public void setBarcosJ1Posicionados(boolean barcosJ1Posicionados) {
        this.barcosJ1Posicionados = barcosJ1Posicionados;
    }

    public void setBarcosJ2Posicionados(boolean barcosJ2Posicionados) {
        this.barcosJ2Posicionados = barcosJ2Posicionados;
    }

    public void setColocandoBarcos(boolean colocandoBarcos) {
        this.colocandoBarcos = colocandoBarcos;
    }

    public void setDisparando(boolean disparando) {
        this.disparando = disparando;
    }

}
