package com.example.materialdesignexample.controllers;

import com.example.materialdesignexample.controllers.communicators.GithubService;
import com.example.materialdesignexample.interfaces.IBaseCallbackResponse;
import com.example.materialdesignexample.models.User;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Amaury Esparza on 26/02/2015.
 */
public class LoginController {

    private final String CLIENT_GITHUB_ID = "092b8327eb819f704590";
    private final String CLIENT_GITHUB_SECRET = "9be05062df85724a096608868c85cd6ef2eeb535";
    //Callback to the Fragment
    private IBaseCallbackResponse callbackClass;
    private GithubService apiService;

    public LoginController(IBaseCallbackResponse callbackClass) {
        this.callbackClass = callbackClass;
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        apiService = restAdapter.create(GithubService.class);
    }

    public void login(){
        apiService.login("Basic QW1hdXJ5RXNwYXJ6YTpqdXZlbnR1czE=", new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                callbackClass.responseCallback(user);
            }

            @Override
            public void failure(RetrofitError error) {
                callbackClass.responseCallback(null);
            }
        });


    }






}
