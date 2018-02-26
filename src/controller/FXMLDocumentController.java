/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.Person;

/**
 *
 * @author fjabad
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private ListView<Person> listView;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonRemove;
    @FXML
    private TextField firstNameText;
    @FXML
    private TextField lastNameText;

    private ObservableList<Person> data = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Person> backupList = new ArrayList<>();
        backupList.add(new Person("John", "Doe"));
        backupList.add(new Person("Jane", "Doe"));
        data = FXCollections.observableArrayList(backupList);
        listView.setItems(data);

        buttonRemove.disableProperty().bind(
                Bindings.equal(-1,
                        listView.getSelectionModel().selectedIndexProperty()));

        buttonAdd.disableProperty().bind(
                Bindings.or(firstNameText.textProperty().isEmpty(),
                        lastNameText.textProperty().isEmpty()));
    }

    @FXML
    private void onAddItem(ActionEvent event) {
        data.add(new Person(firstNameText.getText(), lastNameText.getText()));
        firstNameText.clear();
        lastNameText.clear();
        firstNameText.requestFocus();  // Changing focus to the textfield
    }

    @FXML
    private void onRemoveItem(ActionEvent event) {
        data.remove(listView.getSelectionModel().getSelectedIndex());
    }

    @FXML
    private void onLastNameEntered(ActionEvent event) {
        onAddItem(null);
    }

}
