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

import com.google.android.material.navigation.NavigationView;

// Creates the EntryActivity where user can make entries.

public class EntryActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        nDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nToggle = new ActionBarDrawerToggle(this, nDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView =findViewById(R.id.nav_view);
        Context context;
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void makeConsumptionEntry(View v) {
        openConsumptionDialog();
    }

    public void openConsumptionDialog() {
        ConsumptionEntryDialog consumptionEntryDialog = new ConsumptionEntryDialog();
        consumptionEntryDialog.show(getSupportFragmentManager(), "example consumptionEntryDialog");
    }

    public void makeFoodEntry(View v) {
        openFoodDialog();
    }

    public void openFoodDialog() {
        FoodEntryDialog foodEntryDialog = new FoodEntryDialog();
        foodEntryDialog.show(getSupportFragmentManager(), "example foodEntryDialog");
    }

    public void makeHousingEntry(View v) {
        openHousingDialog();
    }

    public void openHousingDialog() {
        HousingEntryDialog housingEntryDialog = new HousingEntryDialog();
        housingEntryDialog.show(getSupportFragmentManager(), "example housingEntryDialog");
    }

    public void makeTransportEntry(View v) {
        openTransportDialog();
    }

    public void openTransportDialog() {
        TransportEntryDialog transportEntryDialog = new TransportEntryDialog();
        transportEntryDialog.show(getSupportFragmentManager(), "example transportEntryDialog");
    }

   public void makeWasteEntry(View v) {
        openWasteDialog();
    }

    public void openWasteDialog() {
        WasteEntryDialog wasteEntryDialog = new WasteEntryDialog();
        wasteEntryDialog.show(getSupportFragmentManager(), "example wasteEntryDialog");
    }

    public void makeWeightEntry(View v) {
        openWeightDialog();
    }

    public void openWeightDialog() {
        WeightEntryDialog weightEntryDialog = new WeightEntryDialog();
        weightEntryDialog.show(getSupportFragmentManager(), "example weightEntryDialog");
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(EntryActivity.this, MainActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_results) {
            Intent intent = new Intent(EntryActivity.this, ResultsActivity.class);
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
