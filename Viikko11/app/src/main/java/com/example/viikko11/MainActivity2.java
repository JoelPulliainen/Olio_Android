package com.example.viikko11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;


import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;


import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;
    NavigationView navigationView;
    Switch aSwitch;
    EditText width;
    EditText font;
    EditText height;
    EditText lines;
    EditText displayText;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        aSwitch = (Switch) findViewById(R.id.switch1);
        if (Helper.getInstance().getState() == true) {
            aSwitch.setChecked(true);
        }
        if (Helper.getInstance().getState() == false) {
            aSwitch.setChecked(false);
        }
        width = (EditText) findViewById(R.id.editWidth);
        height = (EditText) findViewById(R.id.editHeight);
        font = (EditText) findViewById(R.id.editFont);
        lines = (EditText) findViewById(R.id.editLines);
        displayText = (EditText) findViewById(R.id.editDPText);
        spinner = (Spinner) findViewById(R.id.spinner);
        aSwitch.setChecked(Helper.getInstance().getState());
        nDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nToggle = new ActionBarDrawerToggle(this, nDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView =findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        ArrayList<String> Languages = new ArrayList<String>();
        String[] languages = {"English", "Svenska", "Suomi"};
        for (int i = 0; i<3; i++) {
            Languages.add(languages[i]);
        }
        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Languages);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


    }

    public void changeLanguage(View v){
        LanguageChanger.changeLocale(this.getResources(), spinner.getSelectedItem().toString());
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Helper.getInstance().setState(aSwitch.isChecked());
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);

            intent.putExtra("key", aSwitch.isChecked());
            intent.putExtra("width", width.getText().toString());
            intent.putExtra("height", height.getText().toString());
            intent.putExtra("font", font.getText().toString());
            intent.putExtra("lines", lines.getText().toString());
            Helper.getInstance().setDP(displayText.getText().toString());
            startActivity(intent);

        } else if (id == R.id.nav_settings) {

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