package com.example.materialdesignexample.activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Slide;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
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
        getWindow().setEnterTransition(new ChangeBounds());
        //getWindow().setExitTransition(new Slide());
        //getWindow().setSharedElementExitTransition(new ChangeBounds());
        //getWindow().setSharedElementEnterTransition(new ChangeBounds());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_repositories);
    }

    @Override
    public void communicatorFromFragment(Repos repo) {

    }

    @Override
    public void commonSharedElements(View sharedView, Repos repo) {
        View textTitle =  sharedView.findViewById(R.id.title_repo_text);
        String title = ((TextView) textTitle).getText().toString();
        View descriptionRepo = sharedView.findViewById(R.id.description_repo_text);
        String description = ((TextView) descriptionRepo).getText().toString();
        Intent intent = new Intent(this, RepositoryDetailsActivity.class);
        intent.putExtra("repo", repo);
        intent.putExtra("title", title);
        intent.putExtra("description", description);
        //Set the shared elements
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
                Pair.create(textTitle, "shared_title_text"),
                Pair.create(descriptionRepo, "shared_description_text"));
        startActivity(intent, options.toBundle());
    }
}
