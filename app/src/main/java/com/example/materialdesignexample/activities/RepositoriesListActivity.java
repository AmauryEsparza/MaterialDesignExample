package com.example.materialdesignexample.activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.transition.TransitionInflater;
import android.widget.Toolbar;
import android.transition.ChangeBounds;
import android.util.Pair;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.materialdesignexample.R;
import com.example.materialdesignexample.fragments.RepositoriesDetailsFragment;
import com.example.materialdesignexample.fragments.RepositoriesListFragment;
import com.example.materialdesignexample.interfaces.IBaseFragmentCommunicator;
import com.example.materialdesignexample.models.Repos;

/**
 * Created by Amaury Esparza on 15/02/2015.
 */
public class RepositoriesListActivity extends Activity implements IBaseFragmentCommunicator<Repos>{

    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    @Override
    public void onCreate(Bundle savedInstanceState){
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        //getWindow().setEnterTransition(new ChangeBounds());
        //getWindow().setExitTransition(new Slide());
        //getWindow().setSharedElementExitTransition(new ChangeBounds());
        //getWindow().setSharedElementEnterTransition(new ChangeBounds());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_repositories);

        DrawerLayout mDrawerLayout;
        ListView mDrawerList;
        Toolbar toolbar = (Toolbar) findViewById(R.id.base_toolbar);
        setActionBar(toolbar);
        if(findViewById(R.id.content_frame) != null){
            //Fragment transaction
            FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
            mFragmentTransaction.replace(R.id.content_frame, new RepositoriesListFragment());
            mFragmentTransaction.commit();
        }

        mDrawerTitle = mTitle = getTitle();
        String[] arrayItems = {"One", "Two", "Three"};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.nav_drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_drawer);
        //Set the adapter to the List of the Navigation Drawer
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, arrayItems));

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close)
        {
            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }
            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void communicatorFromFragment(Repos repo) {

    }

    //Handle the callback from Fragment
    @Override
    public void commonSharedElements(View sharedView, Repos repo) {
        View textTitle =  sharedView.findViewById(R.id.title_repo_text);
        View descriptionRepo = sharedView.findViewById(R.id.description_repo_text);

        //Pass the values to the Fragment
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("repo", repo);
        mBundle.putString("title", repo.getName());
        mBundle.putString("description", repo.getDescription());

        //Set the shared elements
        FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.addSharedElement(textTitle, "shared_title_text");
        mFragmentTransaction.addSharedElement(descriptionRepo, "shared_description_text");
        Fragment mFragmentDetails = new RepositoriesDetailsFragment();
        mFragmentDetails.setArguments(mBundle);

        //Shared elements with animations
        mFragmentDetails.setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.change_item_transform));
        mFragmentDetails.setEnterTransition(TransitionInflater.from(this).inflateTransition(android.R.transition.explode));

        //Fragment transaction
        mFragmentTransaction.replace(R.id.content_frame, mFragmentDetails).addToBackStack("transaction").addSharedElement(textTitle, "shared_title_text");
        mFragmentTransaction.commit();
        /*ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
                Pair.create(textTitle, "shared_title_text"),
                Pair.create(descriptionRepo, "shared_description_text"));
        startActivity(intent, options.toBundle());*/
    }

    //When click the left icon
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch(item.getItemId()){
            case R.id.action_search:
                Toast.makeText(this, "Search Button", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "Settings Button", Toast.LENGTH_LONG).show();
                return true;
            default:
                Toast.makeText(this, "Default Behaivior", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);
        }
        // Handle your other action bar items...
    }
}
