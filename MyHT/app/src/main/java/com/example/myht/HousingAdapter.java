package com.example.myht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// Adapter for HousingEntry objects so they can be used in a custom listview

public class HousingAdapter extends ArrayAdapter<HousingEntry> {
    public HousingAdapter(Context context, ArrayList<HousingEntry> entry) {
        super(context, 0, entry);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HousingEntry housingEntry = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_housing, parent, false);
        }
        TextView tvDateH = (TextView) convertView.findViewById(R.id.tvDateH);
        TextView tvElectricity = (TextView) convertView.findViewById(R.id.tvElectricity);
        TextView tvHeating = (TextView) convertView.findViewById(R.id.tvHeating);
        TextView tvInfrastructure = (TextView) convertView.findViewById(R.id.tvInfrastructure);
        TextView tvPurchases = (TextView) convertView.findViewById(R.id.tvPurchases);
        TextView tvTotalH = (TextView) convertView.findViewById(R.id.tvTotalH);

        tvDateH.setText(housingEntry.dateCreated);
        tvElectricity.setText(housingEntry.getElectricity());
        tvHeating.setText(housingEntry.getHeating());
        tvInfrastructure.setText(housingEntry.getInfrastructure());
        tvPurchases.setText(housingEntry.getPurchases());
        tvTotalH.setText(housingEntry.getTotal());

        return convertView;
    }
}