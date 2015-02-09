package com.example.materialdesignexample;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Amaury Esparza on 01/02/2015.
 */
public class ClipViewsActivity extends Activity implements View.OnClickListener{

    Button buttonVisible;
    Button buttonInvisible;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clipview_layout);
        buttonVisible = (Button) findViewById(R.id.buttonVisible);
        buttonInvisible = (Button) findViewById(R.id.buttonInvisible);
        buttonVisible.setOnClickListener(this);
        buttonInvisible.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.buttonVisible:
                setTextVisible();
                break;
            case R.id.buttonInvisible:
                setTextInvisible();
                break;
            default:
                Toast.makeText(this, "Try again later", Toast.LENGTH_LONG).show();
        }

    }

    private void setTextVisible(){

        // previously invisible view
        View myView = findViewById(R.id.textView3);

        // get the center for the clipping circle
        int cx = (myView.getLeft() + myView.getRight()) / 2;
        int cy = (myView.getTop() + myView.getBottom()) / 2;

        // get the final radius for the clipping circle
        int finalRadious = Math.max(myView.getWidth(), myView.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator anim = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadious);

        // make the view visible and start the animation
        myView.setVisibility(View.VISIBLE);
        anim.start();
        myView.setClipToOutline(true);
    }

    private void setTextInvisible(){
        // previously visible view
        final View myView = findViewById(R.id.textView3);

        // get the center for the clipping circle
        int cx = (myView.getLeft() + myView.getRight()) / 2;
        int cy = (myView.getTop() + myView.getBottom()) / 2;

        // get the initial radius for the clipping circle
        int initialRadius = myView.getWidth();

        // create the animation (the final radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0);

        // make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                myView.setVisibility(View.INVISIBLE);
            }
        });
        // start the animation
        anim.start();

    }
}
