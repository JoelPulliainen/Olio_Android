package com.example.viikko9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Context context = null;
    RecyclerView recyclerView;
    Spinner spinner;
    EditText input_date;
    EditText input_stime;
    EditText input_etime;
    EditText input_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = MainActivity.this;
        setContentView(R.layout.activity_main);
        input_date = (EditText) findViewById(R.id.editTextDate);
        input_stime = (EditText) findViewById(R.id.editTextTime);
        input_etime = (EditText) findViewById(R.id.editTextTime2);
        input_name = (EditText) findViewById(R.id.editTextMovieName);
        spinner = (Spinner) findViewById(R.id.spinner);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        ReadXML.getInstance().Read();

        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ReadXML.getInstance().getNames());
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                int i = parent.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    public void lookfor(View v) {
        int i = spinner.getSelectedItemPosition();
        int etime, stime;
        String name = input_name.getText().toString();
        String date = input_date.getText().toString();
        if (input_stime.getText().toString().replaceAll(":", "").equals("")) {
            stime = 0;
        }  else {
            stime = Integer.parseInt(input_stime.getText().toString().replaceAll(":",""));
        }
        if (input_etime.getText().toString().replaceAll(":", "").equals("")) {
            etime = 240000;
        }  else {
            etime = Integer.parseInt(input_etime.getText().toString().replaceAll(":",""));
        }

        ReadXML.getInstance().Movies(name, ReadXML.getInstance().Theaters.get(i).getId(), date, stime, etime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(ReadXML.getInstance().Titles, ReadXML.getInstance().Times, ReadXML.getInstance().Areas);
        recyclerView.setAdapter(recyclerAdapter);
    }
}

