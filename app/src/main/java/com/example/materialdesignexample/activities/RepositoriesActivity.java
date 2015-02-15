package com.example.materialdesignexample.activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeTransform;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.materialdesignexample.R;
import com.example.materialdesignexample.interfaces.IBaseFragmentCommunicator;

/**
 * Created by Amaury Esparza on 07/02/2015.
 */
public class RepositoriesActivity extends Activity implements IBaseFragmentCommunicator{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Animation permission
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        //Set transitions
        getWindow().setEnterTransition(new Explode());
        setContentView(R.layout.activity_repositories);
    }

    @Override
    public void communicatorFragment(){

    }

    @Override
    public void commonSharedElements(View[] sharedElements){
        if(sharedElements.length >= 1) {
            Toast.makeText(this, "Common Shared Elements Received", Toast.LENGTH_LONG).show();
            Transition elementTransition = new ChangeTransform();
            getWindow().setSharedElementExitTransition(elementTransition);
            Intent intent = new Intent(this, DetailsRepositoriesActivity.class);
            View titleView = sharedElements[0];
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, titleView, "title");
            startActivity(intent, options.toBundle());
        }
    }
}
