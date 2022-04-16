package com.example.mybooklibrary.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.mybooklibrary.R;

public class website extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
        webView=findViewById(R.id.webView);
        webView.loadUrl("https://www.facebook.com/profile.php?id=100009298366151");
        webView.setWebViewClient(new WebViewClient()); //to open My FACEBOOK PAGE WITHIN THE APPLICATION
    }
}