package com.example.navid.myapplication3;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

/**
 * Created by Navid on 11/27/2016.
 */
public class CustomWebViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        // In this option, can get the URL from the request
        // URL url = request.getUrl();
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        if(url.contains("http://fahrenheittocelsius.com/fahrenheit.php")){
            view.loadUrl("http://google.com");
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }
}
