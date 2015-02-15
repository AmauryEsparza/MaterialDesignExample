package com.example.materialdesignexample.utils;

import android.view.GestureDetector;
import android.view.MotionEvent;

import com.example.materialdesignexample.fragments.RepositoriesListFragment;

/**
 * Created by Amaury Esparza on 09/02/2015.
 * Here could catch different events on the RecyclerView like:
 *      DoubleTap
 *      SingleTap
 *      Or another motion gesture
 */

public class RecyclerViewOnGestureListener extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        RepositoriesListFragment.tapConfirmed();
        return super.onSingleTapConfirmed(e);
    }
}
