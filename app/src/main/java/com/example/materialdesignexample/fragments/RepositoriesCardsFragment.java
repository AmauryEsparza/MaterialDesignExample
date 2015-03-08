package com.example.materialdesignexample.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.materialdesignexample.R;
import com.example.materialdesignexample.controllers.RepositoriesController;
import com.example.materialdesignexample.interfaces.IBaseCallbackResponse;
import com.example.materialdesignexample.interfaces.IBaseFragmentCommunicator;
import com.example.materialdesignexample.interfaces.IBaseTouchConfirmed;
import com.example.materialdesignexample.models.Repos;
import com.example.materialdesignexample.utils.RecyclerViewOnGestureListener;
import com.example.materialdesignexample.utils.RecyclerViewRepoAdapter;

import java.util.List;

/**
 * Created by Amaury Esparza on 15/02/2015.
 */
public class RepositoriesCardsFragment extends Fragment implements IBaseCallbackResponse<Repos>, RecyclerView.OnItemTouchListener, IBaseTouchConfirmed{

    private Repos repos;
    private List<Repos> reposList;
    private RecyclerView recyclerView;
    private GestureDetector gestureDetector;
    private LinearLayoutManager layoutManager;
    private static IBaseFragmentCommunicator fragmentCommunicator;
    public static View sharedView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Inflate the layout
        View v = inflater.inflate(R.layout.fragment_repositories, container, false);
        //Reference to the Recycles View
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_repositories);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        //Controller for the make the request
        RepositoriesController rController = new RepositoriesController(this);
        //Create the manager to the RecyclesView
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);
        //When the request complete call responseCallback()
        //rController.getSpecificRepo("AmauryEsparza", "AmauryEsparza.github.io");
        rController.getRepositoriesList("AmauryEsparza");
        //Instance for parent activity method callback
        fragmentCommunicator = (IBaseFragmentCommunicator) getActivity();
    }

    @Override
    public void responseCallback(Repos repos){
        this.repos = repos;
    }

    @Override
    public void responseListCallback(List<Repos> reposList){
        Log.d("RepositoriesListFragment", "responseCallback");
        if(reposList != null){
            this.reposList = reposList;
            RecyclerViewRepoAdapter aItems = new RecyclerViewRepoAdapter(this.reposList);
            recyclerView.setAdapter(aItems);
            //Item Decoration
            //RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity().getApplicationContext());
            //recyclerView.addItemDecoration(itemDecoration);
            recyclerView.addOnItemTouchListener(this);
            gestureDetector = new GestureDetector(getActivity().getApplicationContext(), new RecyclerViewOnGestureListener(this));
        }
        else{
            Toast.makeText(getActivity().getApplicationContext(), "Error al descargar los datos", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        Log.d("Repositories", "onTouchEvent");
    }

    //RecyclerView onTouchItemListener
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        //Get the shared elements for start the activity
        sharedView = rv;
        //Register the gesture for verify what kind of touch happen
        gestureDetector.onTouchEvent(e);
        return false;
    }

    //When the GestureDetector class confirm was a singleTap
    @Override
    public void doubleTapConfirmed() {
        //Activity callback with the sharedElements for the next activity
        Log.d("RepositoriesCardsFragment", "doubleTapConfirmed");
    }
}

