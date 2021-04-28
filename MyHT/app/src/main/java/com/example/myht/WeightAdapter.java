package com.example.myht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// Adapter for WeightEntry objects so they can be used in a custom listview

public class WeightAdapter extends ArrayAdapter<WeightEntry> {
    public WeightAdapter(Context context, ArrayList<WeightEntry> entry) {
        super(context, 0, entry);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WeightEntry weightEntry = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_weight, parent, false);
        }
        TextView tvDate1 = (TextView) convertView.findViewById(R.id.tvDate1);
        TextView tvWeight = (TextView) convertView.findViewById(R.id.tvWeight);

        tvDate1.setText(weightEntry.dateCreated);
        tvWeight.setText(weightEntry.getWeight());

        return convertView;
    }
}