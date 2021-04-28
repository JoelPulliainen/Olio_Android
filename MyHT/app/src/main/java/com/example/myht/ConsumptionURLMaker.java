package com.example.myht;


// Singleton class to make URLs for Ilmastodieetti API

public class ConsumptionURLMaker {

    private static ConsumptionURLMaker consumptionURLMaker;
    private int clothes, communications, electronics, other, paper, recreation, shoes;
    private Boolean low_carbon_clothes, low_carbon_communications, low_carbon_electronics, low_carbon_other, low_carbon_paper, low_carbon_recreation, low_carbon_shoes;

    public static ConsumptionURLMaker getInstance() {
        if (consumptionURLMaker == null) {
            consumptionURLMaker = new ConsumptionURLMaker();
        }
        return consumptionURLMaker;
    }

    //Create the URL

    public String URLquary() {
            String query = "";
            if (getClothes() >= 0) {
                query += ("query.clothing=" + String.valueOf(getClothes()) + "&");
            }
            if (getLow_carbon_clothes() != null) {
                query += "query.clothingLowCarbon=" + String.valueOf(getLow_carbon_clothes()) + "&";
            }
            if (getCommunications() >= 0) {
                query += "query.communications=" + String.valueOf(getCommunications()) + "&";
            }
            if (getLow_carbon_communications() != null) {
                query += "query.clothingLowCarbon=" + String.valueOf(getLow_carbon_communications()) + "&";
            }
            if (getElectronics() >= 0) {
                query += "query.electronics=" + String.valueOf(getElectronics()) + "&";
            }
            if (getLow_carbon_electronics() != null) {
                query += "query.electronicsLowCarbon=" + String.valueOf(getLow_carbon_electronics()) + "&";
            }
            if (getOther() >= 0) {
                query += "query.other=" + String.valueOf(getOther()) + "&";
            }
            if (getLow_carbon_other() != null) {
                query += "query.otherLowCarbon=" + String.valueOf(getLow_carbon_other()) + "&";

            } if (getPaper() >= 0) {
                query += "query.paper=" + String.valueOf(getPaper()) + "&";
            }
            if (getLow_carbon_clothes() != null) {
                query += "query.paperLowCarbon=" + String.valueOf(getLow_carbon_paper()) + "&";
            }
            if (getRecreation() >= 0) {
                query += "query.recreation=" + String.valueOf(getRecreation()) + "&";
            }
            if (getLow_carbon_recreation() != null) {
                query += "query.recreationLowCarbon=" + String.valueOf(getLow_carbon_recreation()) + "&";
            }
            if (getShoes() >= 0) {
                query += "query.shoes=" + String.valueOf(getShoes()) + "&";
            }
            if (getLow_carbon_shoes() != null) {
                query += "query.shoesLowCarbon=" + String.valueOf(getLow_carbon_shoes());
            }
            query = "https://ilmastodieetti.ymparisto.fi/ilmastodieetti/calculatorapi/v1/ConsumptionCalculator?" + query + "&";
            System.out.println(query);
            return query;
        }


    public int getClothes() {
        return clothes;
    }

    public void setClothes(String Iclothes) {
        if (Iclothes.equals("")) {
            this.clothes = 0;
        } else {
            this.clothes = Integer.parseInt(Iclothes);
        }
    }

    public int getCommunications() {
        return communications;
    }

    public void setCommunications(String Icommunications) {
        if (Icommunications.equals("")) {
            this.communications = 0;
        } else {
            this.communications = Integer.parseInt(Icommunications);
        }
    }

    public int getElectronics() {
        return electronics;
    }

    public void setElectronics(String Ielectronics) {
        if (Ielectronics.equals("")) {
            this.electronics = 0;
        } else {
            this.electronics = Integer.parseInt(Ielectronics);
        }
    }

    public int getOther() {
        return other;
    }

    public void setOther(String Iother) {
        if (Iother.equals("")) {
            this.other = 0;
        } else {
            this.other = Integer.parseInt(Iother);
        }
    }

    public int getPaper() {
        return paper;
    }

    public void setPaper(String Ipaper) {
        if (Ipaper.equals("")) {
            this.paper = 0;
        } else {
            this.paper = Integer.parseInt(Ipaper);
        }
    }

    public int getRecreation() {
        return recreation;
    }

    public void setRecreation(String Irecreation) {
        if (Irecreation.equals("")) {
            this.recreation = 0;
        } else {
            this.recreation = Integer.parseInt(Irecreation);
        }
    }

    public int getShoes() {
        return shoes;
    }

    public void setShoes(String Ishoes) {
        if (Ishoes.equals("")) {
            this.shoes = 0;
        } else {
            this.shoes = Integer.parseInt(Ishoes);
        }
    }

    public Boolean getLow_carbon_clothes() {
        return low_carbon_clothes;
    }

    public void setLow_carbon_clothes(Boolean low_carbon_clothes) {
        this.low_carbon_clothes = low_carbon_clothes;
    }

    public Boolean getLow_carbon_communications() {
        return low_carbon_communications;
    }

    public void setLow_carbon_communications(Boolean low_carbon_communications) {
        this.low_carbon_communications = low_carbon_communications;
    }

    public Boolean getLow_carbon_electronics() {
        return low_carbon_electronics;
    }

    public void setLow_carbon_electronics(Boolean low_carbon_electronics) {
        this.low_carbon_electronics = low_carbon_electronics;
    }

    public Boolean getLow_carbon_other() {
        return low_carbon_other;
    }

    public void setLow_carbon_other(Boolean low_carbon_other) {
        this.low_carbon_other = low_carbon_other;
    }

    public Boolean getLow_carbon_paper() {
        return low_carbon_paper;
    }

    public void setLow_carbon_paper(Boolean low_carbon_paper) {
        this.low_carbon_paper = low_carbon_paper;
    }

    public Boolean getLow_carbon_recreation() {
        return low_carbon_recreation;
    }

    public void setLow_carbon_recreation(Boolean low_carbon_recreation) {
        this.low_carbon_recreation = low_carbon_recreation;
    }

    public Boolean getLow_carbon_shoes() {
        return low_carbon_shoes;
    }

    public void setLow_carbon_shoes(Boolean low_carbon_shoes) {
        this.low_carbon_shoes = low_carbon_shoes;
    }
}