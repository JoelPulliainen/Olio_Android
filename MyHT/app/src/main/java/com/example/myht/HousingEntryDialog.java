package com.example.myht;

import android.os.StrictMode;
import android.os.Bundle;
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

// Creates an dialog for a HousingEntry.

public class HousingEntryDialog extends AppCompatDialogFragment {

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
    Switch phswitch;
    Switch ahpswitch;
    Switch ahsgswitch;
    Switch ahwswitch;
    Spinner htspinner;
    Spinner hmspinner;
    Spinner whspinner;




    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View mView = getActivity().getLayoutInflater().inflate(R.layout.housing_entry_dialog,null);
        StrictMode.ThreadPolicy policy = (new StrictMode.ThreadPolicy.Builder()).permitAll().build();
        StrictMode.setThreadPolicy(policy);
        builder.setTitle("Housing entry");
        builder.setMessage("Please fill every column");

        phswitch = (Switch) mView.findViewById(R.id.isprimaryhouse);
        ahpswitch = (Switch) mView.findViewById(R.id.additionalHeatPump);
        ahsgswitch = (Switch) mView.findViewById(R.id.additionalHeatSelfGen);
        ahwswitch = (Switch) mView.findViewById(R.id.additionalHeatWood);

        text = (EditText) mView.findViewById(R.id.familysize);
        text2 = (EditText) mView.findViewById(R.id.buildyear);
        text3 = (EditText) mView.findViewById(R.id.Area);
        text4 = (EditText) mView.findViewById(R.id.floorcount);
        text5 = (EditText) mView.findViewById(R.id.eConsumption);
        text6 = (EditText) mView.findViewById(R.id.gEp);
        text7 = (EditText) mView.findViewById(R.id.aPurchase);
        text8 = (EditText) mView.findViewById(R.id.fPurchases);
        text9 = (EditText) mView.findViewById(R.id.rPurchases);
        text10 = (EditText) mView.findViewById(R.id.mPurchases);

        htspinner = (Spinner) mView.findViewById(R.id.housetypeSpinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.housetypeList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        htspinner.setAdapter(arrayAdapter);

        hmspinner = (Spinner) mView.findViewById(R.id.heatingmodeSpinner);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.heatingmodeList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hmspinner.setAdapter(arrayAdapter1);

        whspinner = (Spinner) mView.findViewById(R.id.winterHeatingSpinner);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.winterheatingList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        whspinner.setAdapter(arrayAdapter2);

        // Read all the data from the user

        builder.setPositiveButton("Submit", (dialog, which) -> {
            HousingURLMaker.getInstance().setHouseType(htspinner.getSelectedItem().toString());
            HousingURLMaker.getInstance().setHeatingMode(hmspinner.getSelectedItem().toString());
            HousingURLMaker.getInstance().setWinterHeating(whspinner.getSelectedItem().toString());
            HousingURLMaker.getInstance().setIsprimaryhouse(phswitch.isChecked());
            HousingURLMaker.getInstance().setAdditionalHeatPump(ahpswitch.isChecked());
            HousingURLMaker.getInstance().setAdditionalHeatSelfGen(ahsgswitch.isChecked());
            HousingURLMaker.getInstance().setAdditionalHeatWood(ahwswitch.isChecked());
            HousingURLMaker.getInstance().setFamilysize(text.getText().toString());
            HousingURLMaker.getInstance().setBuildyear(text2.getText().toString());
            HousingURLMaker.getInstance().setArea(text3.getText().toString());
            HousingURLMaker.getInstance().setFloorcount(text4.getText().toString());
            HousingURLMaker.getInstance().seteConsumption(text5.getText().toString());
            HousingURLMaker.getInstance().setgEp(text6.getText().toString());
            HousingURLMaker.getInstance().setaPurchase(text7.getText().toString());
            HousingURLMaker.getInstance().setfPurchases(text8.getText().toString());
            HousingURLMaker.getInstance().setrPurchases(text9.getText().toString());
            HousingURLMaker.getInstance().setmPurchases(text10.getText().toString());
            EntryManager.getInstance().entryWriter(HousingURLMaker.getInstance().URLquary(), "Housing", getActivity());
            Toast.makeText(getActivity(), "Entry Saved", Toast.LENGTH_SHORT).show();

            dialog.dismiss();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
        builder.setView(mView);
        return builder.show();
    }
}
