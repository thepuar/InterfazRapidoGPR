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
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
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

    private ArrayList<Person> misdatos = new ArrayList<Person>();

    private Label label;
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

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myData = FXCollections.observableArrayList(misdatos);
        //Cargando con un par me de modelos para que no este vacia la lista.
        myData.add(new Person("123456", "John", "Doe", new Residence("Valencia", "C/False"), "Sonriente"));
        myData.add(new Person("654321", "Janet", "Doe", new Residence("Valencia", "C/Falso"), "LLoroso"));
        myData.add(new Person("456321", "Jason", "Doe", new Residence("Valencia", "C/LoL"), "Pregunta"));
        //Definiendo vistas en las columnas
        DNI.setCellValueFactory(new PropertyValueFactory<Person, String>("DNI"));
        elNombre.setCellValueFactory(new PropertyValueFactory<Person, String>("elNombre"));
        //Fuck my brain(Al final lo entendi)
        Direccion.setCellValueFactory(p -> p.getValue().DireccionProperty());
        Direccion.setCellFactory(r -> {
            return new TableCell<Person, Residence>() {
                @Override
                protected void updateItem(Residence item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.laDireccion());
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
                
                personWindow.initStage(stageActual, p, boton.getText());
                myData.add(p);

            } else if (boton.getText().equals("Modificar")) {
                personWindow.initStage(stageActual, this.tvTabla.getSelectionModel().getSelectedItem(), boton.getText());
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
