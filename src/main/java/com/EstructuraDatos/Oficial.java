package com.EstructuraDatos;

import com.EstructuraDatos.Enumerados.cuerpo;

/**
 * Clase que almacena los datos referentes a un vehículo oficial
 * @author Antonio Ramos
 */
public class Oficial extends Vehiculo{
    private cuerpo cPertenece;
    private int numeroPlazas;

    public Oficial(String matricula, String marca, String modelo, cuerpo cPertenece, int numeroPlazas) {
        super(matricula, marca, modelo);
        this.cPertenece = cPertenece;
        if(numeroPlazas < 1)
            this.numeroPlazas = 1;
        else
            this.numeroPlazas = numeroPlazas;
    }

    public  cuerpo getCPertenece() {
        return cPertenece;
    }

    public  void setCPertenece(cuerpo cPertenece) {
        this.cPertenece = cPertenece;
    }

    public  int getNumeroPlazas() {
        return numeroPlazas;
    }

    public  void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    @Override
    public String toString() {
        return super.toString() + ", cuerpo al que pertenece: " + cPertenece + ", número de plazas: " + numeroPlazas;
    }
    
    
}
