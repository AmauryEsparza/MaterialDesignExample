package com.example.materialdesignexample.activities;

import android.app.Activity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.view.Window;

import com.example.materialdesignexample.R;

/**
 * Created by Amaury Esparza on 12/02/2015.
 *
 * -----In progres (Activity transitions)----
 */
public class DetailsRepositoriesActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setSharedElementEnterTransition(new ChangeBounds());
        getWindow().setSharedElementExitTransition(new ChangeBounds());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_details_repositories);
    }
}
