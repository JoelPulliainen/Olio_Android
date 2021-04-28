package com.example.myht;

// Singleton class to make URLs for Ilmastodieetti API

public class WasteURLMaker {

    private static WasteURLMaker wasteURLMaker;
    private String bioWaste, carton, electronic, glass, hazardous, metal, paper, plastic, estimate;

    public static WasteURLMaker getInstance() {
        if (wasteURLMaker == null) {
            wasteURLMaker = new WasteURLMaker();
        }
        return wasteURLMaker;
    }

    // Create the URL

    public String URLquary() {
        String query = "";
        query += "query.bioWaste=" + String.valueOf(getBioWaste()) + "&";
        query += "query.carton=" + String.valueOf(getCarton()) + "&";
        query += "query.electronic=" + String.valueOf(getElectronic()) + "&";
        query += "query.glass=" + String.valueOf(getGlass()) + "&";
        query += "query.hazardous=" + String.valueOf(getHazardous()) + "&";
        query += "query.metal=" + String.valueOf(getMetal()) + "&";
        query += "query.paper=" + String.valueOf(getPaper()) + "&";
        query += "query.plastic=" + String.valueOf(getPlastic()) + "&";
        query += "query.amountEstimate=" + String.valueOf(getEstimate()) + "&";



        query = "https://ilmastodieetti.ymparisto.fi/ilmastodieetti/calculatorapi/v1/WasteCalculator?" + query;
        System.out.println(query);
        return query;
    }


    public String getBioWaste() {
        return bioWaste;
    }

    public void setBioWaste(String bioWaste) {
        this.bioWaste = bioWaste;
    }

    public String getCarton() {
        return carton;
    }

    public void setCarton(String carton) {
        this.carton = carton;
    }

    public String getElectronic() {
        return electronic;
    }

    public void setElectronic(String electronic) {
        this.electronic = electronic;
    }


    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getHazardous() {
        return hazardous;
    }

    public void setHazardous(String hazardous) {
        this.hazardous = hazardous;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public String getPlastic() {
        return plastic;
    }

    public void setPlastic(String plastic) {
        this.plastic = plastic;
    }

    public String getEstimate() {
        return estimate;
    }

    public void setEstimate(String estimate) {
        this.estimate = estimate;
    }
}
