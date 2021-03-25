package com.example.viikko11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;
    NavigationView navigationView;
    EditText editText;
    TextView textView;
    TextView DP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editTextInput);
        textView = (TextView) findViewById(R.id.textViewOutput);
        DP = (TextView) findViewById(R.id.textView2);
        nDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nToggle = new ActionBarDrawerToggle(this, nDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView =findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        DP.setText(Helper.getInstance().getDP());
        if (getIntent().getStringExtra("font") != null) {
            if (getIntent().getStringExtra("font").trim().length() > 0) {
                textView.setTextSize(Float.parseFloat(getIntent().getStringExtra("font")));
            }
        }
        if (getIntent().getStringExtra("height") != null) {
            if (getIntent().getStringExtra("height").trim().length() > 0) {
                textView.setHeight(Integer.parseInt(getIntent().getStringExtra("height")));
            }
        }
        if (getIntent().getStringExtra("width") != null) {
            if (getIntent().getStringExtra("width").trim().length() > 0) {
                textView.setWidth(Integer.parseInt(getIntent().getStringExtra("width")));
            }
        }

        if (getIntent().getStringExtra("lines") != null) {
            if (getIntent().getStringExtra("lines").trim().length() > 0) {
                textView.setLines(Integer.parseInt(getIntent().getStringExtra("lines")));
            }
        }
        boolean my_switch = getIntent().getBooleanExtra("key", false);
            if (!my_switch) {
                editText.setEnabled(false);
                textView.setText(Helper.getInstance().getText());
            } else {
                editText.setEnabled(true);
            }

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_settings) {
            Helper.getInstance().setText(editText.getText().toString());
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
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