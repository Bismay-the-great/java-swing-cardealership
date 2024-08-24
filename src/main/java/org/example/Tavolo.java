package org.example;


import java.util.HashMap;


public class Tavolo {
    private int occupanti;
    private HashMap<String,Integer> ordine;

    public Tavolo(){
    }

    public int getOccupanti(){
        return this.occupanti;
    }
    public void setOccupanti(int occupanti){
        this.occupanti = occupanti;
    }
    public void setOrdine(String item, int quantity){
        this.ordine.put(item,quantity);
    }
    public HashMap<String, Integer> getOrdine() {
        return ordine;
    }
}
