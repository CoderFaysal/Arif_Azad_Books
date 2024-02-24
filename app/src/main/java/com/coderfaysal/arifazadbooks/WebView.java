package com.coderfaysal.arifazadbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WebView extends AppCompatActivity {

    android.webkit.WebView webView;
    public static String BOOK_URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        webView = findViewById(R.id.webView);

        webView.loadUrl(BOOK_URL);

        webView.getSettings().setJavaScriptEnabled(true);




    }
}