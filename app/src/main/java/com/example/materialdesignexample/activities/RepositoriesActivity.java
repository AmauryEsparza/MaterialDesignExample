package com.example.materialdesignexample.activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.materialdesignexample.R;
import com.example.materialdesignexample.interfaces.IBaseFragmentCommunicator;
import com.example.materialdesignexample.models.Repos;

/**
 * Created by Amaury Esparza on 07/02/2015.
 */
public class RepositoriesActivity extends Activity implements IBaseFragmentCommunicator<Repos>{

    @Override
    public void onCreate(Bundle savedInstanceState){
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        getWindow().setSharedElementExitTransition(new ChangeBounds());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories);
    }

    @Override
    public void communicatorFromFragment(Repos repo){

    }

    @Override
    public void commonSharedElements(View sharedView, Repos repo){
        if(sharedView != null) {
            Toast.makeText(this, "Common Shared Elements Received", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, DetailsRepositoriesActivity.class);
            TextView view_description = (TextView) sharedView.findViewById(R.id.description_text);
            //Shared elements
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
                    view_description, "description_text"
                    );
            startActivity(intent, options.toBundle());
        }
    }
}
