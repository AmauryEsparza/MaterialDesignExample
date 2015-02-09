package com.example.materialdesignexample.interfaces;

import java.util.List;

/**
 * Created by Amaury Esparza on 06/02/2015.
 */
public interface IBaseCallbackResponse <T>{
    public void responseCallback(T type);
    public void responseListCallback(List<T> listType);
}
