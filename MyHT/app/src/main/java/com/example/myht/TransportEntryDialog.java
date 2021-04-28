package com.example.myht;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

// Creates an dialog for a TransportEntry.

public class TransportEntryDialog extends AppCompatDialogFragment {

    EditText text;
    EditText text2;
    EditText text3;
    EditText text4;
    EditText text5;
    EditText text6;
    EditText text7;
    EditText text8;
    EditText text9;
    EditText text10;
    EditText text11;
    EditText text12;
    EditText text13;
    EditText text14;
    EditText text15;
    EditText text16;
    EditText text17;
    EditText text18;
    EditText text19;

    Switch eswitch;
    Spinner bspinner;



    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View mView = getActivity().getLayoutInflater().inflate(R.layout.transport_entry_dialog,null);
        StrictMode.ThreadPolicy policy = (new StrictMode.ThreadPolicy.Builder()).permitAll().build();
        StrictMode.setThreadPolicy(policy);
        builder.setTitle("Transport entry");
        builder.setMessage("Enter percentages compared to the Finnish average consumption");

        eswitch = (Switch) mView.findViewById(R.id.switch1);
        text = (EditText) mView.findViewById(R.id.editTextNumber);
        text2 = (EditText) mView.findViewById(R.id.editTextNumber2);
        text3 = (EditText) mView.findViewById(R.id.editTextNumber3);
        text4 = (EditText) mView.findViewById(R.id.editTextNumber4);
        text5 = (EditText) mView.findViewById(R.id.editTextNumber5);
        text6 = (EditText) mView.findViewById(R.id.editTextNumber6);
        text7 = (EditText) mView.findViewById(R.id.editTextNumber7);
        text8 = (EditText) mView.findViewById(R.id.editTextNumber8);
        text9 = (EditText) mView.findViewById(R.id.editTextNumber9);
        text10 = (EditText) mView.findViewById(R.id.editTextNumber10);
        text11 = (EditText) mView.findViewById(R.id.editTextNumber11);
        text12 = (EditText) mView.findViewById(R.id.editTextNumber12);
        text13 = (EditText) mView.findViewById(R.id.editTextNumber13);
        text14 = (EditText) mView.findViewById(R.id.editTextNumber14);
        text15 = (EditText) mView.findViewById(R.id.editTextNumber15);
        text16 = (EditText) mView.findViewById(R.id.editTextNumber16);
        text17 = (EditText) mView.findViewById(R.id.editTextNumber17);
        text18 = (EditText) mView.findViewById(R.id.editTextNumber18);
        text19 = (EditText) mView.findViewById(R.id.editTextNumber19);

        bspinner = (Spinner) mView.findViewById(R.id.boattypespinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.boattypeList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bspinner.setAdapter(arrayAdapter);

        // Read all the data from the user

        builder.setPositiveButton("submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


                TransportURLMaker.getInstance().setBoat_calc(eswitch.isChecked());
                TransportURLMaker.getInstance().setBoattype(bspinner.getSelectedItem().toString());
                TransportURLMaker.getInstance().setBfConsumption(text.getText().toString());
                TransportURLMaker.getInstance().setBuHours(text2.getText().toString());
                TransportURLMaker.getInstance().setbPower(text3.getText().toString());
                TransportURLMaker.getInstance().setBuCount(text4.getText().toString());
                TransportURLMaker.getInstance().setMfConsumption(text5.getText().toString());
                TransportURLMaker.getInstance().setMfDistance(text6.getText().toString());
                TransportURLMaker.getInstance().setCbDistance(text7.getText().toString());
                TransportURLMaker.getInstance().setCtDistance(text8.getText().toString());
                TransportURLMaker.getInstance().setbDistance(text9.getText().toString());
                TransportURLMaker.getInstance().settDistance(text10.getText().toString());
                TransportURLMaker.getInstance().setmDistance(text11.getText().toString());
                TransportURLMaker.getInstance().setTramDistance(text12.getText().toString());
                TransportURLMaker.getInstance().setcFlights(text13.getText().toString());
                TransportURLMaker.getInstance().seteFlights(text14.getText().toString());
                TransportURLMaker.getInstance().setfFlights(text15.getText().toString());
                TransportURLMaker.getInstance().setTcFlights(text16.getText().toString());
                TransportURLMaker.getInstance().setgCruises(text17.getText().toString());
                TransportURLMaker.getInstance().seteCruises(text18.getText().toString());
                TransportURLMaker.getInstance().setsCruises(text19.getText().toString());

                EntryManager.getInstance().entryWriter(TransportURLMaker.getInstance().URLquary(), "Transport", getActivity());
                EntryManager.getInstance().entryReaderTransport("Transport", getActivity());

                Toast.makeText(getActivity(), "Entry Saved", Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }

        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.setView(mView);
        return builder.create();
    }
}

