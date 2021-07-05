package com.company;

import jdk.swing.interop.SwingInterOpUtils;

public class TaxiFleet {
    private int maxTaxi;
    private String district;
    private Taxi[] fleet;
    private int lastTaxi ;


    public int getMaxTaxi() {
        return maxTaxi;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public Taxi[] getFleet() {
        return fleet;
    }
    public int getLastTaxi() {
        return lastTaxi;
    }
    public void setLastTaxi(int lastTaxi) {
        this.lastTaxi = lastTaxi;
    }



//constructor
    public TaxiFleet(String district, int maxTaxi) {
        this.district = district;
        this.maxTaxi = maxTaxi;
        lastTaxi =0;
        fleet = new Taxi[maxTaxi];

    }

//adder
    public int addTaxi(String name, String model) {
        if (lastTaxi < fleet.length && lastTaxi > -1) {
            fleet[lastTaxi] = new Taxi(name, model);
            lastTaxi ++;
            System.out.println(lastTaxi-1);
            return lastTaxi;
        } else {
            System.out.println(-1);
            return -1;
        }
    }

//getter
    public String giveMeATaxi(int people){
        for (int i = 0; i < lastTaxi; i++) {
            if(fleet[i] != null) {
                if (fleet[i].getPlaces() >= people) {
                    fleet[i].lock();
                    return  fleet[i].getName();
                }
            }
        }
        return "taxi not available";

    }

//remover
    public void releaseATaxi(String name) {
        for (int i = 0; i < lastTaxi; i++) {
            if (fleet[i] != null) {
                if (name.equals(fleet[i].getName())) {
                    fleet[i].unlock();
                    System.out.println("your taxi has been blocked");
                }
            }
        }
    }

    public boolean isFreeATaxi(){
        for (int i = 0; i < lastTaxi; i++) {
            if(fleet[i].unlock()){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String ret = district+  "\n";
        for (int i = 0; i < lastTaxi; i++) {
            ret += fleet[i].getName() + " " + (fleet[i].isFree()?"free":"occupied")+ "\n";
        }
        return ret;
    }


    }


