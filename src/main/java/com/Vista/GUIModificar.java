package com.Vista;

import com.Controlador.App;
import com.Controlador.GestionVehiculos;
import com.EstructuraDatos.Oficial;
import com.EstructuraDatos.Particular;
import com.EstructuraDatos.Vehiculo;
import com.EstructuraDatos.Enumerados.cuerpo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * Clase que recoge todos los objetos y métodos necesarios que permiten modificar los datos de un vehículo.
 * @author Antonio Ramos
 */
public class GUIModificar implements Initializable {

    @FXML
    private TextField tf_Matricula, tf_Marca, tf_NumPlazas,
            tf_Modelo, tf_Cuerpo, tf_PlazaParking, tf_Propietario, tf_NumRegistro;
    
    @FXML
    private ComboBox<cuerpo> cb_Cuerpo ;
    
    private boolean esUnVehiculoOficial;

    /**
     * Método que se ejecuta una vez inicializada la interfaz gráfica.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Vehiculo v = GestionVehiculos.actualRegistro();

        if (v.getClass() == Oficial.class) {
            esUnVehiculoOficial = true;
            
            cb_Cuerpo.getItems().addAll(cuerpo.values());
            
            Oficial oficial = (Oficial) v;

            tf_Matricula.setText(oficial.getMatricula());
            tf_Marca.setText(oficial.getMarca());
            tf_Modelo.setText(oficial.getModelo());

            cb_Cuerpo.getSelectionModel().select(oficial.getCPertenece());
            tf_NumPlazas.setText("" + oficial.getNumeroPlazas());

            tf_Propietario.setDisable(true);
            tf_PlazaParking.setDisable(true);
        } 
        else {
            esUnVehiculoOficial = false;
            
            Particular particular = (Particular) v;
            
            tf_Matricula.setText(particular.getMatricula());
            tf_Marca.setText(particular.getMarca());
            tf_Modelo.setText(particular.getModelo());
            
            tf_Propietario.setText(particular.getPropietario());
            tf_PlazaParking.setText("" + particular.getNumeroPlazaAparcamiento());
            
            cb_Cuerpo.setDisable(true);
            tf_NumPlazas.setDisable(true);
        }
    }
    
    /**
     * Método que se lanza al pulsar el botón guardar y que envía los cambios introducidos
     * en los campos de texto y en el combo box.
     * @param event
     * @throws IOException 
     */
    @FXML
    void guardar(ActionEvent event) throws IOException {
        if(esUnVehiculoOficial){
            GestionVehiculos.modificarVehiculo(
                    tf_Matricula.getText(), 
                    tf_Marca.getText(), 
                    tf_Modelo.getText(),
                    cb_Cuerpo.getValue(),
                    Integer.parseInt(tf_NumPlazas.getText()));
        }
        else{
            GestionVehiculos.modificarVehiculo(
                    tf_Matricula.getText(), 
                    tf_Marca.getText(), 
                    tf_Modelo.getText(),
                    tf_Propietario.getText(),
                    Integer.parseInt(tf_PlazaParking.getText()));
        }
        
        App.setRoot("Principal");
    }
    
    /**
     * Método lanzado por el botón cancelar y que vuelve a la pantalla pirncipal sin realizar
     * ningún cambio.
     * @param event
     * @throws IOException 
     */
    @FXML
    void cancelar(ActionEvent event) throws IOException {
        App.setRoot("Principal");
    }
}
