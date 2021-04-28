package com.example.myht;

import android.os.StrictMode;
import android.content.DialogInterface;
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

// Creates an dialog for a FoodEntry.

public class FoodEntryDialog extends AppCompatDialogFragment {

    EditText text;
    EditText text2;
    EditText text3;
    EditText text4;
    EditText text5;
    EditText text6;
    EditText text7;
    EditText text8;
    EditText text9;
    Switch lcswitch;
    Spinner spinner;



    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View mView = getActivity().getLayoutInflater().inflate(R.layout.food_entry_dialog,null);
        StrictMode.ThreadPolicy policy = (new StrictMode.ThreadPolicy.Builder()).permitAll().build();
        StrictMode.setThreadPolicy(policy);
        builder.setTitle("Food entry");
        builder.setMessage("Enter percentages compared to the Finnish average consumption");

        lcswitch = (Switch) mView.findViewById(R.id.switch1);
        text = (EditText) mView.findViewById(R.id.editTextNumber);
        text2 = (EditText) mView.findViewById(R.id.editTextNumber2);
        text3 = (EditText) mView.findViewById(R.id.editTextNumber3);
        text4 = (EditText) mView.findViewById(R.id.editTextNumber4);
        text5 = (EditText) mView.findViewById(R.id.editTextNumber5);
        text6 = (EditText) mView.findViewById(R.id.editTextNumber6);
        text7 = (EditText) mView.findViewById(R.id.editTextNumber7);
        text8 = (EditText) mView.findViewById(R.id.editTextNumber8);
        text9 = (EditText) mView.findViewById(R.id.editTextNumber9);

        spinner = (Spinner) mView.findViewById(R.id.foodspinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.dietList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        // Read all the user Data

        builder.setPositiveButton("submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                FoodURLMaker.getInstance().setDiet(spinner.getSelectedItem().toString());
                FoodURLMaker.getInstance().setLow_carbon_diet(lcswitch.isChecked());
                FoodURLMaker.getInstance().setBeef(text.getText().toString());
                FoodURLMaker.getInstance().setFish(text2.getText().toString());
                FoodURLMaker.getInstance().setPp(text3.getText().toString());
                FoodURLMaker.getInstance().setDairy(text3.getText().toString());
                FoodURLMaker.getInstance().setCheese(text4.getText().toString());
                FoodURLMaker.getInstance().setCheese(text3.getText().toString());
                FoodURLMaker.getInstance().setEgg(text5.getText().toString());
                FoodURLMaker.getInstance().setWs(text6.getText().toString());
                FoodURLMaker.getInstance().setRestaurant(text7.getText().toString());
                EntryManager.getInstance().entryWriter(FoodURLMaker.getInstance().URLquary(), "Food", getActivity());
                EntryManager.getInstance().entryReaderFood("Food", getActivity());
                Toast.makeText(getActivity(), "Entry Saved", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }

        });

        // go back if the user chooses

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
