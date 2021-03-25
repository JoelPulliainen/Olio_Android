package com.example.viikko11;

public class Helper {
    private static Helper helper;
    private String name;
    private String DP;
    private Boolean state;



    private Helper() {
    }

    public static Helper getInstance() {
        if (helper == null) {
            helper = new Helper();
        }
        return helper;
    }

    public void setText (String name) {
        this.name = name;
    }
    public String getText () {
        return name;
    }
    public void setDP (String DP) {
        this.DP = DP;
    }
    public String getDP () {
        return DP;
    }


    public void setState(Boolean state) {
        this.state = state;
    }

    public Boolean getState() {
        if (state == null) {
            return false;
        }
        return state;
    }
}
