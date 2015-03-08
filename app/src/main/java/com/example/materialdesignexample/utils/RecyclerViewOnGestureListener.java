package com.example.materialdesignexample.utils;

import android.app.Fragment;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.example.materialdesignexample.interfaces.IBaseTouchConfirmed;

/**
 * Created by Amaury Esparza on 09/02/2015.
 * Here could catch different events on the RecyclerView like:
 *      DoubleTap
 *      SingleTap
 *      Or another motion gesture
 */

public class RecyclerViewOnGestureListener extends GestureDetector.SimpleOnGestureListener{
    private IBaseTouchConfirmed responseFragment;

    //Receive the instance to the Fragment callback it
    public RecyclerViewOnGestureListener(Fragment responseFragment){
        this.responseFragment = (IBaseTouchConfirmed) responseFragment;
    }


    @Override
    public boolean onDoubleTap(MotionEvent e){
        responseFragment.doubleTapConfirmed();
        return super.onDoubleTap(e);
    }
}
