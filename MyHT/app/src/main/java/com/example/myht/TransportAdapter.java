package com.example.myht;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// Adapter for TransportEntry objects so they can be used in a custom listview

public class TransportAdapter extends ArrayAdapter<TransportEntry> {
    public TransportAdapter(Context context, ArrayList<TransportEntry> entry) {
        super(context, 0, entry);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TransportEntry transportEntry = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_transport, parent, false);
        }
        TextView tvDateT = (TextView) convertView.findViewById(R.id.tvDateT);
        TextView tvBoat = (TextView) convertView.findViewById(R.id.tvBoat);
        TextView tvMotorcycle = (TextView) convertView.findViewById(R.id.tvMotorcycle);
        TextView tvFlight = (TextView) convertView.findViewById(R.id.tvFlight);
        TextView tvCruise = (TextView) convertView.findViewById(R.id.tvCruise);
        TextView tvTrain = (TextView) convertView.findViewById(R.id.tvTrain);
        TextView tvBus = (TextView) convertView.findViewById(R.id.tvBus);
        TextView tvOther = (TextView) convertView.findViewById(R.id.tvOther);
        TextView tvPTTotal = (TextView) convertView.findViewById(R.id.tvPTTotal);
        TextView tvPTotalT = (TextView) convertView.findViewById(R.id.tvTotalT);

        tvDateT.setText(transportEntry.dateCreated);
        tvBoat.setText(transportEntry.getBoat());
        tvMotorcycle.setText(transportEntry.getMotorcycle());
        tvFlight.setText(transportEntry.getFlight());
        tvCruise.setText(transportEntry.getCruise());
        tvTrain.setText(transportEntry.getTrain());
        tvBus.setText(transportEntry.getBus());
        tvOther.setText(transportEntry.getOther());
        tvPTTotal.setText(transportEntry.getTtal());
        tvPTotalT.setText(transportEntry.getTotal());
        return convertView;
    }
}