package com.example.materialdesignexample.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.MotionEvent;
import android.view.Window;

import com.example.materialdesignexample.R;

/**
 * Created by Amaury Esparza on 07/02/2015.
 */
public class RepositoriesActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories);

        //Animation permission
        //getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        //Set transitions
        //getWindow().setEnterTransition(new Explode());
        //Transition elementTransition = new ChangeTransform();
        //getWindow().setSharedElementEnterTransition(elementTransition);
    }
}
