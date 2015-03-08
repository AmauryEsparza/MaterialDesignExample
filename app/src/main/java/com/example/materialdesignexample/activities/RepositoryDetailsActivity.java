package com.example.materialdesignexample.activities;

import android.app.Activity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.view.View;
import android.view.Window;

import com.example.materialdesignexample.R;
import com.example.materialdesignexample.interfaces.IBaseFragmentCommunicator;
import com.example.materialdesignexample.models.Repos;

/**
 * Created by Amaury Esparza on 15/02/2015.
 *
 */
public class RepositoryDetailsActivity extends Activity implements IBaseFragmentCommunicator<Repos>{

    @Override
    public void onCreate(Bundle savedInstanceState){
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setAllowEnterTransitionOverlap(true);
        //getWindow().setEnterTransition(new ChangeBounds());
        getWindow().setExitTransition(new ChangeBounds());
        getWindow().setSharedElementEnterTransition(new ChangeBounds());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_details);

    }

    @Override
    public void communicatorFromFragment(Repos repo) {

    }

    @Override
    public void commonSharedElements(View sharedView, Repos repo) {

    }
}
