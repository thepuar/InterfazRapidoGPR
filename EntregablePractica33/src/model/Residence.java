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
    private StringProperty laDireccion = new SimpleStringProperty();

    public String getCiudad() {
        return ciudad.get();
    }

    public void setCiudad(String ciudad) {
        this.ciudad.setValue(ciudad);
    }
       public StringProperty CiudadProperty(){return this.ciudad;}

    public String getCalle() {
        return calle.get();
    }

    public void setCalle(String calle) {
        this.calle.setValue(calle);
    }
    
    public StringProperty CalleProperty(){return this.calle;}

    public Residence(String ciudad, String calle) {
        this.ciudad.set(ciudad);
        this.calle.set(calle);
        this.laDireccion.set(this.getCiudad()+" - "+this.getCalle());
    }
    
    public String laDireccion(){
        return this.getCiudad()+" - "+this.getCalle();
    }
    
    
    
}
