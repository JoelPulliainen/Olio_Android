package com.example.myht;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;

import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class GraphDialog extends AppCompatDialogFragment {

//Create the graphs in a dialog

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View mView = getActivity().getLayoutInflater().inflate(R.layout.graph_dialog,null);
        StrictMode.ThreadPolicy policy = (new StrictMode.ThreadPolicy.Builder()).permitAll().build();
        StrictMode.setThreadPolicy(policy);
        double x = 0,y;
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        GraphView graph = (GraphView) mView.findViewById(R.id.graph);
        DataPoint[] points = new DataPoint[100];

        // Check what data the user wants to use using a helper class and then create the graphs

        if (Helper.getInstance().getData1().equals("Weight")) {
            builder.setTitle("Weight entry");
            ArrayList<WeightEntry> array = new ArrayList<>();
            array = EntryManager.getInstance().entryReaderWeight("Weight", getActivity());
            if (array.size() == 0) {
                Toast.makeText(getActivity(), "There is no data", Toast.LENGTH_SHORT).show();
            } else {
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
                for (int i = 0; i < array.size(); i++) {
                    y = array.get(i).getWeightData();
                    try {
                        x = formatter.parse(array.get(i).dateCreated).getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    series.appendData(new DataPoint(x, y), true, 100);
                }
                graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
                graph.getViewport().setScalable(true);
                graph.getViewport().setScalableY(true);
                try {
                    graph.getViewport().setMinX(formatter.parse(array.get(0).dateCreated).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    graph.getViewport().setMaxX(formatter.parse(array.get(array.size() - 1).dateCreated).getTime())
                    ;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                graph.getViewport().setXAxisBoundsManual(true);
                graph.addSeries(series);
            }
        }

        else if (Helper.getInstance().getData1().equals("Consumption")) {
            ArrayList<ConsumptionEntry> array = new ArrayList<>();
            array = EntryManager.getInstance().entryReaderConsumption("Consumption", getActivity());
            if (array.size() == 0) {
                Toast.makeText(getActivity(), "There is no data", Toast.LENGTH_SHORT).show();
            } else {
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
                for (int i = 0; i < array.size(); i++) {
                    y = array.get(i).getTotalData();
                    try {
                        x = formatter.parse(array.get(i).dateCreated).getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    series.appendData(new DataPoint(x, y), true, 100);
                }
                graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
                graph.getViewport().setScalable(true);
                graph.getViewport().setScalableY(true);
                try {
                    graph.getViewport().setMinX(formatter.parse(array.get(0).dateCreated).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    graph.getViewport().setMaxX(formatter.parse(array.get(array.size() - 1).dateCreated).getTime())
                    ;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                graph.getViewport().setXAxisBoundsManual(true);
                graph.addSeries(series);
            }
        }

        else if (Helper.getInstance().getData1().equals("Food")) {
            ArrayList<FoodEntry> array = new ArrayList<>();
            array = EntryManager.getInstance().entryReaderFood("Food", getActivity());
            if (array.size() == 0) {
                Toast.makeText(getActivity(), "There is no data", Toast.LENGTH_SHORT).show();
            } else {
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
                for (int i = 0; i < array.size(); i++) {
                    y = array.get(i).getTotalData();
                    try {
                        x = formatter.parse(array.get(i).dateCreated).getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    series.appendData(new DataPoint(x, y), true, 100);
                }
                graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
                graph.getViewport().setScalable(true);
                graph.getViewport().setScalableY(true);
                try {
                    graph.getViewport().setMinX(formatter.parse(array.get(0).dateCreated).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    graph.getViewport().setMaxX(formatter.parse(array.get(array.size() - 1).dateCreated).getTime())
                    ;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                graph.getViewport().setXAxisBoundsManual(true);
                graph.addSeries(series);

            }
        }

        else if (Helper.getInstance().getData1().equals("Transport")) {
            ArrayList<TransportEntry> array = new ArrayList<>();
            array = EntryManager.getInstance().entryReaderTransport("Transport", getActivity());
            if (array.size() == 0) {
                Toast.makeText(getActivity(), "There is no data", Toast.LENGTH_SHORT).show();
            } else {
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
                for (int i = 0; i < array.size(); i++) {
                    y = array.get(i).getTotalData();
                    try {
                        x = formatter.parse(array.get(i).dateCreated).getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    series.appendData(new DataPoint(x, y), true, 100);
                }
                graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
                graph.getViewport().setScalable(true);
                graph.getViewport().setScalableY(true);
                try {
                    graph.getViewport().setMinX(formatter.parse(array.get(0).dateCreated).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    graph.getViewport().setMaxX(formatter.parse(array.get(array.size() - 1).dateCreated).getTime())
                    ;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                graph.getViewport().setXAxisBoundsManual(true);
                graph.addSeries(series);
            }
        }

        else if (Helper.getInstance().getData1().equals("Housing")) {
            ArrayList<HousingEntry> array = new ArrayList<>();
            array = EntryManager.getInstance().entryReaderHousing("Housing", getActivity());
            if (array.size() == 0) {
                Toast.makeText(getActivity(), "There is no data", Toast.LENGTH_SHORT).show();
            } else {
                LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
                for (int i = 0; i < array.size(); i++) {
                    y = array.get(i).getTotalData();
                    try {
                        x = formatter.parse(array.get(i).dateCreated).getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    series.appendData(new DataPoint(x, y), true, 100);
                }
                graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
                graph.getViewport().setScalable(true);
                graph.getViewport().setScalableY(true);
                try {
                    graph.getViewport().setMinX(formatter.parse(array.get(0).dateCreated).getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                try {
                    graph.getViewport().setMaxX(formatter.parse(array.get(array.size() - 1).dateCreated).getTime())
                    ;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                graph.getViewport().setXAxisBoundsManual(true);
                graph.addSeries(series);
            }
        }

        else if (Helper.getInstance().getData1().equals("Waste")) {
            ArrayList<WasteEntry> array = new ArrayList<>();
            array = EntryManager.getInstance().entryReaderWaste("Waste", getActivity());
            LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
            for (int i = 0; i < array.size(); i++) {
                y = array.get(i).getTotalData();
                try {
                    x = formatter.parse(array.get(i).dateCreated).getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                series.appendData(new DataPoint(x,y),true, 100);
            }
            graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
            graph.getViewport().setScalable(true);
            graph.getViewport().setScalableY(true);
            try {
                graph.getViewport().setMinX(formatter.parse(array.get(0).dateCreated).getTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                graph.getViewport().setMaxX(formatter.parse(array.get(array.size()-1).dateCreated).getTime())
                ;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            graph.getViewport().setXAxisBoundsManual(true);
            graph.addSeries(series);

        }



       builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }

        });


        builder.setView(mView);
        return builder.create();
    }
}
