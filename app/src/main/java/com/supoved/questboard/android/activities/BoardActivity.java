package com.supoved.questboard.android.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.supoved.questboard.R;
import com.supoved.questboard.android.fragments.QuestsFragment;
import com.supoved.questboard.android.fragments.RewardsFragment;

public class BoardActivity extends AppCompatActivity {

    protected DrawerLayout mDrawerLayout;
    protected ActionBarDrawerToggle mDrawerToggle;
    protected NavigationView mNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigation = (NavigationView) findViewById(R.id.navigation_view);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        final ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Checking if the item is in checked state or not, if not make it in checked state
                if(menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                mDrawerLayout.closeDrawers();

                onNavigationDrawerItemSelected(menuItem.getItemId());
                return true;
            }
        });

        onNavigationDrawerItemSelected(R.id.navigation_menu_quests);
    }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_board, menu);
        return true;
    }

    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager(); // For AppCompat use getSupportFragmentManager
        switch(position) {
            default:
            case R.id.navigation_menu_quests:
                fragment = new QuestsFragment();
                break;
            case R.id.navigation_menu_rewards:
                fragment = new RewardsFragment();
                break;
        }

        fragmentManager.beginTransaction()
                .replace(R.id.main_content_fragment, fragment)
                .commit();
    }
}
