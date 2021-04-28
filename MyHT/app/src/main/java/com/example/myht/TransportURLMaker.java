package com.example.myht;

// Singleton class to make URLs for Ilmastodieetti API

public class TransportURLMaker {
        private static TransportURLMaker transportURLMaker;
        private String boattype;
        private int bfConsumption, buHours, bPower, buCount, mfConsumption, mfDistance, cbDistance, ctDistance , bDistance, tDistance, mDistance, tramDistance, cFlights, eFlights, fFlights, tcFlights, gCruises, eCruises, sCruises;
        private Boolean boat_calc;

    public TransportURLMaker() {
    }

    public static TransportURLMaker getInstance() {
            if (transportURLMaker == null) {
                transportURLMaker = new TransportURLMaker();
            }
            return transportURLMaker;
        }

        // Create the URL

        public String URLquary() {
            String query = "";
            if (getBoat_calc() != null) {
                query += "query.useBoatFuelConsumption=" + String.valueOf(getBoat_calc()) + "&";
            }
            if (getBfConsumption() >= 0) {
                query += ("query.boatFuelConsumption=" + String.valueOf(getBfConsumption()) + "&");
            }
            if (getBuHours() >= 0) {
                query += "query.boatUsageHours=" + String.valueOf(getBuHours()) + "&";
            }
            if (getbPower() >= 0) {
                query += "query.boatPower=" + String.valueOf(getbPower()) + "&";
            }
            if (getBoattype() != null){
                query += "query.boatType=" + String.valueOf(getBoattype()) + "&";
            }
            if (getBuCount() >= 0) {
                query += "query.boatUserCount=" + String.valueOf(getBuCount()) + "&";
            }
            if (getMfConsumption() >= 0) {
                query += "query.motorcycleFuelConsumptionl=" + String.valueOf(getMfConsumption()) + "&";
            }
            if (getMfDistance() >= 0) {
                query += "motorcycleDistance=" + String.valueOf(getMfDistance()) + "&";
            }
            if (getCbDistance() >= 0) {
                query += "cityBusDistance=" + String.valueOf(getCbDistance()) + "&";
            }
            if (getCtDistance() >= 0) {
                query += "query.cityTrainDistance=" + String.valueOf(getbDistance()) + "&";
            }
            if (getbDistance() >= 0) {
                query += "query.busDistance=" + String.valueOf(gettDistance()) + "&";
            }
            if (getCbDistance() >= 0) {
                query += "cityBusDistance=" + String.valueOf(getCbDistance()) + "&";
            }
            if (gettDistance() >= 0) {
                query += "query.trainDistance=" + String.valueOf(getbDistance()) + "&";
            }
            if (getmDistance() >= 0) {
                query += "query.metroDistance=" + String.valueOf(gettDistance()) + "&";
            }
            if (getTramDistance() >= 0) {
                query += "query.tramDistance=" + String.valueOf(getCbDistance()) + "&";
            }
            if (getcFlights() >= 0) {
                query += "query.canaryFlights=" + String.valueOf(getbDistance()) + "&";
            }
            if (geteFlights() >= 0) {
                query += "query.europeanFlights=" + String.valueOf(gettDistance()) + "&";
            }
            if (getfFlights() >= 0) {
                query += "query.finlandFlights=" + String.valueOf(getbDistance()) + "&";
            }
            if (getTcFlights() >= 0) {
                query += "query.transContinentalFlights=" + String.valueOf(gettDistance()) + "&";
            }
            if (getgCruises() >= 0) {
                query += "query.germanyCruises=" + String.valueOf(getbDistance()) + "&";
            }
            if (geteCruises() >= 0) {
                query += "query.estoniaCruises=" + String.valueOf(gettDistance()) + "&";
            }
            if (getsCruises() >= 0) {
                query += "query.swedenCruises=" + String.valueOf(getbDistance()) + "&";
            }


            query = "https://ilmastodieetti.ymparisto.fi/ilmastodieetti/calculatorapi/v1/TransportCalculator?" + query + "&";
            System.out.println(query);
            return query;
        }


        public String getBoattype() {
            return boattype;
        }

        public void setBoattype(String boattype) {
            this.boattype = boattype;
        }

        public int getBfConsumption() {
            return bfConsumption;
        }

        public void setBfConsumption(String IbfConsumption) {
            if (IbfConsumption.equals("")) {
                this.bfConsumption = 0;
            } else {
                this.bfConsumption = Integer.parseInt(IbfConsumption);
            }
        }

        public int getBuHours() {
            return buHours;
        }

        public void setBuHours(String IbuHours) {
            if (IbuHours.equals("")) {
                this.buHours = 0;
            } else {
                this.buHours = Integer.parseInt(IbuHours);
            }
        }

