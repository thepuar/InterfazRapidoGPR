/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author thepu
 */
public class Person {
    private StringProperty DNI = new SimpleStringProperty();
    private StringProperty nombre = new SimpleStringProperty();
    private StringProperty apellidos = new SimpleStringProperty();
    private StringProperty elNombre = new SimpleStringProperty();
    private ObjectProperty<Residence> direccion = new SimpleObjectProperty<Residence>();
    private StringProperty imagen = new SimpleStringProperty();


    public Person(){}
    
    public Person(String DNI,String nombre, String apellidos, Residence direccion, String imagen) {
        this.DNI.setValue(DNI);
        this.nombre.setValue(nombre);
        this.apellidos.setValue(apellidos);
        this.direccion = new SimpleObjectProperty<Residence>(direccion);
        this.imagen.setValue(imagen);
        this.elNombre.setValue(this.nombre.get()+" - "+this.apellidos.get());
    }

    public String getDNI() {
        return DNI.get();
    }

    public void setDNI(String DNI) {
        this.DNI.setValue(DNI);
    }
    
    public StringProperty DNIProperty(){return this.DNI;}
    
    
    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(StringProperty nombre) {
        this.nombre = nombre;
    }
    
    public StringProperty NombreProperty(){return this.nombre;}

    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(StringProperty apellidos) {
        this.apellidos = apellidos;
    }
    
    public StringProperty AppelidosProperty(){return this.apellidos;}

    public Residence getDireccion() {
        return direccion.get();
    }

    public void setDireccion(Residence direccion) {
        this.direccion.set(direccion);
    }
    public ObjectProperty DireccionProperty(){return this.direccion;}
   

    public String getImagen() {
        return imagen.get();
    }

    public void setImagen(String imagen) {
        this.imagen.setValue(imagen);
    }
    
    public StringProperty ImagenProperty(){return this.imagen;}

    public String getElNombre() {
        return elNombre.get();
    }

    
    
    
    
    
    
}
