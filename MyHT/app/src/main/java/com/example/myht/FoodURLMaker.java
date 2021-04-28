package com.example.myht;

// Singleton class to make URLs for Ilmastodieetti API

public class FoodURLMaker {
    private static FoodURLMaker foodURLMaker;
    private String diet;
    private int beef, fish, pp, dairy, cheese, rice, egg, ws, restaurant;
    private Boolean low_carbon_diet;

    public static FoodURLMaker getInstance() {
        if (foodURLMaker == null) {
            foodURLMaker = new FoodURLMaker();
        }
        return foodURLMaker;
    }

    //Create the URL

    public String URLquary() {
        String query = "";
        query += "query.diet=" + String.valueOf(getDiet()) + "&";
        if (getLow_carbon_diet() != null) {
            query += "query.lowCarbonPreference=" + String.valueOf(getLow_carbon_diet()) + "&";
        }
        if (getBeef() >= 0) {
            query += ("query.beefLevel=" + String.valueOf(getBeef()) + "&");
        }
        if (getFish() >= 0) {
            query += "query.fishLevel=" + String.valueOf(getFish()) + "&";
        }
        if (getPp() >= 0) {
            query += "query.porkPoultryLevel=" + String.valueOf(getPp()) + "&";
        }
        if (getDairy() >= 0) {
            query += "query.dairyLevelr=" + String.valueOf(getDairy()) + "&";
        }
        if (getCheese() >= 0) {
            query += "query.cheeseLevel=" + String.valueOf(getCheese()) + "&";
        }
        if (getRice() >= 0) {
            query += "query.riceLevel=" + String.valueOf(getRice()) + "&";
        }
        if (getEgg() >= 0) {
            query += "query.eggLevel=" + String.valueOf(getEgg()) + "&";
        }
        if (getWs() >= 0) {
            query += "query.winterSaladLevel=" + String.valueOf(getWs()) + "&";
        }
        if (getRestaurant() >= 0) {
            query += "query.restaurantSpending=" + String.valueOf(getRestaurant()) + "&";
        }

        query = "https://ilmastodieetti.ymparisto.fi/ilmastodieetti/calculatorapi/v1/FoodCalculator?" + query + "&";
        System.out.println(query);
        return query;
    }


    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public int getBeef() {
        return beef;
    }

    public void setBeef(String Ibeef) {
        if (Ibeef.equals("")) {
            this.beef = 0;
        } else {
            this.beef = Integer.parseInt(Ibeef);
        }
    }

    public int getFish() {
        return fish;
    }

    public void setFish(String Ifish) {
        if (Ifish.equals("")) {
            this.fish = 0;
        } else {
            this.fish = Integer.parseInt(Ifish);
        }
    }

    public int getPp() {
        return pp;
    }

    public void setPp(String Ipp) {
        if (Ipp.equals("")) {
            this.pp = 0;
        } else {
            this.pp = Integer.parseInt(Ipp);
        }
    }

    public int getDairy() {
        return dairy;
    }

    public void setDairy(String Idairy) {
        if (Idairy.equals("")) {
            this.dairy = 0;
        } else {
            this.dairy = Integer.parseInt(Idairy);
        }
    }

    public int getCheese() {
        return cheese;
    }

    public void setCheese(String Icheese) {
        if (Icheese.equals("")) {
            this.cheese = 0;
        } else {
            this.cheese = Integer.parseInt(Icheese);
        }
    }

    public int getRice() {
        return rice;
    }

    public void setRice(String Irice) {
        if (Irice.equals("")) {
            this.rice = 0;
        } else {
            this.rice = Integer.parseInt(Irice);
        }
    }

    public int getEgg() {
        return egg;
    }

    public void setEgg(String Iegg) {
        if (Iegg.equals("")) {
            this.egg = 0;
        } else {
            this.egg = Integer.parseInt(Iegg);
        }
    }

    public int getWs() {
        return ws;
    }

    public void setWs(String Iws) {
        if (Iws.equals("")) {
            this.ws = 0;
        } else {
            this.ws = Integer.parseInt(Iws);
        }
    }

    public int getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String Irestaurant) {
        if (Irestaurant.equals("")) {
            this.restaurant = 0;
        } else {
            this.restaurant = Integer.parseInt(Irestaurant);
        }
    }

    public Boolean getLow_carbon_diet() {
        return low_carbon_diet;
    }

    public void setLow_carbon_diet(Boolean low_carbon_diet) {
        this.low_carbon_diet = low_carbon_diet;
    }
}
