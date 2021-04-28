package com.example.myht;


// Helper class to get spinner data to the GraphDialog

public class Helper {
    private static Helper Helper;
    private String data1;


    public static Helper getInstance() {
        if (Helper == null) {
            Helper = new Helper();
        }
        return Helper;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data) {
        this.data1 = data;
    }

}
