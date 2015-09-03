package com.supoved.questboard.android.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.supoved.questboard.R;

public class QuestsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.quests_fragment, container, false);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getText(R.string.title_active_quests)));
        tabLayout.addTab(tabLayout.newTab().setText(getResources().getText(R.string.title_available_quests)));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                onTabItemSelected(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                onTabItemSelected(tab.getPosition());
            }
        });

        onTabItemSelected(0);
        return view;
    }

    public void onTabItemSelected(int position) {
        // update the main content by replacing fragments
        Fragment fragment;
        FragmentManager fragmentManager = this.getFragmentManager(); // For AppCompat use getSupportFragmentManager
        switch(position) {
            default:
            case 0:
                fragment = new ActiveQuestsFragment();
                break;
            case 1:
                fragment = new AvailableQuestsFragment();
                break;
        }

        fragmentManager.beginTransaction()
                .replace(R.id.tab_content_fragment, fragment)
                .commit();
    }
}
