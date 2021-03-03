/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Utilidades;

import com.EstructuraDatos.Vehiculo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase Entrada-Salida que se encarga de realizar lecturas desde teclado y mostrar los datos por pantalla.
 * @author Antonio Ramos
 * @version 1.0
 */
public class ES {

    private static final String RUTA_DATOS = "datos.my";
    
    public static Object leerArchivo(String ruta){
        if(ruta.length() == 0){
            ruta = RUTA_DATOS;
        }
        try {
            // Abrimos el fichero para lectura
            FileInputStream fichero = new FileInputStream(ruta);
            ObjectInputStream ficheroEntrada = new ObjectInputStream(fichero);

            // Recuperar el objeto array del fichero
            Object datos = ficheroEntrada.readObject();
            
            // Cerrar el fichero
            ficheroEntrada.close();
            
            return datos;
        } 
        catch (ClassNotFoundException cnfe) {
             System.out.println("No se pudo acceder a la clase adecuada para revertir la Serialización al leer del fichero.");
        }
        catch (FileNotFoundException fnfe) {
             System.out.println("El fichero no existe.");
        }
        catch (IOException ioe) {
             System.out.println("Error de Entrada/Salida: Falló la lectura del fichero. La aplicación sigue funcionando sin haber cargado los datos del archivo, para permitir crearlo de nuevo.");
        }
        
        return null;
    }
    
    public static boolean escribirArchivo(String ruta, Object datos){
        try {
            if(ruta.length() == 0){
                ruta = RUTA_DATOS;
            }
            // Abrir fichero para escribir en él
            FileOutputStream fichero = new FileOutputStream(new File(ruta));
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(fichero);

            // Escribo el array en el fichero
            ficheroSalida.writeObject(datos);

            ficheroSalida.close();

            return true;

        } 
        catch (FileNotFoundException fnfe) {
            System.out.println("Error: El fichero no existe. ");
        }
        catch (IOException ioe) {
            System.out.println("Error: falló la escritura en el fichero ");
        }
        
        return false;
    }
    
    /**
     * Método que se encarga de realizar la lectura de un número entero desde teclado.
     * @return el valor entero leído desde teclado.
     */
    public static int leerEntero() {
        Scanner teclado = new Scanner(System.in);
                
        do{
            try {
                return teclado.nextInt();
            }
            catch(InputMismatchException e){
                System.err.println("Error. No ha introducido un número entero");
                System.out.print("Introduzca un nuevo valor: ");
                teclado.next();
            }
        }while(true);
    }
    
    /**
     * Método que se encarga de realizar la lectura de un número entero desde teclado.
     * @param mensaje texto que se quiere mostrar por pantalla.
     * @return el valor entero leído desde teclado.
     */
    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        //int n = leerEntero();
        //return n;
        return leerEntero();
    }
    
    /**
     * Método que se encarga de realizar la lectura de un número entero desde teclado que esté entre dos valores.
     * @param minimo valor mínimo que se admite.
     * @param maximo valor máximo que se admite.
     * @return número entero leído.
     */
    public static int leerEntero(int minimo,int maximo){
        int numero;
        do{
            numero = leerEntero();
            if(numero < minimo || numero > maximo)
                System.out.format("Error. El número debe estar comprendido entre %d y %d (ambos inclusive). Introduzca nuevamente un valor: ", minimo, maximo);
        }while(numero < minimo || numero > maximo);
        
        return numero;
    }
    
    /**
     * Método que se encarga de realizar la lectura de un número entero desde teclado que esté entre dos valores.
     * @param minimo valor mínimo que se admite.
     * @param maximo valor máximo que se admite.
     * @param mensaje texto que se quiere mostrar por pantalla.
     * @return número entero leído.
     */
    public static int leerEntero(int minimo,int maximo, String mensaje){
        System.out.print(mensaje);
        return leerEntero(minimo, maximo);
    }
    
    /**
     * Método que permite leer un caracter desde teclado. Si se introduce más de uno se quedará con el primero.
     * @param mensaje texto que se quiere mostrar por pantalla.
     * @return primer caracter leído.
     */
    public static char leerCaracter(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        System.out.print(mensaje);
        
        return teclado.next().charAt(0);
    }
    
    /**
     * Método que permite la lectura de una cadena de caracteres desde teclado.
     * @param mensaje texto que se quiere mostrar por pantalla.
     * @return cadena de caracteres leída.
     */
    public static String leerCadena(String mensaje){
        Scanner teclado = new Scanner(System.in);
        System.out.print(mensaje);
        
        return teclado.nextLine();
        
    }
    
    /**
     * Método que escribe un mensaje por pantalla.
     * @param mensaje texto que se quiere mostrar por pantalla.
     */
    public static void escribir(String mensaje){
        System.out.print(mensaje);
    }
}