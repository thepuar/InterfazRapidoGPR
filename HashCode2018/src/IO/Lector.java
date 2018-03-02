/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import model.Ciudad;
import model.Motor;
import model.Travel;

/**
 *
 * @author thepu
 */
public class Lector {

    BufferedReader bf;
    List<Travel> lista;
    Ciudad city;
    Motor motor;
    Travel auxTravel;

    public Lector(String ruta) {
        lista = new ArrayList<>();
        motor = new Motor();

        try {
            bf = new BufferedReader(new FileReader(ruta));
            String cadena = "";
            String aux;
            StringTokenizer st;
            cadena = bf.readLine();
            st = new StringTokenizer(cadena);
            city = new Ciudad();

            city.setRows(Integer.parseInt(st.nextToken()));//Row
            city.setColumns(Integer.parseInt(st.nextToken()));//Column
            motor.setNumVehicle(Integer.parseInt(st.nextToken()));//Number of vehicles
            motor.setNumTravels(Integer.parseInt(st.nextToken()));//Number of rides
            motor.init();
            city.setBonus(Integer.parseInt(st.nextToken()));//Bonus per ride
            motor.setSteps(Integer.parseInt(st.nextToken()));//Num Steps
            int i = 1;
            while ((cadena = bf.readLine()) != null) {
                st = new StringTokenizer(cadena);
                auxTravel = new Travel();

                auxTravel.setInitposx(Integer.parseInt(st.nextToken()));//Init pos X
                auxTravel.setInitposy(Integer.parseInt(st.nextToken()));//Init pox y
                auxTravel.setEndposx(Integer.parseInt(st.nextToken()));//End pos x
                auxTravel.setEndposy(Integer.parseInt(st.nextToken()));//End pos y
                auxTravel.setStartTime(Integer.parseInt(st.nextToken()));//Earliest start
                auxTravel.setEndTime(Integer.parseInt(st.nextToken()));//Latest finish
                auxTravel.setNum(i);
                i++;

                lista.add(auxTravel);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        };
    }

    public BufferedReader getBf() {
        return bf;
    }

    public void setBf(BufferedReader bf) {
        this.bf = bf;
    }

    public Ciudad getCity() {
        return city;
    }

    public void setCity(Ciudad city) {
        this.city = city;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public List<Travel> geTravels() {
        return this.lista;
    }

}
