package com.example.myht;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

// Creates an dialog for ConsumptionEntry. ConsumptionEntryDialog was made to practice dynamically coding dialogs.

public class ConsumptionEntryDialog extends AppCompatDialogFragment {

    EditText editText;


    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LinearLayout linearLayout= new LinearLayout(getActivity());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ThreadPolicy policy = (new Builder()).permitAll().build();
        StrictMode.setThreadPolicy(policy);
        ScrollView scrollView = new ScrollView(getActivity());
        builder.setTitle("Consumption entry");
        builder.setMessage("Please enter everything in eur/month");

        /* Create the necessary EditTexts and switches */

        final EditText input_clothes = new EditText(getActivity());
        input_clothes.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        final Switch low_carbon_clothes = new Switch(getActivity());
        final EditText input_communications = new EditText(getActivity());
        input_clothes.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        final Switch low_carbon_communications = new Switch(getActivity());
        final EditText input_electronics = new EditText(getActivity());
        input_clothes.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        final Switch low_carbon_electronics = new Switch(getActivity());
        final EditText input_other = new EditText(getActivity());
        input_clothes.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        final Switch low_carbon_other = new Switch(getActivity());
        final EditText input_paper = new EditText(getActivity());
        input_clothes.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        final Switch low_carbon_paper = new Switch(getActivity());
        final EditText input_recreation = new EditText(getActivity());
        input_clothes.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        final Switch low_carbon_recreation = new Switch(getActivity());
        final EditText input_shoes = new EditText(getActivity());
        input_clothes.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        final Switch low_carbon_shoes = new Switch(getActivity());
        input_clothes.setHint("Money spent on clothing");
        low_carbon_clothes.setText("low carbon options?");
        input_communications.setHint("Money spent on communications");
        low_carbon_communications.setText("low carbon options?");
        input_electronics.setHint("Money spent on electronics");
        low_carbon_electronics.setText("low carbon options?");
        input_other.setHint("Money spent on other categories");
        low_carbon_other.setText("low carbon options?");
        input_paper.setHint("Money spent on paper");
        low_carbon_paper.setText("low carbon options");
        input_recreation.setHint("Money spent on recreation");
        low_carbon_recreation.setText("low carbon options?");
        input_shoes.setHint("Money spent on shoes");
        low_carbon_shoes.setText("low carbon options?");
        linearLayout.addView(input_clothes);
        linearLayout.addView(low_carbon_clothes);
        linearLayout.addView(input_communications);
        linearLayout.addView(low_carbon_communications);
        linearLayout.addView(input_electronics);
        linearLayout.addView(low_carbon_electronics);
        linearLayout.addView(input_other);
        linearLayout.addView(low_carbon_other);
        linearLayout.addView(input_paper);
        linearLayout.addView(low_carbon_paper);
        linearLayout.addView(input_recreation);
        linearLayout.addView(low_carbon_recreation);
        linearLayout.addView(input_shoes);
        linearLayout.addView(low_carbon_shoes);

        scrollView.addView(linearLayout);
        builder.setView(scrollView);

        // Read all the data user has given

        builder.setPositiveButton("submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ConsumptionURLMaker.getInstance().setClothes(input_clothes.getText().toString());
                ConsumptionURLMaker.getInstance().setLow_carbon_clothes(low_carbon_clothes.isChecked());
                ConsumptionURLMaker.getInstance().setCommunications(input_communications.getText().toString());
                ConsumptionURLMaker.getInstance().setLow_carbon_communications(low_carbon_communications.isChecked());
                ConsumptionURLMaker.getInstance().setElectronics(input_electronics.getText().toString());
                ConsumptionURLMaker.getInstance().setLow_carbon_electronics(low_carbon_electronics.isChecked());
                ConsumptionURLMaker.getInstance().setOther(input_other.getText().toString());
                ConsumptionURLMaker.getInstance().setLow_carbon_other(low_carbon_other.isChecked());
                ConsumptionURLMaker.getInstance().setPaper(input_paper.getText().toString());
                ConsumptionURLMaker.getInstance().setLow_carbon_paper(low_carbon_paper.isChecked());
                ConsumptionURLMaker.getInstance().setRecreation(input_recreation.getText().toString());
                ConsumptionURLMaker.getInstance().setLow_carbon_recreation(low_carbon_recreation.isChecked());
                ConsumptionURLMaker.getInstance().setShoes(input_shoes.getText().toString());
                ConsumptionURLMaker.getInstance().setLow_carbon_shoes(low_carbon_shoes.isChecked());
                EntryManager.getInstance().entryWriter(ConsumptionURLMaker.getInstance().URLquary(), "Consumption", getActivity());
                EntryManager.getInstance().entryReaderConsumption("Consumption", getActivity());
                Toast.makeText(getActivity(), "Entry Saved", Toast.LENGTH_SHORT).show();

                dialog.dismiss();
            }

        });

        // go back if user wants to

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                dialog.cancel();
            }
        });


        return builder.create();
    }
}