        public int getbPower() {
            return bPower;
        }

        public void setbPower(String ItbPower) {
            if (ItbPower.equals("")) {
                this.bPower = 0;
            } else {
                this.bPower = Integer.parseInt(ItbPower);
            }
        }

        public int getBuCount() {
            return buCount;
        }

        public void setBuCount(String IbuCount) {
            if (IbuCount.equals("")) {
                this.buCount = 0;
            } else {
                this.buCount = Integer.parseInt(IbuCount);
            }
        }

        public int getMfConsumption() {
            return mfConsumption;
        }

        public void setMfConsumption(String ImfConsumption) {
            if (ImfConsumption.equals("")) {
                this.mfConsumption = 0;
            } else {
                this.mfConsumption = Integer.parseInt(ImfConsumption);
            }
        }

        public int getMfDistance() {
            return mfDistance;
        }

        public void setMfDistance(String ImfDistance) {
            if (ImfDistance.equals("")) {
                this.mfDistance = 0;
            } else {
                this.mfDistance = Integer.parseInt(ImfDistance);
            }
        }

        public int getCbDistance() {
            return cbDistance;
        }

        public void setCbDistance(String IcbDistance) {
            if (IcbDistance.equals("")) {
                this.cbDistance = 0;
            } else {
                this.cbDistance = Integer.parseInt(IcbDistance);
            }
        }

        public int getbDistance() {
            return bDistance;
        }

        public void setbDistance(String IbDistance) {
            if (IbDistance.equals("")) {
                this.bDistance = 0;
            } else {
                this.bDistance = Integer.parseInt(IbDistance);
            }
        }

        public int gettDistance() {
            return tDistance;
        }

        public void settDistance(String ItDistance) {
            if (ItDistance.equals("")) {
                this.tDistance = 0;
            } else {
                this.tDistance = Integer.parseInt(ItDistance);
            }
        }

        public Boolean getBoat_calc() {
            return boat_calc;
        }

        public void setBoat_calc(Boolean boat_calc) {
            this.boat_calc = boat_calc;
        }

    public int getcFlights() {
        return cFlights;
    }

    public void setcFlights(String IcFlights) {
        if (IcFlights.equals("")) {
            this.cFlights = 0;
        } else {
            this.cFlights = Integer.parseInt(IcFlights);
        }
    }

    public int geteFlights() {
        return eFlights;
    }

    public void seteFlights(String IeFlights) {
        if (IeFlights.equals("")) {
            this.eFlights = 0;
        } else {
            this.eFlights = Integer.parseInt(IeFlights);
        }
    }

    public int getfFlights() {
        return fFlights;
    }

    public void setfFlights(String IfFlights) {
        if (IfFlights.equals("")) {
            this.fFlights = 0;
        } else {
            this.fFlights = Integer.parseInt(IfFlights);
        }
    }

    public int getTcFlights() {
        return tcFlights;
    }

    public void setTcFlights(String ItcFlights) {
        if (ItcFlights.equals("")) {
            this.tcFlights = 0;
        } else {
            this.tcFlights = Integer.parseInt(ItcFlights);
        }
    }

    public int getgCruises() {
        return gCruises;
    }

    public void setgCruises(String IgCruises) {
        if (IgCruises.equals("")) {
            this.gCruises = 0;
        } else {
            this.gCruises = Integer.parseInt(IgCruises);
        }
    }

    public int geteCruises() {
        return eCruises;
    }

    public void seteCruises(String IeCruises) {
        if (IeCruises.equals("")) {
            this.eCruises = 0;
        } else {
            this.eCruises = Integer.parseInt(IeCruises);
        }
    }

    public int getsCruises() {
        return sCruises;
    }

    public void setsCruises(String IsCruises) {
        if (IsCruises.equals("")) {
            this.sCruises = 0;
        } else {
            this.sCruises = Integer.parseInt(IsCruises);
        }
    }

    public int getCtDistance() {
        return ctDistance;
    }

    public void setCtDistance(String IctDistance) {
        if (IctDistance.equals("")) {
            this.ctDistance = 0;
        } else {
            this.ctDistance = Integer.parseInt(IctDistance);
        }
    }

    public int getmDistance() {
        return mDistance;
    }

    public void setmDistance(String ImDistance) {
        if (ImDistance.equals("")) {
            this.mDistance = 0;
        } else {
            this.mDistance = Integer.parseInt(ImDistance);
        }
    }

    public int getTramDistance() {
        return tramDistance;
    }

    public void setTramDistance(String ItramDistance) {
        if (ItramDistance.equals("")) {
            this.tramDistance = 0;
        } else {
            this.tramDistance = Integer.parseInt(ItramDistance);
        }
    }
}
