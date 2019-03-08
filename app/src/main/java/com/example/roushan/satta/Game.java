package com.example.roushan.satta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toolbar;

public class Game extends AppCompatActivity {
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("FREE GAME");
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.loadUrl("https://www.youtube.com/channel/UC6erVBT4Hz7lHQseXm5iwUg");
        WebSettings webSettings=mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient());

    }
}
