/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author thepu
 */
public class AddModviewController implements Initializable {

    @FXML
    private TextField tfDNI;
    @FXML
    private TextField tfFirstName;
    @FXML
    private Label tfLastName;
    @FXML
    private Label tfCity;
    @FXML
    private Label tfStreet;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
