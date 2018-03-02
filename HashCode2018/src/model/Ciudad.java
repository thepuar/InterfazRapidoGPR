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
public class Ciudad {
    
    private int rows;
    private int columns;
    private int bonus;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String toString(){
        return "Bonus: "+this.getBonus()+"\t"+
               "Filas: "+this.getRows()+"\t"+
               "Columnas: "+this.getColumns();
    }
    
}
