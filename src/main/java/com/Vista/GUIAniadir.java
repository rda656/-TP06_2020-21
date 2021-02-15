package com.Vista;

import com.Controlador.App;
import com.Controlador.GestionVehiculos;
import com.EstructuraDatos.Enumerados.cuerpo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * Clase que recoge todos los objetos y métodos necesarios que permiten modificar los datos de un vehículo.
 * @author Antonio Ramos
 */
public class GUIAniadir implements Initializable {

    @FXML
    private TextField tf_Matricula, tf_Marca, tf_NumPlazas,
            tf_Modelo, tf_Cuerpo, tf_PlazaParking, tf_Propietario, tf_NumRegistro;
    
    @FXML
    private ComboBox<cuerpo> cb_Cuerpo ;
    
    @FXML
    private ToggleGroup tipoVehiculo;

    /**
     * Método que se ejecuta una vez inicializada la interfaz gráfica.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb_Cuerpo.getItems().addAll(cuerpo.values());
        
        cb_Cuerpo.setDisable(false);
        tf_NumPlazas.setDisable(false);
        
        tf_Propietario.setDisable(true);
        tf_PlazaParking.setDisable(true);
    }
    
    /**
     * Activa los campos que corresponden a un vehículo oficial.
     * @param event 
     */
    @FXML
    void activarCamposOficial(ActionEvent event) {
        cb_Cuerpo.setDisable(false);
        tf_NumPlazas.setDisable(false);
        
        tf_Propietario.setDisable(true);
        tf_PlazaParking.setDisable(true);
    }

    /**
     * Activa los campos que corresponden a un vehículo particular.
     * @param event 
     */
    @FXML
    void activarCamposParticular(ActionEvent event) {
        cb_Cuerpo.setDisable(true);
        tf_NumPlazas.setDisable(true);
        
        tf_Propietario.setDisable(false);
        tf_PlazaParking.setDisable(false);
    }
    
    /**
     * Método que se lanza al pulsar el botón añadir y que envía los datos introducidos
     * en los campos de texto y en el combo box.
     * @param event
     * @throws IOException 
     */
    @FXML
    void guardar(ActionEvent event) throws IOException {
        
        App.setRoot("Principal");
    }
    
    /**
     * Método lanzado por el botón cancelar y que vuelve a la pantalla pirncipal.
     * @param event
     * @throws IOException 
     */
    @FXML
    void cancelar(ActionEvent event) throws IOException {
        App.setRoot("Principal");
    }
}
