package com.example.myht;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;


import java.util.ArrayList;

// Creates the activity for the results

public class ResultsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;
    NavigationView navigationView;
    Spinner spinner;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        listView = (ListView) findViewById(R.id.ListView);
        nDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nToggle = new ActionBarDrawerToggle(this, nDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        spinner = (Spinner) findViewById(R.id.DataSpinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ResultsActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.dataList));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

    }

    // Make the graph Store spinners position to helper

    public void makeGraphOpen(View v) {
        Helper.getInstance().setData1(spinner.getSelectedItem().toString());
        openGraphDialog();
    }

    public void openGraphDialog() {
        GraphDialog graphDialog = new GraphDialog();
        graphDialog.show(getSupportFragmentManager(), "example graphDialog");
    }

    // Create the log in custon Listview

    public void openChart(View v) {
        if (spinner.getSelectedItem().toString().equals("Consumption")) {
            ArrayList<ConsumptionEntry> a = new ArrayList<>();
            a = EntryManager.getInstance().entryReaderConsumption(spinner.getSelectedItem().toString(), getApplicationContext());
            ConsumptionAdapter adapter2 = new ConsumptionAdapter(getApplicationContext(), a);
            listView.setAdapter(adapter2);
        } else if (spinner.getSelectedItem().toString().equals("Food")) {
            ArrayList<FoodEntry> a = new ArrayList<>();
            a = EntryManager.getInstance().entryReaderFood(spinner.getSelectedItem().toString(), getApplicationContext());
            FoodAdapter adapter2 = new FoodAdapter(getApplicationContext(), a);
            listView.setAdapter(adapter2);
        } else if (spinner.getSelectedItem().toString().equals("Housing")) {
            ArrayList<HousingEntry> a = new ArrayList<>();
            a = EntryManager.getInstance().entryReaderHousing(spinner.getSelectedItem().toString(), getApplicationContext());
            HousingAdapter adapter2 = new HousingAdapter(getApplicationContext(), a);
            listView.setAdapter(adapter2);
        } else if (spinner.getSelectedItem().toString().equals("Transport")) {
            ArrayList<TransportEntry> a = new ArrayList<>();
            a = EntryManager.getInstance().entryReaderTransport(spinner.getSelectedItem().toString(), getApplicationContext());
            TransportAdapter adapter2 = new TransportAdapter(getApplicationContext(), a);
            listView.setAdapter(adapter2);
        } else if (spinner.getSelectedItem().toString().equals("Waste")) {
            ArrayList<WasteEntry> a = new ArrayList<>();
            a = EntryManager.getInstance().entryReaderWaste(spinner.getSelectedItem().toString(), getApplicationContext());
            WasteAdapter adapter2 = new WasteAdapter(getApplicationContext(), a);
            listView.setAdapter(adapter2);
        } else if (spinner.getSelectedItem().toString().equals("Weight")) {
            ArrayList<WeightEntry> a = new ArrayList<>();
            a = EntryManager.getInstance().entryReaderWeight(spinner.getSelectedItem().toString(), getApplicationContext());
            WeightAdapter adapter2 = new WeightAdapter(getApplicationContext(), a);
            listView.setAdapter(adapter2);
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(ResultsActivity.this, EntryActivity.class);
            startActivity(intent);
        }

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(nToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}