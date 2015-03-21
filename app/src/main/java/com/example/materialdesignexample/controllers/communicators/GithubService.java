package com.example.materialdesignexample.controllers.communicators;

import com.example.materialdesignexample.models.Authorization;
import com.example.materialdesignexample.models.Repos;
import com.example.materialdesignexample.models.User;

import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.mime.TypedInput;

/**
 * Created by Amaury Esparza on 03/02/2015.
 */
public interface GithubService {

    @GET("/users/{user}/repos")
    void listRepos(@Path("user") String user, Callback<List<Repos>> listRepos);

    @GET("/repos/{user}/{repoName}")
    void specificRepo(@Path("user") String user, @Path("repoName") String repoName, Callback<Repos> repo);

    @PUT("/authorizations/clients/{client_id}")
    void loginApplication(@Path("client_id") String client_id, Callback<Repos> repo);

    @GET("/authorization")
    void login(@Header("Authorization") String authorization, Callback<User> user);

    @Headers({
            "User-Agent: Material-Example"
    })
    @POST("/authorizations")
    void loginAuthorization(@Header("Authorization") String authorization, @Body TypedInput body, Callback<Authorization> authorizationModel);

}
