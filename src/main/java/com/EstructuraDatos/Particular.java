package com.EstructuraDatos;

/**
 * Clase que almacena los datos de los vehículos de los trabajadores del Ayuntamiento
 * @author Antonio Ramos
 */
public final class Particular extends Vehiculo{
    private String propietario;
    private int numeroPlazaAparcamiento;

    public Particular(String matricula, String marca, String modelo, String propietario, int numeroPlazaAparcamiento) {
        super(matricula, marca, modelo);
        this.propietario = propietario;
        if(numeroPlazaAparcamiento > 0 && numeroPlazaAparcamiento <= 300)
            this.numeroPlazaAparcamiento = numeroPlazaAparcamiento;
        else
            this.numeroPlazaAparcamiento = 0;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getNumeroPlazaAparcamiento() {
        return numeroPlazaAparcamiento;
    }

    public void setNumeroPlazaAparcamiento(int numeroPlazaAparcamiento) {
        if(numeroPlazaAparcamiento > 0 && numeroPlazaAparcamiento <= 300)
            this.numeroPlazaAparcamiento = numeroPlazaAparcamiento;
    }

    @Override
    public String toString() {
        return super.toString() + ", propietario: " + propietario + ", número de plaza de aparcamiento: " + numeroPlazaAparcamiento;
    }
    
    
}
