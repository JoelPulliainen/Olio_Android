package com.example.viikko10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import static com.example.viikko10.UrlCache.*;

public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText urlText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlText = findViewById(R.id.editUrlText);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);

    }
    public void refresh(View v) {
        web.reload();
    }

    public void initJavascript(View v){
        web.loadUrl("file:///android_asset/index.html");
        System.out.println("init?");
        web.evaluateJavascript("javascript:initialize()",null);
    }

    public void shoutOutJavascript(View v) {
        System.out.println("Shoutout");
        web.evaluateJavascript("javascript:shoutOut()",null);
    }
    public void searchUrl(View v) {
        String Url = urlText.getText().toString();
        if (getInstance().getId() != getInstance().Urls.size()) {
            int remover = getInstance().getId()+1;
            getInstance().Urls.subList(remover, getInstance().Urls.size()).clear();
        }
        getInstance().setUrl(Url);
        getInstance().setId();
        web.loadUrl("http://" + Url);
    }
    public void goBack(View v) {
        try {
            if (getInstance().getId() > 0) {
                String Url = getInstance().Urls.get(getInstance().getId()-1);
                web.loadUrl("http://" + Url);
                getInstance().backId();
            }
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
    public void goForward(View v) {
        try {
            String Url = getInstance().Urls.get(getInstance().getId()+1);
            web.loadUrl("http://" + Url);
            getInstance().addId();
        }  catch (Exception e) {
        e.printStackTrace();
        }

    }
}