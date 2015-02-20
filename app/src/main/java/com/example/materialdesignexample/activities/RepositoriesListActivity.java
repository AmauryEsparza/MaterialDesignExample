package com.example.materialdesignexample.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.materialdesignexample.R;
import com.example.materialdesignexample.interfaces.IBaseFragmentCommunicator;
import com.example.materialdesignexample.models.Repos;

/**
 * Created by Amaury Esparza on 15/02/2015.
 */
public class RepositoriesListActivity extends Activity implements IBaseFragmentCommunicator<Repos>{

    @Override
    public void onCreate(Bundle savedInstanceState){
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        getWindow().setEnterTransition(new Slide());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_repositories);
    }

    @Override
    public void communicatorFromFragment(Repos repo) {
        Toast.makeText(this, "RepositoriesListActivity communicatorFragment", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, RepositoryDetailsActivity.class);
        intent.putExtra("repo", repo);
//        intent.putExtra("description", repo.getDescription());
//        intent.putExtra("language", repo.getLanguage());
        startActivity(intent);
    }

    @Override
    public void commonSharedElements(View sharedView) {

    }
}
