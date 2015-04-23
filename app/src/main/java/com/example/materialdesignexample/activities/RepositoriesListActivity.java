package com.example.materialdesignexample.activities;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.materialdesignexample.R;
import com.example.materialdesignexample.fragments.RepositoriesListFragment;
import com.example.materialdesignexample.interfaces.IBaseFragmentCommunicator;
import com.example.materialdesignexample.models.Repos;

/**
 * Created by Amaury Esparza on 15/02/2015.
 */
public class RepositoriesListActivity extends Activity implements IBaseFragmentCommunicator<Repos>{

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    @Override
    public void onCreate(Bundle savedInstanceState){
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().setEnterTransition(new ChangeBounds());
        //getWindow().setExitTransition(new Slide());
        //getWindow().setSharedElementExitTransition(new ChangeBounds());
        //getWindow().setSharedElementEnterTransition(new ChangeBounds());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_repositories);

        if(findViewById(R.id.content_frame) != null){
            //Fragment transaction
            FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();
            mFragmentTransaction.replace(R.id.content_frame, new RepositoriesListFragment());
            mFragmentTransaction.commit();
        }

        toolbar = (Toolbar) findViewById(R.id.base_toolbar);

        mDrawerTitle = mTitle = getTitle();
        String[] arrayItems = {"One", "Two", "Three"};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.nav_drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_drawer);
        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, Gravity.START);
        //Set the adapter to the List of the Navigation Drawer
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, arrayItems));

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close){
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
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void communicatorFromFragment(Repos repo) {

    }

    @Override
    public void commonSharedElements(View sharedView, Repos repo) {
        View textTitle =  sharedView.findViewById(R.id.title_repo_text);
        View descriptionRepo = sharedView.findViewById(R.id.description_repo_text);
        Intent intent = new Intent(this, RepositoryDetailsActivity.class);
        intent.putExtra("repo", repo);
        //intent.putExtra("title", repo.getName());
        //intent.putExtra("description", repo.getDescription());
        //Set the shared elements
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
                Pair.create(textTitle, "shared_title_text"),
                Pair.create(descriptionRepo, "shared_description_text"));
        startActivity(intent, options.toBundle());
    }

    //When click the left icon
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }
}
