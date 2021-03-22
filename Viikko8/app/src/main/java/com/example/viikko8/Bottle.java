package com.example.viikko8;

public class Bottle {



    private String name;
    private String manufacturer;
    private double total_energy;
    private double size;
    private double prize;
    public Bottle(String name, String manuf, float totE, float siz, float priz){}
    public Bottle(){}
    public void setName(String Name){
        name = Name;
    }
    public void setManufacturer(String Manu){
        manufacturer = Manu;
    }
    public void setEnergy(double Energy){
        total_energy = Energy;
    }
    public void setSize(double Size) {
        size = Size;
    }
    public void setPrize(double Prize) {
        prize = Prize;
    }

    public String getName(){return name;}
    public String getManufacturer(){return manufacturer;}
    public double getEnergy(){return total_energy;}
    public double getSize() {return size;}
    public double getPrize() {return prize;}

}