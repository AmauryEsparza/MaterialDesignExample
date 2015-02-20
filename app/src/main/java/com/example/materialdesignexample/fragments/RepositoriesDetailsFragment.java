package com.example.materialdesignexample.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.materialdesignexample.R;
import com.example.materialdesignexample.interfaces.IActivityCommunicator;
import com.example.materialdesignexample.models.Repos;

/**
 * Created by Amaury Esparza on 15/02/2015.
 */
public class RepositoriesDetailsFragment extends Fragment {

    IActivityCommunicator activityCommunicator;
    TextView textTitle;
    TextView textDescription;
    TextView textLanguage;

    @Override
    public void onAttach(Activity activity){
        activityCommunicator = (IActivityCommunicator) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout with the RecyclerView
        return inflater.inflate(R.layout.fragment_repository_details, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        textTitle = (TextView) getActivity().findViewById(R.id.textTitle);
        textDescription = (TextView) getActivity().findViewById(R.id.textDescription);
        textLanguage = (TextView) getActivity().findViewById(R.id.textLanguage);
        //Get the Model from parent activity
        Repos repo = (Repos) activityCommunicator.getDataFromActivity();
        textTitle.setText(repo.getName());
        textDescription.setText(repo.getDescription());
        textLanguage.setText(repo.getLanguage());

        //The fragment communicator LOOKUP because im not sure it works
        //activityCommunicator.communicatorFromFragment(new Repos());
    }
}
