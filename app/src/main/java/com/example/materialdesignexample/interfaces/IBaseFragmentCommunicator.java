package com.example.materialdesignexample.interfaces;

import android.view.View;

/**
 * Created by Amaury Esparza on 12/02/2015.
 */
public interface IBaseFragmentCommunicator <T>{
    public void communicatorFromFragment(T values);
    public void commonSharedElements(View sharedView);
}
