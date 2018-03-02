/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import IO.Lector;
import java.util.List;
import model.Ciudad;
import model.Motor;
import model.Travel;

/**
 *
 * @author thepu
 */
public class HashCode2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ruta = "H:\\Documentos\\NetBeansProjects\\pract2IPC\\HashCode2018\\src\\IO\\";
        //String fichero = "b_should_be_easy.in";//"a_example.in";
        String fichero = "e_high_bonus.in";
        Lector lector = new Lector(ruta+fichero);
        
        List<Travel> lTravel = lector.geTravels();
        //Ya estan los datos en la lista de datos
        Motor motor = lector.getMotor();
        motor.setlTravel(lTravel);
        Ciudad ciudad = lector.getCity();
        motor.setCiudad(ciudad);
        System.out.println("Motor");
        System.out.println(motor.toString());
        System.out.println("Ciudad");
        System.out.println(ciudad.toString());
        System.out.println("Viajes");
        for(int i = 0; i<lTravel.size();i++)
            System.out.println(lTravel.get(i).toString());
        motor.step();
        
    }
    
}
