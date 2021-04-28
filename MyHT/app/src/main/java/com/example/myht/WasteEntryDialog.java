package com.example.myht;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

// Creates an dialog for a WasteEntry.

public class WasteEntryDialog extends AppCompatDialogFragment {
    Spinner spinner;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner5;
    Spinner spinner6;
    Spinner spinner7;
    Spinner spinner8;
    Spinner spinner9;



    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View mView = getActivity().getLayoutInflater().inflate(R.layout.waste_entry_dialog,null);
        StrictMode.ThreadPolicy policy = (new StrictMode.ThreadPolicy.Builder()).permitAll().build();
        StrictMode.setThreadPolicy(policy);
        builder.setTitle("Waste entry");
        builder.setMessage("Enter the frequency of sorting and a estimate how much waste you generate");


        spinner = (Spinner) mView.findViewById(R.id.bwSpinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.wasteChoiceList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner2 = (Spinner) mView.findViewById(R.id.cSpinner);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.wasteChoiceList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter2);

        spinner3 = (Spinner) mView.findViewById(R.id.eSpinner);
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.wasteChoiceList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(arrayAdapter3);

        spinner4 = (Spinner) mView.findViewById(R.id.gSpinner);
        ArrayAdapter<String> arrayAdapter4 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.wasteChoiceList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(arrayAdapter4);

        spinner5 = (Spinner) mView.findViewById(R.id.hSpinner);
        ArrayAdapter<String> arrayAdapter5 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.wasteChoiceList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(arrayAdapter5);

        spinner6 = (Spinner) mView.findViewById(R.id.mSpinner);
        ArrayAdapter<String> arrayAdapter6 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.wasteChoiceList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner6.setAdapter(arrayAdapter6);

        spinner7 = (Spinner) mView.findViewById(R.id.paSpinner);
        ArrayAdapter<String> arrayAdapter7 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.wasteChoiceList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(arrayAdapter7);

        spinner8 = (Spinner) mView.findViewById(R.id.plSpinner);
        ArrayAdapter<String> arrayAdapter8 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.wasteChoiceList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(arrayAdapter8);

        spinner9 = (Spinner) mView.findViewById(R.id.aeSpinner);
        ArrayAdapter<String> arrayAdapter9 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.estimateList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner9.setAdapter(arrayAdapter9);

        // Read all the data from the user

        builder.setPositiveButton("submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                WasteURLMaker.getInstance().setBioWaste(spinner.getSelectedItem().toString());
                WasteURLMaker.getInstance().setCarton(spinner2.getSelectedItem().toString());
                WasteURLMaker.getInstance().setElectronic(spinner3.getSelectedItem().toString());
                WasteURLMaker.getInstance().setGlass(spinner4.getSelectedItem().toString());
                WasteURLMaker.getInstance().setHazardous(spinner5.getSelectedItem().toString());
                WasteURLMaker.getInstance().setMetal(spinner6.getSelectedItem().toString());
                WasteURLMaker.getInstance().setPaper(spinner7.getSelectedItem().toString());
                WasteURLMaker.getInstance().setPlastic(spinner8.getSelectedItem().toString());
                WasteURLMaker.getInstance().setEstimate(spinner9.getSelectedItem().toString());

                EntryManager.getInstance().entryWriter(WasteURLMaker.getInstance().URLquary(), "Waste", getActivity());
                EntryManager.getInstance().entryReaderWaste("Waste", getActivity());
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
