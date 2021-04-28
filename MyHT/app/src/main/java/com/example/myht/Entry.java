package com.example.myht;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

// Entry class is an abstract class that creates a creation date for every new object

abstract class Entry implements Serializable{


    protected String dateCreated;


    public Entry() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date dateCreated1 = new Date();
        dateCreated = simpleDateFormat.format(dateCreated1);
    }

    public void setDateCreated() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date dateCreated1 = new Date();
        dateCreated = simpleDateFormat.format(dateCreated1);
    }

}

    // ConsumptionEntry Class stores Ilmastodieetti data from Consumption calculator, Has String getters for adapters and Total getter for graphview

    class ConsumptionEntry extends Entry {
        private float Clothing, Communications, Electronics, Other, Paper, Recreation, Shoes, Total;
            //private final String communications, electronics, Other, Paper, Recreation, Shoes, Total;

        //public ConsumptionEntry(float clothing, String communications, String electronics, String Other, String Paper, String Recreation, String Shoes, String Total) {
        public ConsumptionEntry(float clothing, float  communications, float electronics, float other, float paper, float recreation, float shoes, float total) {
            super();
            this.Clothing = clothing;
            this.Communications = communications;
            this.Electronics = electronics;
            this.Other = other;
            this.Paper = paper;
            this.Recreation = recreation;
            this.Shoes = shoes;
            this.Total = total;
        }

        public String getClothing() {
            return String.valueOf(Clothing);
        }

        public String getCommunications() {
            return String.valueOf(Communications);
        }

        public String getElectronics() {
            return String.valueOf(Electronics);
        }

        public String getOther() {
            return String.valueOf(Other);
        }
        public String getPaper() {
            return String.valueOf(Paper);
        }

        public String getRecreation() {
            return String.valueOf(Recreation);
        }
        public String getShoes() {
            return String.valueOf(Shoes);
        }
        public String getTotal() {
            return String.valueOf(Total);
        }

        public double getTotalData() {
            return Total;
        }


        @Override
        public String toString() {
            return "Date:" + dateCreated + "\nClothing: " + Clothing + "\nCommunications: " + Communications+ "\nElectronics: " + Electronics+ "\nOther: " +Other+ "\nPaper: " +Paper+ "\nRecreation: " +Recreation+ "\nShoes: " +Shoes + "\nTotal: " + Total +"\n";
        }
    }

    // FoodEntry Class stores Ilmastodieetti data from Food calculator, Has String getters for adapters and Total getter for graphview

    class FoodEntry extends Entry {
        private float Dairy, Meat, Plant, Restaurant, Total;

        public FoodEntry(float dairy, float  meat, float plant, float restaurant, float total) {
            super();
            this.Dairy = dairy;
            this.Meat = meat;
            this.Plant = plant;
            this.Restaurant = restaurant;
            this.Total = total;
        }

        public String getDairy() {
            return String.valueOf(Dairy);
        }

        public String getMeat() {
            return String.valueOf(Meat);
        }

        public String getPlant() {
            return String.valueOf(Plant);
        }

        public String getRestaurant() {
            return String.valueOf(Restaurant);
        }

        public String getTotal() {
            return String.valueOf(Total);
        }

        public double getTotalData() {
            return Total;
        }


        @Override
        public String toString() {
            return "Date:" + dateCreated + "\nDairy: " + Dairy +  "\nMeat: " + Meat + "\nPlant: " + Plant + "\nRestaurant: " + Restaurant + "\nTotal: " + Total;
        }
    }

    // HousingEntry Class stores Ilmastodieetti data from Housing calculator, Has String getters for adapters and Total getter for graphview

    class HousingEntry extends Entry {
        private float Electricity, Heating, Infrastructure, Purchases, Total;

        public HousingEntry(float electricity, float heating, float infrastructure, float purchases, float total) {
            super();
            this.Electricity = electricity;
            this.Heating = heating;
            this.Infrastructure = infrastructure;
            this.Purchases = purchases;
            this.Total = total;
        }

        public String getElectricity() {
            return String.valueOf(Electricity);
        }

        public String getHeating() {
            return String.valueOf(Heating);
        }

        public String getInfrastructure() {
            return String.valueOf(Infrastructure);
        }

        public String getPurchases() {
            return String.valueOf(Purchases);
        }

        public String getTotal() {
            return String.valueOf(Total);
        }

        public double getTotalData() {
            return Total;
        }

        @Override
        public String toString() {
            return "Date: " + dateCreated + "\nElectricity: "+ Electricity + "\nHeating: " + Heating + "\nInfrastructure: "+ Infrastructure + "\nPurchases: " + Purchases + "\nTotal: " + Total;
        }
    }

    // TransportEntry Class stores Ilmastodieetti data from Transport calculator, Has String getters for adapters and Total getter for graphview

    class TransportEntry extends Entry {
        private float Boat, Motorcycle, Flight, Cruise, Train, Bus, Other, Ttal,  Total;
        //PublicTransport, Train, Bus, Other,  Total;
        // float publicTransport, float train, float bus, float other,
        public TransportEntry(float boat, float  motorcycle, float flight, float cruise, float train, float bus, float other, float ttal,float total) {
            super();
            this.Boat = boat;
            this.Motorcycle = motorcycle;
            this.Flight = flight;
            this.Cruise = cruise;
            this.Train = train;
            this.Bus = bus;
            this.Other = other;
            this.Ttal = ttal;
            this.Total = total;
        }

        public String getBoat() {
            return String.valueOf(Boat);
        }

        public String getMotorcycle() {
            return String.valueOf(Motorcycle);
        }

        public String getBus() {
            return String.valueOf(Bus);
        }

        public String getFlight() {
            return String.valueOf(Flight);
        }

        public String getCruise() {
            return String.valueOf(Cruise);
        }

        public String getTrain() {
            return String.valueOf(Train);
        }

        public String getOther() {
            return String.valueOf(Other);
        }

        public String getTtal() {
            return String.valueOf(Ttal);
        }

        public String getTotal() {
            return String.valueOf(Total);
        }

        public double getTotalData() {
            return Total;
        }

        @Override
        public String toString() {
            return "Date: "+ dateCreated +"\nBoat: " + Boat + "\nMotorcycle: " + Motorcycle + "\nFlight: " + Flight + "\nCruise: " + Cruise + "\nTrain: " + Train + "\nBus: "+ Bus + "\nOther: " + Other + "\nPublic transport total: " + Ttal + "\nTotal: "  + Total;
        }
    }

    // WasteEntry Class stores Ilmastodieetti data from Waste calculator, Has String getters for adapters and Total getter for graphview

    class WasteEntry extends Entry {
        private float Total;


        public WasteEntry(float total) {
            super();
            this.Total = total;
        }

        public String getTotal() {
            return String.valueOf(Total);
        }

        public double getTotalData() {
            return Total;
        }

        @Override
        public String toString() {
            return "Date: " + dateCreated + "\nTotal: " +  Total;

        }
    }

    // WeightEntry Class stores user's weight data, Has String getters for adapters and Total getter for graphview

    class WeightEntry extends Entry {

        private float Weight;

        public WeightEntry(float weight) {
            super();
            this.Weight = weight;
        }

        public String  getWeight() {
            return String.valueOf(Weight);
        }


        public double getWeightData() {
            return Weight;
        }


        @Override
        public String toString() {
            return "Date: " + dateCreated + "\nWeight: " + Weight;
        }
    }