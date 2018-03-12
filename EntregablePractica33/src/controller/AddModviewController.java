/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Person;

/**
 * FXML Controller class
 *
 * @author thepu
 */
public class AddModviewController implements Initializable {

    private ObservableList<String> imagenes;
    private Person person;

    @FXML
    private Label labelDNI;
    @FXML
    private TextField tfDNI;
    @FXML
    private Label labelFirstName;
    @FXML
    private TextField tfFirstName;
    @FXML
    private Label labelLastNAme;
    @FXML
    private TextField tfLastName;
    @FXML
    private Label labelCity;
    @FXML
    private TextField tfCity;
    @FXML
    private Label labelStreet;
    @FXML
    private TextField tfStreet;
    @FXML
    private ChoiceBox<String> cbImage;
    @FXML
    private Button btCancel;
    @FXML
    private Button btAccept;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
    }

    public void initStage(Stage stage, Person person, String accion) {
        imagenes=FXCollections.observableArrayList();
        imagenes.addAll("LLoroso", "Pregunta", "Sonriente");
        cbImage.setItems(imagenes);
        this.person = person;
        
        if (accion.equals("Añadir")) {
            
        }
        else{
            this.tfFirstName.setText(person.getNombre());
            this.tfLastName.setText(person.getApellidos());
            this.tfCity.setText(person.getDireccion().getCiudad().get());
            this.tfStreet.setText(person.getDireccion().getCalle().get());
            this.tfDNI.setText(person.getDNI());
            this.cbImage.getSelectionModel().select(person.getImagen());
        }
    }

    @FXML
    private void acceptPressed(ActionEvent event) {
        person.setDNI(tfDNI.getText());
        person.setNombre(tfFirstName.getText());
        person.setApellidos(tfLastName.getText());
        person.getDireccion().setCalle(tfStreet.getText());
        person.getDireccion().setCiudad(tfCity.getText());
        person.setImagen(cbImage.getSelectionModel().getSelectedItem());
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
    }

    @FXML
    private void cancelPressed(ActionEvent event) {
        Node n = (Node)event.getSource();
        n.getScene().getWindow().hide();
        
    }

}
