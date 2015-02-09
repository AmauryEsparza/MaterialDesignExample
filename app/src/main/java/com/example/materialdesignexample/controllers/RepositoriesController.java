package com.example.materialdesignexample.controllers;

import android.util.Log;
import android.widget.Toast;

import com.example.materialdesignexample.controllers.communicators.GithubService;
import com.example.materialdesignexample.fragments.RepositoriesListFragment;
import com.example.materialdesignexample.interfaces.IBaseCallbackResponse;
import com.example.materialdesignexample.models.Repos;

import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Amaury Esparza on 06/02/2015.
 */
public class RepositoriesController{

    //private T requesterClass;
    private IBaseCallbackResponse requesterClass;
    private GithubService apiService;
    public RepositoriesController(IBaseCallbackResponse typeRequester){
        requesterClass = typeRequester;
        //Add the User-Agent
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("User-Agent", "MaterialDesignExample");
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(requestInterceptor)
                .build();

        apiService = restAdapter.create(GithubService.class);
    }

    public void getRepositoriesList(String username){
        apiService.listRepos(username, new Callback<List<Repos>>() {
            @Override
            public void success(List<Repos> reposList, Response response) {
                Log.d("Retrofit List<Repo> request", "Success");
                requesterClass.responseListCallback(reposList);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Retrofit List<Repo> request", "Error");
                requesterClass.responseListCallback(null);
            }
        });
    }

    public void getSpecificRepo(String username, String repoName){
        apiService.specificRepo(username, repoName, new Callback<Repos>() {
            @Override
            public void success(Repos repos, Response response) {
                Log.d("Retrofit Repo request", "Success");
                requesterClass.responseCallback(repos);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("Retrofit Repo request", "Error");
            }
        });
    }


}
