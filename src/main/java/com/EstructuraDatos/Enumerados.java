
package com.EstructuraDatos;

/**
 * Clase que almacena los distintos tipos de enumerados de nuestro proyecto
 * @author Antonio Ramos
 */
public class Enumerados {
    public enum cuerpo{
        AYUNTAMIENTO ("Ayuntamiento"), 
        POLICIALOCAL ("Policía local"),
        URBANISMO ("Urbanismo");
        
        private String nombre;
        
        private cuerpo(String nombre){
            this.nombre = nombre;
        }
        
        @Override
        public String toString(){ 
            return nombre;
        }
    }
}
