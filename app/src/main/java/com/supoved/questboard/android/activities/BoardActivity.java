package com.supoved.questboard.android.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.inject.Inject;
import com.supoved.questboard.R;
import com.supoved.questboard.android.adapters.QuestArrayAdapter;
import com.supoved.questboard.data.QuestStorage;
import com.supoved.questboard.data.models.Quest;

import roboguice.activity.RoboActivity;
import roboguice.activity.RoboListActivity;
import roboguice.inject.*;

public class BoardActivity extends RoboListActivity {

    @Inject QuestStorage questStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new QuestArrayAdapter(this, questStorage.getActiveQuests()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_board, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
