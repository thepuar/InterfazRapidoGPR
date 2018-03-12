/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Person;
import model.Residence;

/**
 *
 * @author thepu
 */
public class FXMLDocumentController implements Initializable {

    private Stage primaryStage;
    private ArrayList<Person> misdatos = new ArrayList<Person>();
    
    private Person persona;
    private ObservableList<Person> myData;
    @FXML
    private Button btAdd;
    @FXML
    private Button btMod;
    @FXML
    private TableView<Person> tvTabla;
    @FXML
    private TableColumn<Person, String> DNI;

    @FXML
    private TableColumn<Person, String> Picture;
    @FXML
    private TableColumn<Person, String> elNombre;
    @FXML
    private TableColumn<Person, Residence> Direccion;
    @FXML
    private Button btDel;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myData = FXCollections.observableList(misdatos);
       
        
        //Cargando con un par me de modelos para que no este vacia la lista.
        myData.add(new Person("123456", "John", "Doe", new Residence("Valencia", "C/False"), "Sonriente"));
        myData.add(new Person("654321", "Janet", "Doe", new Residence("Valencia", "C/Falso"), "LLoroso"));
        myData.add(new Person("456321", "Jason", "Doe", new Residence("Valencia", "C/LoL"), "Pregunta"));
        //Definiendo vistas en las columnas
        DNI.setCellValueFactory(p-> p.getValue().DNIProperty());
        elNombre.setCellValueFactory(p -> p.getValue().ElNombreProperty());
        Direccion.setCellValueFactory(p -> p.getValue().DireccionProperty());
        Direccion.setCellFactory(d -> {
            return new TableCell<Person, Residence>() {
                @Override
                protected void updateItem(Residence item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.laDireccion().get());
                    }
                }
            };
        });
        
        Picture.setCellValueFactory(p -> p.getValue().ImagenProperty());
        Picture.setCellFactory(c -> {
            return new TableCell<Person, String>() {
                private ImageView view = new ImageView();

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        //Item path y nombre del archivo
                        Image image = new Image("/resources/pictures/" + item + ".png", 40, 40, true, true);

                        view.setImage(image);
                        setGraphic(view);
                    }
                }
            };
        });

        //Añadiendo y cargando en tableview
        tvTabla.setItems(myData);
        tvTabla.getSelectionModel().selectedItemProperty().addListener((o,oldval,newval)->{
        persona = newval;});
        
        BooleanBinding personSelected = Bindings.isEmpty(tvTabla.getSelectionModel().getSelectedItems());
        this.btMod.disableProperty().bind(personSelected);
        this.btDel.disableProperty().bind(personSelected);
    }

    @FXML
    private void addModBtn(ActionEvent event) {
        Button boton = (Button) event.getSource();
        Person p = new Person();
        try {
            //Abrir ventana con una persona nueva.
            Stage stageActual = new Stage();
            FXMLLoader miCargador = new FXMLLoader(getClass().getResource("/view/AddModview.fxml"));
            Parent root = (Parent) miCargador.load();
            AddModviewController personWindow = miCargador.<AddModviewController>getController();

            Scene escena = new Scene(root);
            stageActual.setScene(escena);
            stageActual.initModality(Modality.APPLICATION_MODAL);
            stageActual.show();

            if (boton.getText().equals("Añadir")) {
                persona = new Person();
                personWindow.initStage(stageActual, persona, boton.getText());
                myData.add(persona);

            } else if (boton.getText().equals("Modificar")) {
                personWindow.initStage(stageActual, persona, boton.getText());
                //Cargar los datos del item seleccionado y modificar los datos del mismo.
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @FXML
    private void delBtn(ActionEvent event) {

        Person person = tvTabla.getSelectionModel().getSelectedItem();
        myData.remove(person);
    }
    

}
