package com.supoved.questboard.android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.supoved.questboard.R;
import com.supoved.questboard.data.models.Quest;

public class QuestArrayAdapter extends ArrayAdapter<Quest> {
    private final Context context;
    private final Quest[] values;

    public QuestArrayAdapter(Context context, Quest[] values) {
        super(context, R.layout.quest_list_item, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.quest_list_item, parent, false);
        TextView titleView = (TextView) rowView.findViewById(R.id.title);
        TextView descriptionView = (TextView) rowView.findViewById(R.id.description);
        titleView.setText(values[position].title);
        descriptionView.setText(values[position].description);

        return rowView;
    }
}
