package Modelo.FactoryBarcos;

import Modelo.Barco;

public abstract class FabricaDeBarcos {

    public Barco encargarBarco(TipoDeBarco tipoDeBarco){
        //
        Barco barco;
        barco = construirBarco(tipoDeBarco);
        return barco;
    }

    protected abstract Barco construirBarco(TipoDeBarco tipoDeBarco);
}
