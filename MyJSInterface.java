package com.example.navid.myapplication3;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Navid on 11/27/2016.
 */
public class MyJSInterface {

    private Context context;

    MyJSInterface(Context context){
        this.context = context;
    }

    public void showToast(){
        Toast.makeText(context, "this is from js interface", Toast.LENGTH_SHORT).show();
    }

}
