package com.example.materialdesignexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Amaury Esparza on 31/01/2015.
 */
public class CardsActivity extends Activity {

    TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_layout);
        textView = (TextView) findViewById(R.id.info_text);
        textView.setText("Que onda ");
    }
}
