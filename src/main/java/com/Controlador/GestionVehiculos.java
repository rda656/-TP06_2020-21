package com.Controlador;

import com.EstructuraDatos.*;
import com.EstructuraDatos.Enumerados.cuerpo;

/**
 * Clase que realiza la gestión de los datos almacenados en 
 * @author Antonio Ramos
 */
public class GestionVehiculos {

    private static Vehiculo[] vehiculos;
    private static int posicion;

    /**
     * Método que instancia los arrays.
     */
    public static void inicializar() {
        vehiculos = new Vehiculo[10];
        posicion = 0;

        vehiculos[0] = new Particular("1234DDD", "Ford", "Mondeo", "Alfredo", 20);
        vehiculos[1] = new Oficial("5678ASS", "Fiat", "Punto", cuerpo.POLICIALOCAL, 4);
        vehiculos[2] = new Particular("7777AAA", "Opel", "Astra", "Juan", 1);        
        vehiculos[3] = new Oficial("6547WWW", "Seat", "Panda", cuerpo.URBANISMO, 5);
    }

    /**
     * Devuelve la posición del último registro al que se ha accedido del array. 
     * @return posición actual del array.
     */
    public static int getPosicion() {
        return posicion;
    }

    /**
     * Devuelve el primer registro del array vehículos. 
     * @return primer vehículo.
     */
    public static Vehiculo primerRegistro() {
        posicion = 0;
        return vehiculos[0];
    }

    /**
     * Devuelve el registro anterior al actual.
     * @return vehículo anterior.
     */
    public static Vehiculo anteriorRegistro() {
        return registroVehiculo(-1);
    }

    /**
     * Devuelve el registro siguiente al actual.
     * @return vehículo siguiente.
     */
    public static Vehiculo siguienteRegistro() {
        return registroVehiculo(1);
    }
    
    /**
     * Devuelve el último registro almacenado en el array.
     * @return último vehículo.
     */
    public static Vehiculo ultimoRegistro(){
        for(int i = 0; i < vehiculos.length; i++){
            if(vehiculos[i] == null){
                if(i == 0)
                    return null;
                else{
                    posicion = i-1;
                    return vehiculos[i-1];
                }                    
            }
        }
        return vehiculos[vehiculos.length -1];
    }
    
    /**
     * Devuelve el registro al que apunta el atributo posición.
     * @return vehículo al que apunta "posición".
     */
    public static Vehiculo actualRegistro(){
        return registroVehiculo(0);
    }

    /**
     * Método que permite mostrar la información de un vehículo del array. 
     * @return devuelve el vehículo si existe un registro o null en caso contrario.
     */
    private static Vehiculo registroVehiculo(int incremento) {
        int nuevaPosicion = posicion + incremento;
        if (nuevaPosicion >= 0 && nuevaPosicion < vehiculos.length) {
            if (vehiculos[nuevaPosicion] != null) {
                posicion = nuevaPosicion;
                return vehiculos[nuevaPosicion];
            }
        }
        return null;
    }

    /**
     * Método que devuelve el array vehículos.
     * @return array de vehículos.
     */
    public static Vehiculo[] todosRegistrosVehiculos() {
        return vehiculos;
    }

    /**
     * Método que devuelve la última posición del array que contiene datos de un vehículo.
     * @return última posición del array con datos.
     */
    public static int posicionUltimoRegistroVehiculos() {
        for (int i = 0; i < vehiculos.length; i++) {
            if (vehiculos[i] == null) {
                if(i == 0)
                    return 0;
                else
                    return i - 1;
            }
        }

        return vehiculos.length - 1;
    }

    
    public static boolean aniadirVehiculo() {
        return true;
    }

    /**
     * Método que permite eliminar un registro del array.
     * @return devuelve true si se ha podido realizar el borrado y false si no hay registros almacenados.
     */
    private static boolean eliminarVehiculo() {
        return true;
    }

    /**
     * Método que permite modificar los datos de un vehículo oficial.
     * @param matricula nueva matrícula.
     * @param marca nueva marca.
     * @param modelo nuevo modelo.
     * @param cPertenece nuevo cuerpo al que pertenece el vehículo.
     * @param numeroPlazas cantidad de número de plazas que posee.
     */
    public static void modificarVehiculo(String matricula, String marca, String modelo, cuerpo cPertenece, int numeroPlazas) {
        vehiculos[posicion].setMatricula(matricula);
        vehiculos[posicion].setMarca(marca);
        vehiculos[posicion].setModelo(modelo);
        
        ((Oficial)vehiculos[posicion]).setCPertenece(cPertenece);
        ((Oficial)vehiculos[posicion]).setNumeroPlazas(numeroPlazas);
    }
    
    /**
     * étodo que permite modificar los datos de un vehículo oficial.
     * @param matricula nueva matrícula.
     * @param marca nueva marca.
     * @param modelo nuevo modelo.
     * @param propietario nuevo dueño del vehículo.
     * @param numeroPlazaAparcamiento nueva plaza de aparcamiento asociada al vehículo.
     */
    public static void modificarVehiculo(String matricula, String marca, String modelo, String propietario, int numeroPlazaAparcamiento) {
        vehiculos[posicion].setMatricula(matricula);
        vehiculos[posicion].setMarca(marca);
        vehiculos[posicion].setModelo(modelo);
        
        ((Particular)vehiculos[posicion]).setPropietario(propietario);
        ((Particular)vehiculos[posicion]).setNumeroPlazaAparcamiento(numeroPlazaAparcamiento);
    }
}
