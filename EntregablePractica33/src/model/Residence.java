/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author thepu
 */
public class Residence {
    private StringProperty ciudad = new SimpleStringProperty();
    private StringProperty calle = new SimpleStringProperty();

    public StringProperty getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad.set(ciudad);
    }
    public StringProperty getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle.set(calle);
    }
    

    public Residence(String ciudad, String calle) {
        this.ciudad.set(ciudad);
        this.calle.set(calle);
    }
    
    public StringProperty laDireccion(){
        StringProperty value =  new SimpleStringProperty();
        value.set(this.getCiudad().get()+" - "+this.getCalle().get());
        return value;
    }
    
    
    
}
