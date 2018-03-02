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
public class Travel {
    
    private int initposx;
    private int initposy;
    private int endposx;
    private int endposy;
    private int num;
    private int startTime;
    private int endTime;

    public Travel() {
    }

    public void init(int numero){
        this.num = numero;
    }
    
    public int getInitposx() {
        return initposx;
    }

    public void setInitposx(int initposx) {
        this.initposx = initposx;
    }

    public int getInitposy() {
        return initposy;
    }

    public void setInitposy(int initposy) {
        this.initposy = initposy;
    }

    public int getEndposx() {
        return endposx;
    }

    public void setEndposx(int endposx) {
        this.endposx = endposx;
    }

    public int getEndposy() {
        return endposy;
    }

    public void setEndposy(int endposy) {
        this.endposy = endposy;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    
    public String toString(){
        return "Numero: "+this.getNum()+"\t"+
               "StartTime: "+this.getStartTime()+"\t"+
               "EndTime: "+this.getEndTime()+"\t"+
               "PosX: "+this.getInitposx()+"\t"+
               "PosY: "+this.getInitposy()+"\t"+
               "EndPosX: "+this.getEndposx()+"\t"+
               "EndPosY: "+this.getEndposy()+"\t";
    }

  
    
}
