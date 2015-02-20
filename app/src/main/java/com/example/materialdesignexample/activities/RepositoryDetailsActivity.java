package com.example.materialdesignexample.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.materialdesignexample.R;
import com.example.materialdesignexample.interfaces.IActivityCommunicator;
import com.example.materialdesignexample.models.Repos;

/**
 * Created by Amaury Esparza on 15/02/2015.
 *
 */
public class RepositoryDetailsActivity extends Activity implements IActivityCommunicator<Repos>{

    private Repos repo;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        repo = (Repos) intent.getSerializableExtra("repo");
        Toast.makeText(this, "Receive the Object", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_repository_details);
    }

    @Override
    public Repos getDataFromActivity() {
        if(repo != null){
            return repo;
        }
        else{
            Toast.makeText(this, "There a internal problem, try again later", Toast.LENGTH_LONG).show();
            return null;
        }
    }

    @Override
    public void communicatorFromFragment(Object object) {
    }

    @Override
    public void commonSharedElements(View sharedView) {

    }
}
