package com.company;

public class Main {

    public static void main(String[] args) {
	Taxi taxi = new Taxi("CF78DS9", "Ford Puma");
	taxi.unlock();
        System.out.println("------");
        System.out.println(taxi.toString());
        System.out.println("------");


        TaxiFleet yellow = new TaxiFleet("London", 10);

        yellow.addTaxi("CF158D96", "Ford Puma");

        yellow.addTaxi("DE458F78", "Ford Ka");

        yellow.addTaxi("DE654R89", "Peugeot 807");

        yellow.releaseATaxi("CF158D96");
        System.out.println(yellow.giveMeATaxi(2));
        System.out.println("------");

        System.out.println(yellow.isFreeATaxi());
        System.out.println("------");

        System.out.println(yellow.toString());
        System.out.println("------");

    }

}
