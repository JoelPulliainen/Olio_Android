package com.example.myht;


// Singleton class to make URLs for Ilmastodieetti API

public class HousingURLMaker {

    private static HousingURLMaker housingURLMaker;
    private String houseType, heatingMode, winterHeating;
    private int familysize, buildyear, area, floorcount, eConsumption, gEp, aPurchase, fPurchases,cPurchases, rPurchases, mPurchases;
    private Boolean isprimaryhouse, additionalHeatPump, additionalHeatSelfGen, additionalHeatWood;

    public static HousingURLMaker getInstance() {
        if (housingURLMaker == null) {
            housingURLMaker = new HousingURLMaker();
        }
        return housingURLMaker;
    }

    // Create the URL

    public String URLquary() {
        String query = "";
        query += "query.familySize=" + String.valueOf(getFamilysize()) + "&";
        query += "query.isPrimaryHouse=" + String.valueOf(getIsprimaryhouse()) + "&";
        query += "query.houseType=" + String.valueOf(getHouseType()) + "&";
        query += "query.buildYear=" + String.valueOf(getBuildyear()) + "&";
        query += "query.floorCount=" + String.valueOf(getFloorcount()) + "&";
        query += "query.electricityConsumption=" + String.valueOf(geteConsumption()) + "&";
        query += "query.greenElectricityPercentage=" + String.valueOf(getgEp()) + "&";
        query += "query.heatingMode=" + String.valueOf(getHeatingMode()) + "&";
        query += "query.winterHeating=" + String.valueOf(getWinterHeating()) + "&";
        query += "query.additionalHeatPump=" + String.valueOf(getAdditionalHeatPump()) + "&";
        query += "query.additionalHeatSelfGenerated=" + String.valueOf(getAdditionalHeatSelfGen()) + "&";
        query += "query.additionalHeatWood=" + String.valueOf(getAdditionalHeatWood()) + "&";
        query += "query.appliancePurchases=" + String.valueOf(getaPurchase()) + "&";
        query += "query.cleaningPurchases=" + String.valueOf(getcPurchases()) + "&";
        query += "query.furniturePurchases=" + String.valueOf(getfPurchases()) + "&";
        query += "query.renovationPurchases=" + String.valueOf(getrPurchases()) + "&";
        query += "query.miscPurchases=" + String.valueOf(getmPurchases()) + "&";


        query = "https://ilmastodieetti.ymparisto.fi/ilmastodieetti/calculatorapi/v1/HousingCalculator?" + query;
        System.out.println(query);
        return query;
    }


    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHeatingMode() {
        return heatingMode;
    }

    public void setHeatingMode(String heatingMode) {
        this.heatingMode = heatingMode;
    }

    public String getWinterHeating() {
        return winterHeating;
    }

    public void setWinterHeating(String winterHeating) {
        this.winterHeating = winterHeating;
    }

    public int getFamilysize() {
        return familysize;
    }

    public void setFamilysize(String Ifamilysize) {
        if (Ifamilysize.equals("")) {
            this.familysize = 0;
        } else {
            this.familysize = Integer.parseInt(Ifamilysize);
        }
    }
    public int getBuildyear() {
        return buildyear;
    }

    public void setBuildyear(String Ibuildyear) {
        if (Ibuildyear.equals("")) {
            this.buildyear = 0;
        } else {
            this.buildyear = Integer.parseInt(Ibuildyear);
        }
    }

    public int getArea() {
        return area;
    }

    public void setArea(String Iarea) {
        if (Iarea.equals("")) {
            this.area = 0;
        } else {
            this.area = Integer.parseInt(Iarea);
        }
    }

    public int getFloorcount() {
        return floorcount;
    }

    public void setFloorcount(String Ifloorcount) {
        if (Ifloorcount.equals("")) {
            this.floorcount = 0;
        } else {
            this.floorcount = Integer.parseInt(Ifloorcount);
        }
    }

    public int geteConsumption() {
        return eConsumption;
    }

    public void seteConsumption(String IeConsumption) {
        if (IeConsumption.equals("")) {
            this.eConsumption = 0;
        } else {
            this.eConsumption = Integer.parseInt(IeConsumption);
        }
    }

    public int getgEp() {
        return gEp;
    }

    public void setgEp(String IgEp) {
        if (IgEp.equals("")) {
            this.gEp = 0;
        } else {
            this.gEp = Integer.parseInt(IgEp);
        }
    }

    public int getaPurchase() {
        return aPurchase;
    }

    public void setaPurchase(String IaPurchase) {
        if (IaPurchase.equals("")) {
            this.aPurchase = 0;
        } else {
            this.aPurchase = Integer.parseInt(IaPurchase);
        }
    }

    public int getfPurchases() {
        return fPurchases;
    }

    public void setfPurchases(String IfPurchases) {
        if (IfPurchases.equals("")) {
            this.fPurchases = 0;
        } else {
            this.fPurchases = Integer.parseInt(IfPurchases);
        }
    }

    public int getrPurchases() {
        return rPurchases;
    }

    public void setrPurchases(String IrPurchases) {
        if (IrPurchases.equals("")) {
            this.rPurchases = 0;
        } else {
            this.rPurchases = Integer.parseInt(IrPurchases);
        }
    }

    public int getmPurchases() {
        return mPurchases;
    }

    public void setmPurchases(String ImPurchases) {
        if (ImPurchases.equals("")) {
            this.mPurchases = 0;
        } else {
            this.mPurchases = Integer.parseInt(ImPurchases);
        }
    }

    public Boolean getIsprimaryhouse() {
        return isprimaryhouse;
    }

    public void setIsprimaryhouse(Boolean isprimaryhouse) {
        this.isprimaryhouse = isprimaryhouse;
    }

    public Boolean getAdditionalHeatPump() {
        return additionalHeatPump;
    }

    public void setAdditionalHeatPump(Boolean additionalHeatPump) {
        this.additionalHeatPump = additionalHeatPump;
    }

    public Boolean getAdditionalHeatSelfGen() {
        return additionalHeatSelfGen;
    }

    public void setAdditionalHeatSelfGen(Boolean additionalHeatSelfGen) {
        this.additionalHeatSelfGen = additionalHeatSelfGen;
    }

    public Boolean getAdditionalHeatWood() {
        return additionalHeatWood;
    }

    public void setAdditionalHeatWood(Boolean additionalHeatWood) {
        this.additionalHeatWood = additionalHeatWood;
    }

    public int getcPurchases() {
        return cPurchases;
    }

    public void setcPurchases(String IcPurchases) {
        if (IcPurchases.equals("")) {
            this.cPurchases = 0;
        } else {
            this.cPurchases = Integer.parseInt(IcPurchases);
        }
    }
}
