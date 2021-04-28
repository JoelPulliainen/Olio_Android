package com.example.myht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// Adapter for WasteEntry objects so they can be used in a custom listview

public class WasteAdapter extends ArrayAdapter<WasteEntry> {
    public WasteAdapter(Context context, ArrayList<WasteEntry> entry) {
        super(context, 0, entry);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WasteEntry wasteEntry = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_waste, parent, false);
        }
        TextView tvDateW = (TextView) convertView.findViewById(R.id.tvDateW);
        TextView tvTotalW = (TextView) convertView.findViewById(R.id.tvTotalW);

        tvDateW.setText(wasteEntry.dateCreated);
        tvTotalW.setText(wasteEntry.getTotal());

        return convertView;
    }
}