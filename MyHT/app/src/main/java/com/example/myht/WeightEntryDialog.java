package com.example.myht;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

// Creates an dialog for a WasteEntry.

public class WeightEntryDialog extends AppCompatDialogFragment {

    EditText text;

    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View mView = getActivity().getLayoutInflater().inflate(R.layout.weight_entry_dialog,null);
        StrictMode.ThreadPolicy policy = (new StrictMode.ThreadPolicy.Builder()).permitAll().build();
        StrictMode.setThreadPolicy(policy);
        builder.setTitle("Weight entry");
        builder.setMessage("Please enter your current weight");
        text = (EditText) mView.findViewById(R.id.editTextWeight);

        // Read all the data from the user

        builder.setPositiveButton("submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (!text.getText().toString().equals("")) {
                    float weight = Float.parseFloat(text.getText().toString());
                    EntryManager.getInstance().weightEntryWriter(weight,"Weight", getActivity());
                    Toast.makeText(getActivity(), "Entry Saved", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(getActivity(), "Invalid input", Toast.LENGTH_SHORT).show();
                }
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
