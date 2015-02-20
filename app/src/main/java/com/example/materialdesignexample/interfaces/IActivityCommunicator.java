package com.example.materialdesignexample.interfaces;

/**
 * Created by Amaury Esparza on 20/02/2015.
 */
public interface IActivityCommunicator <T> extends IBaseFragmentCommunicator{
    public T getDataFromActivity();
}
