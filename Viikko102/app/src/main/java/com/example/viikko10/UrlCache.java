package com.example.viikko10;


import android.net.Uri;

import java.util.ArrayList;

public class UrlCache {
    private static UrlCache urlCache;
    private String name;
    private int Index = 0;
    ArrayList<String> Urls = new ArrayList<String>();

    private UrlCache() {
    }

    public static UrlCache getInstance() {
        if (urlCache == null) {
            urlCache = new UrlCache();
        }
        return urlCache;
    }
    public void setId() {
        Index = Urls.size()-1;
    }

    public void addId() {
        Index++;
    }
    public void backId() {
        Index--;
    }
    public int getId() {
        return Index;
    }

    public void setUrl(String name) {
        this.name = name;
        Urls.add(name);
    }

    public String getUrl() {
        return name;
    }
}
/*
class Urls {
    private String name;

    public static void add(String url) {
        this.name = url;
    }

    public void setId(int id) {
        Index = id;
    }

    public int getId() {
        return Index;
    }

    public void setUrl(String name) {
        this.name = name;
    }

    public String getUrl() {
        return name;
    }
}*/