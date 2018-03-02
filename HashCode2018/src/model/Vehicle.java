/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author thepu
 */
public class Vehicle {

    private int posx;
    private int posy;
    private int number;
    private Travel viaje;
    private boolean arriveInit;
    private int bonus = 0;
    private boolean sumaraBonus = false;

    public Vehicle() {
        //Inicializando vehiculo
        int posx = 0;
        int posy = 0;
        int number = 0;
        arriveInit = false;
        bonus = 0;
    }

    public void init(int numero) {
        this.number = numero;
        this.posx = 0;
        this.posy = 0;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Travel getViaje() {
        return viaje;
    }

    public void setViaje(Travel viaje) {
        this.viaje = viaje;
        if (viaje.getInitposx() == this.posx && viaje.getInitposy() == this.posy) {
            this.arriveInit = true;
        }
    }

    public boolean isArriveInit() {
        return arriveInit;
    }

    public void setArriveInit(boolean arriveInit) {
        this.arriveInit = arriveInit;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public boolean isSumaraBonus() {
        return sumaraBonus;
    }

    public void setSumaraBonus(boolean sumaraBonus) {
        this.sumaraBonus = sumaraBonus;
    }

    //0 no ha terminado
    //1 ha terminado pero no tiene bonus
    //2 ha terminado y tiene bonus
    public int move(int step) {
        //Mover a posicion inicial
        boolean movido = false;
        int resultado = 0;
        if (!arriveInit) {
            //Mover a la izquierda
            if (this.getPosx() > this.getViaje().getInitposx()) {
                movido = true;
                this.setPosx(this.getPosx() - 1);
            }
            //Mover a la derecha
            if (!movido && this.getPosx() < this.getViaje().getInitposx()) {
                movido = true;
                this.setPosx(this.getPosx() + 1);
            }
            //Mover hacia abajo
            if (!movido && this.getPosy() < this.getViaje().getInitposy()) {
                movido = true;
                this.setPosy(this.getPosy() + 1);
            }
            //Mover hacia arriba
            if (!movido && this.getPosy() > this.getViaje().getInitposy()) {
                movido = true;
                this.setPosy(this.getPosy() - 1);
            }
            //Esta en la posicion inicial
            if (this.getPosx() == this.getViaje().getInitposx() && this.getPosy() == this.getViaje().getInitposy()) {
                arriveInit = true;
                if (step <= this.getViaje().getStartTime()) {
                    this.sumaraBonus = true;
                }
            }
        } else {
            //Mover a posicion final
            //Mover a la izquierda
            if (this.getPosx() > this.getViaje().getEndposx()) {
                movido = true;
                this.setPosx(this.getPosx() - 1);
            }
            //Mover a la derecha
            if (!movido && this.getPosx() < this.getViaje().getEndposx()) {
                movido = true;
                this.setPosx(this.getPosx() + 1);
            }
            //Mover hacia arriba
            if (!movido && this.getPosy() < this.getViaje().getEndposy()) {
                movido = true;
                this.setPosy(this.getPosy() + 1);
            }
            //Mover hacia abajo
            if (!movido && this.getPosy() > this.getViaje().getEndposy()) {
                movido = true;
                this.setPosy(this.getPosy() - 1);
            }
            //Esta en el final
            if (this.getPosx() == this.getViaje().getEndposx() && this.getPosy() == this.getViaje().getEndposy()) {
                resultado = 1;
                if (this.getViaje().getEndTime() <= step) {
                    resultado = 2;
                }

            }
        }
        return resultado;
    }

    public void addBonus(int bonus) {
        this.bonus += bonus;
    }

    public String toStringDistancia() {
        int faltaX = 0;
        int faltaY = 0;
        if (this.posx > this.getViaje().getEndposx()) {
            faltaX = this.posx - this.getViaje().getEndposx();
        } else {
            faltaX = (this.posx - this.getViaje().getEndposx()) * -1;
        }
        if (this.posy > this.getViaje().getEndposy()) {
            faltaY = this.posy - this.getViaje().getEndposy();
        } else {
            faltaY = (this.posy - this.getViaje().getEndposy()) * -1;
        }

        return "\tX Init/Act/End: " + this.getViaje().getInitposx() + "/" + this.getPosx() + "/" + this.getViaje().getEndposx() + "\tFaltaX: " + faltaX
                + "\tY Init/Act/End: " + this.getViaje().getInitposy() + "/" + this.getPosy() + "/" + this.getViaje().getEndposy() + "\tFaltaY: " + faltaY + "\tFalta Total: " + (faltaX + faltaY);
    }

    public String toString() {
        return "Coche Nº: " + this.getNumber() + "\t"
                + this.toStringDistancia() + "\tBonus: " + this.getBonus();
    }

}
