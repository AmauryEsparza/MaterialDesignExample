package com.example.materialdesignexample.fragments;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.materialdesignexample.R;
import com.example.materialdesignexample.controllers.RepositoriesController;
import com.example.materialdesignexample.interfaces.IBaseCallbackResponse;
import com.example.materialdesignexample.models.Repos;
import com.example.materialdesignexample.utils.DividerItemDecoration;
import com.example.materialdesignexample.utils.RecyclerViewRepoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amaury Esparza on 06/02/2015.
 */
public class RepositoriesListFragment extends Fragment implements IBaseCallbackResponse<Repos>{

    private Repos repos;
    private List<Repos> reposList;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        //Inflate the layout
        View v = inflater.inflate(R.layout.fragment_repositories, container, false);
        //Reference to the RecyclerView
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_repositories);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        RepositoriesController rController = new RepositoriesController(this);
        //Create the manager to the RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        //When the request complete call responseCallback()
        //rController.getSpecificRepo("AmauryEsparza", "AmauryEsparza.github.io");
        rController.getRepositoriesList("AmauryEsparza");
    }

    @Override
    public void responseCallback(Repos repos){
        Log.d("RepositoriesListFragment", "responseCallback");
        this.repos = repos;
    }

    @Override
    public void responseListCallback(List<Repos> reposList){
        Log.d("RepositoriesListFragment", "responseCallback");
        if(reposList != null){
            this.reposList = reposList;
            RecyclerViewRepoAdapter aItems = new RecyclerViewRepoAdapter(this.reposList);
            recyclerView.setAdapter(aItems);
            //RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity().getApplicationContext(), DividerItemDecoration.VERTICAL_LIST);
            RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity().getApplicationContext());
            recyclerView.addItemDecoration(itemDecoration);
        }
        else{
            Toast.makeText(getActivity().getApplicationContext(), "Error al descargar los datos", Toast.LENGTH_LONG).show();
        }

    }

}
