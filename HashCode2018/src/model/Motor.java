/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author thepu
 */
public class Motor {

    private int steps;
    private int timer;
    private int numVehicle;
    private int numTravels;
    private List<Vehicle> lVehicle;
    private List<Vehicle> lVehicleMoving;
    private List<Vehicle> lVehicleEnd;
    private List<Travel> lTravel;
    private Ciudad ciudad;

    public Motor() {
    }

    public void init() {
        lVehicle = new ArrayList<>();
        lTravel = new ArrayList<>();
        for (int i = 0; i < this.getNumVehicle(); i++) {
            Vehicle coche = new Vehicle();
            coche.init(i);
            lVehicle.add(coche);
        }
        for (int i = 0; i < this.getNumTravels(); i++) {
            lTravel.add(new Travel());
        }
        lVehicleMoving = new ArrayList<>();
        lVehicleEnd = new ArrayList<>();
        timer = 0;

    }

    public Motor(int numVehicles, int numViajes) {
        lVehicle = new ArrayList<>();
        for (int i = 0; i < numVehicles; i++) {
            lVehicle.add(new Vehicle());
        }
        lTravel = new ArrayList<>();
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getNumVehicle() {
        return numVehicle;
    }

    public void setNumVehicle(int numVehicle) {
        this.numVehicle = numVehicle;
    }

    public int getNumTravels() {
        return numTravels;
    }

    public void setNumTravels(int numTravels) {
        this.numTravels = numTravels;
    }

    public List<Vehicle> getlVehicleMoving() {
        return lVehicleMoving;
    }

    public void setlVehicleMoving(List<Vehicle> lVehicleMoving) {
        this.lVehicleMoving = lVehicleMoving;
    }

    public List<Vehicle> getlVehicleEnd() {
        return lVehicleEnd;
    }

    public void setlVehicleEnd(List<Vehicle> lVehicleEnd) {
        this.lVehicleEnd = lVehicleEnd;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public List<Vehicle> getlVehicle() {
        return lVehicle;
    }

    public void setlVehicle(List<Vehicle> lVehicle) {
        this.lVehicle = lVehicle;
    }

    public List<Travel> getlTravel() {
        return lTravel;
    }

    public void setlTravel(List<Travel> lTravel) {
        this.lTravel = lTravel;
    }

    public String toString() {

        return "Viajes: " + this.getNumTravels() + "\t"
                + "Nº de v. en lista: " + this.getlTravel().size() + "\t"
                + "Nº coches: " + this.getNumVehicle() + "\t"
                + "Nº c. en lista:" + this.getlVehicle().size() + "\t"
                + "Nº de steps " + this.getSteps();
    }

    public void step() {
        while (this.timer <= this.steps) {
            try {
                Thread.sleep(0);
            } catch (Exception e) {
            }

            //Asignar viajes a coches de la lista
            Iterator<Vehicle> iterator = null;
            if (lTravel.size() > 0) {
                iterator = lVehicle.iterator();
                while (iterator.hasNext()) {
                    Vehicle auxVehiculo = iterator.next();

                    auxVehiculo.setViaje(this.lTravel.remove(0));
                    iterator.remove();
                    lVehicleMoving.add(auxVehiculo);

                }
            }
            //Mover los coches
            iterator = lVehicleMoving.iterator();
            int resultado = 0;
            while (iterator.hasNext()) {
                Vehicle auxVehiculo = iterator.next();
                if(auxVehiculo.getNumber()==0)
                System.out.println("Timer: "+timer+"\t"+auxVehiculo.toString());
                resultado = auxVehiculo.move(steps);
                if (resultado != 0) {
                    System.out.println("Fin Viaje - Coche: " + auxVehiculo.getNumber() + "\tResultado: " + resultado);
                    auxVehiculo.setBonus(this.ciudad.getBonus());
                    iterator.remove();
                    if (lTravel.size() > 0) {
                        System.out.println("Asignamos un nuevo viaje");
                        auxVehiculo.setViaje(lTravel.remove(0));
                    }
                    lVehicleEnd.add(auxVehiculo);
                }

            }

            timer++;
        }
        System.out.println("## - RESULTADO - ##");
        int total = 0;
        for(Vehicle vehiculo : this.lVehicleEnd){
            total += vehiculo.getBonus();
            System.out.println("Coche Nº:"+vehiculo.getNumber()+"\tBonus: "+vehiculo.getBonus());
        }
        System.out.println("Total: "+total);
    }

}
