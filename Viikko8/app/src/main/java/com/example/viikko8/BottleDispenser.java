package com.example.viikko8;

import java.util.ArrayList;

public class BottleDispenser {

    private double money;
    Bottle lastpurchase = new Bottle();
    ArrayList<Bottle> Bottles = new ArrayList<Bottle>();


    private static BottleDispenser bottleDispenser = null;


    private BottleDispenser() {

    }

    public static BottleDispenser getInstance() {
        if (bottleDispenser == null) {
            bottleDispenser = new BottleDispenser();

        }

        return bottleDispenser;
    }


    public void fillArrayList() {
        String[] Brands = {"Pepsi Max", "Pepsi Max", "Coca-Cola Zero", "Coca-Cola Zero", "Fanta Zero"};
        String[] Manufacturers = {"Pepsi", "Pepsi", "Coca-Cola", "Coca-Cola", "Coca-Cola"};
        double energy = 0.3;
        double[] sizes = {0.5, 1, 1.5, 0.5, 0.5};
        double[] prices = {1.8, 2.2, 2.0, 2.5, 1.95};

        for (int i = 0; i < 5; i++) {

            Bottle temp = new Bottle();
            temp.setName(Brands[i]);
            temp.setManufacturer(Manufacturers[i]);
            temp.setEnergy(energy);
            temp.setSize(sizes[i]);
            temp.setPrize(prices[i]);
            Bottles.add(temp);
        }
    }

    public void addMoney(int seekbarmoney) {
        money += seekbarmoney;
        System.out.println("Klink! Added more money!");
    }


    public void buyBottle1(int i) {


        Bottle temp2 = Bottles.get(i);
        System.out.println("KACHUNK! " + temp2.getName() + " came out of the dispenser!");
        lastpurchase = temp2;
        Bottles.remove(temp2);
        money -= temp2.getPrize();

    }

    public double getMoney() {
        return money;
    }

    public void returnMoney() {
        System.out.println("Money came out!" + money);
        money = 0;
    }


}
