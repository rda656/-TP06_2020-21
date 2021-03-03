package com.Vista;

import com.Controlador.App;
import com.Controlador.GestionVehiculos;
import com.EstructuraDatos.Oficial;
import com.EstructuraDatos.Particular;
import com.EstructuraDatos.Vehiculo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Clase que implementa la interfaz de usuario principal
 * @author Antonio Ramos
 * @version 1.0
 */
public class GUIPrincipal implements Initializable{

    @FXML
    private Button btn_Primero, btn_Anterior, btn_Siguiente, btn_Ultimo, 
            btn_Anadir, btn_Modificar, btn_Eliminar;

    @FXML
    private TextField textNumRegistro, tf_Matricula, tf_Marca, tf_NumPlazas, 
            tf_Modelo, tf_Cuerpo, tf_PlazaParking, tf_Propietario, tf_NumRegistro;

    /**
     * Método que se ejecuta una vez inicializada la interfaz gráfica
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        rellenarCampos(GestionVehiculos.actualRegistro());
    }
        
    /**
     * Método que permite cerrar la aplicación
     * @param event 
     */
    @FXML
    private void cerrar(ActionEvent event) {
        Platform.exit();
    }
    
    /**
     * Método que permite ir al primer registro guardado en el array vehículos o en el array autores.
     * @param event 
     */
    @FXML
    void desplazarseRegistros(ActionEvent event) {
        String boton = ((Button)event.getSource()).getId();
        
        switch(boton){
            case "btn_Primero":
                rellenarCampos(GestionVehiculos.primerRegistro());
                tf_NumRegistro.setText("0");
                break;
            case "btn_Anterior":
                rellenarCampos(GestionVehiculos.anteriorRegistro());
                tf_NumRegistro.setText("" + GestionVehiculos.getPosicion());
                break;
            case "btn_Siguiente":
                rellenarCampos(GestionVehiculos.siguienteRegistro());
                tf_NumRegistro.setText("" + GestionVehiculos.getPosicion());
                break;
            case "btn_Ultimo":
                rellenarCampos(GestionVehiculos.ultimoRegistro());
                tf_NumRegistro.setText("" + GestionVehiculos.getPosicion());
                break;
        }            
    }
    
    /**
     * Método que se lanza al pulsar el botón modificar y que abre la interfaz que permite
     * realizar cambios en los campos.
     * @param event
     * @throws IOException 
     */
    @FXML
    void modificarRegistro(ActionEvent event) throws IOException {
        App.setRoot("Modificar");
    }
    
    @FXML
    void eliminarRegistro(ActionEvent event) throws IOException {
        if(GestionVehiculos.eliminarVehiculo()){
            // alerta eliminado correctamente
            rellenarCampos(GestionVehiculos.actualRegistro());
        }
        else{
            // Alerta ha habido error
        }
        
    }
    
    /**
     * Método que se lanza al pulsar el botón añadir y que abre la interfaz que permite
     * agregar un nuevo registro.
     * @param event
     * @throws IOException 
     */
    @FXML
    void aniadirRegistro(ActionEvent event) throws IOException {
        App.setRoot("Aniadir");
    }
    
    @FXML
    void leerDatos(ActionEvent event) throws IOException {
        GestionVehiculos.leerDatos();
    }
    
    @FXML
    void guardarDatos(ActionEvent event) throws IOException {
        GestionVehiculos.guardarDatos();
    }
    
    /**
     * Método que rellena los distintos campos de la interfaz gráfica con la información
     * de un vehículo.
     * @param vehiculo objeto que contiene la información para mostrar en la interfaz.
     */
    private void rellenarCampos(Vehiculo vehiculo){
        if(vehiculo != null){
            tf_Matricula.setText(vehiculo.getMatricula());
            tf_Marca.setText(vehiculo.getMarca());
            tf_Modelo.setText(vehiculo.getModelo());

            if(vehiculo.getClass() == Oficial.class){
                tf_Cuerpo.setText(((Oficial)vehiculo).getCPertenece().toString());
                tf_NumPlazas.setText("" + ((Oficial)vehiculo).getNumeroPlazas());
                
                tf_Propietario.setText("-");
                tf_PlazaParking.setText("-");
            }
            else{
                tf_Cuerpo.setText("-");
                tf_NumPlazas.setText("-");
                
                tf_Propietario.setText(((Particular)vehiculo).getPropietario());
                tf_PlazaParking.setText("" + ((Particular)vehiculo).getNumeroPlazaAparcamiento());
            }
            
            tf_NumRegistro.setText("" + GestionVehiculos.getPosicion());
        }
    }
}
