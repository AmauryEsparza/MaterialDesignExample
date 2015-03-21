package com.example.materialdesignexample.controllers;

import android.util.Log;

import com.example.materialdesignexample.controllers.communicators.GithubService;
import com.example.materialdesignexample.interfaces.IBaseCallbackResponse;
import com.example.materialdesignexample.models.Authorization;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;

/**
 * Created by Amaury Esparza on 26/02/2015.
 */
public class LoginController{

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

    public void login(String encodedString){
        String body = "{\"scopes\": [\"public_repo\"], " +
                "\"client_id\": \"" + CLIENT_GITHUB_ID +
                "\", \"client_secret\": \"" + CLIENT_GITHUB_SECRET +
                "\", \"note\": \"public and private repo authorization\"}";
        Log.d("LoginCOntroller", body);
        try {
            TypedInput bodyJson = new TypedByteArray("application/json", body.getBytes("UTF-8"));
            apiService.loginAuthorization("Basic " + encodedString, bodyJson, new Callback<Authorization>() {
                @Override
                public void success(Authorization authorization, Response response) {
                    callbackClass.responseCallback(authorization);
                }

                @Override
                public void failure(RetrofitError error) {
                    callbackClass.responseCallback(null);
                }
            });
        } catch (Exception e) {
            Log.d("LoginController", "Failure to parse");
            e.printStackTrace();
            callbackClass.responseCallback(null);
        }



        /*apiService.login("Basic " + encodedString, new Callback<User>() {
            @Override
            public void success(User user, Response response) {
                callbackClass.responseCallback(user);
            }

            @Override
            public void failure(RetrofitError error) {
                callbackClass.responseCallback(null);
            }
        });

        */


    }
}
