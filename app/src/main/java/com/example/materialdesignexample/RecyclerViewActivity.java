package com.example.materialdesignexample;

import android.app.Activity;
import android.os.Bundle;

import com.example.materialdesignexample.controllers.RecyclerViewController;
/**
 * Created by Amaury Esparza on 03/02/2015.
 */
public class RecyclerViewActivity extends Activity {

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        //RecyclerViewController controller = new RecyclerViewController("AmauryEsparza");
    }
}
