package Modelo.Juego.FactoryBarcos;


import Modelo.Juego.ElementosPrincipales.Barco;
import Modelo.Juego.FactoryBarcos.BarcosParaAstilleroMilitar.*;

public class AstilleroMilitar extends FabricaDeBarcos {

    public AstilleroMilitar() {
    }

    @Override
    public Barco construirBarco(TipoDeBarco tipoDeBarco) throws IllegalStateException{
        Barco barco;
        switch (tipoDeBarco){
            case FRAGATA: {
                barco = new Fragata();
                break;
            }
            case CANIONERO: {
                barco = new Canionero();
                break;
            }
            case SUBMARINO: {
                barco = new Submarino();
                break;
            }
            case DESTRUCTOR: {
                barco = new Destructor();
                break;
            }
            case PORTAAVIONES: {
                barco = new Portaaviones();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + tipoDeBarco);
        }
        return barco;
    }
}
