package com.company;

public class Taxi {
    private String name;
    private String model;
    private boolean free;
    private int places;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getModel() {
      return model;
    }
    public void setModel(String model) {
        this.model = model;
   }
    public void setFree(boolean free) {
       free = free;
   }
    public int getPlaces() {
        return places;
    }
    private void setPlaces(int places) {
        this.places = places;
        if(places < 2){
            places = 2;
        }
    }

    public Taxi(String name, String model){
        setName(name);
        setModel(model);
        if(getModel().equals("Ford Ka")){
            setPlaces(4);
        }else if(getModel().equals("Ford Puma")){
            setPlaces(6);
        }else if(getModel().equals("Peugeot 807")){
            setPlaces(7);
        }
    }
    public boolean lock(){
        return free = false;
    }
    public boolean unlock(){
        return free = true;
    }
    public boolean isFree(){
        if(!free){
            return false;
        }else{
            return true;
        }
    }
    public String toString(){
        String ret = "";
        ret = ret +  name+ "-" +model+ "-" +places+ "-" + (isFree()? "free":"occupied");
        return  ret;
    }
}