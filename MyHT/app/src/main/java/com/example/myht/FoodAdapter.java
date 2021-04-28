package com.example.myht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// Adapter for FoodEntry objects so they can be used in a custom listview

public class FoodAdapter extends ArrayAdapter<FoodEntry> {
    public FoodAdapter(Context context, ArrayList<FoodEntry> entry) {
        super(context, 0, entry);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FoodEntry foodEntry = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_food, parent, false);
        }

        TextView tvDateF = (TextView) convertView.findViewById(R.id.tvDateF);
        TextView tvDairy = (TextView) convertView.findViewById(R.id.tvDairy);
        TextView tvMeat = (TextView) convertView.findViewById(R.id.tvMeat);
        TextView tvPlant = (TextView) convertView.findViewById(R.id.tvPlant);
        TextView tvRestaurant = (TextView) convertView.findViewById(R.id.tvRestaurant);
        TextView tvTotalF = (TextView) convertView.findViewById(R.id.tvTotalF);

        tvDateF.setText(foodEntry.dateCreated);
        tvDairy.setText(foodEntry.getDairy());
        tvMeat.setText(foodEntry.getMeat());
        tvPlant.setText(foodEntry.getPlant());
        tvRestaurant.setText(foodEntry.getRestaurant());
        tvTotalF.setText(foodEntry.getTotal());

        return convertView;
    }
}