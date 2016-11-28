package com.example.navid.myapplication3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.wbFahToC);
        String url = "http://fahrenheittocelsius.com/";
        myWebView.loadUrl(url);

        // By default, javascript is not enabled in WebView and needs to enable from WebSettings
        WebSettings settings = myWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        // open other pages inside of the webview , (using default WebViewClient())
        // myWebView.setWebViewClient(new WebViewClient() );
        // using custom WebViewClient()
         myWebView.setWebViewClient(new CustomWebViewClient());

        // Injects the supplied Java object into this WebView from javascript
        myWebView.addJavascriptInterface(new MyJSInterface(this),"JSInterface");
        // in your javascript code in the web app
        // if you write JSInterface.showToast()
        // then you should be able to see a toast in your web App
    }

    // By default, WebView does not handle the back key in android, and need to get fixed like this :
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && myWebView.canGoBack()){
            myWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
