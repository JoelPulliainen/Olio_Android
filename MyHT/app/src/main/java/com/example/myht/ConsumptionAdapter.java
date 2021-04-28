package com.example.myht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// Adapter for ConsumptionEntry objects so they can be used in a custom listview

public class ConsumptionAdapter extends ArrayAdapter<ConsumptionEntry> {
    public ConsumptionAdapter(Context context, ArrayList<ConsumptionEntry> entry) {
       super(context, 0, entry);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ConsumptionEntry consumptionEntry = getItem(position);
       if (convertView == null) {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_consumption, parent, false);
       }
       TextView tvDate = (TextView) convertView.findViewById(R.id.tvDate);
       TextView tvClothing = (TextView) convertView.findViewById(R.id.tvClothing);
       TextView tvCommunications = (TextView) convertView.findViewById(R.id.tvCommunications);
       TextView tvElectronics = (TextView) convertView.findViewById(R.id.tvElectronics);
       TextView tvOther = (TextView) convertView.findViewById(R.id.tvOther);
       TextView tvPaper = (TextView) convertView.findViewById(R.id.tvPaper);
       TextView tvRecreation = (TextView) convertView.findViewById(R.id.tvRecreation);
       TextView tvShoes = (TextView) convertView.findViewById(R.id.tvShoes);
       TextView tvTotal = (TextView) convertView.findViewById(R.id.tvTotal);


       tvDate.setText(consumptionEntry.dateCreated);
       tvClothing.setText(consumptionEntry.getClothing());
       tvCommunications.setText(consumptionEntry.getCommunications());
       tvElectronics.setText(consumptionEntry.getElectronics());
       tvOther.setText(consumptionEntry.getOther());
       tvPaper.setText(consumptionEntry.getPaper());
       tvRecreation.setText(consumptionEntry.getRecreation());
       tvShoes.setText(consumptionEntry.getShoes());
       tvTotal.setText(consumptionEntry.getTotal());

       return convertView;
   }
}