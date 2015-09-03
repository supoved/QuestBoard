package com.supoved.questboard.android.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.supoved.questboard.R;
import com.supoved.questboard.android.adapters.QuestArrayAdapter;
import com.supoved.questboard.data.QuestStorage;
import com.supoved.questboard.data.models.Quest;

public class ActiveQuestsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.quests_active_fragment, container, false);

        this.init(view);

        return view;
    }

    private void init(View view) {
        Quest[] quests = new QuestStorage().getActiveQuests();

        ListView listView = (ListView) view.findViewById(R.id.list);
        listView.setAdapter(new QuestArrayAdapter(view.getContext(), quests));
    }
}
