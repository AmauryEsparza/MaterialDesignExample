package com.example.materialdesignexample.controllers.communicators;

import com.example.materialdesignexample.models.Repos;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by Amaury Esparza on 03/02/2015.
 */
public interface GithubService {
    @GET("/users/{user}/repos")
    void listRepos(@Path("user") String user, Callback<List<Repos>> listRepos);

    @GET("/repos/{user}/{repoName}")
    void specificRepo(@Path("user") String user, @Path("repoName") String repoName, Callback<Repos> repo);
}
