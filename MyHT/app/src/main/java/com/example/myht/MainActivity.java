package com.example.myht;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

/* MainActivity creates the MainActivity */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        nToggle = new ActionBarDrawerToggle(this, nDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

    }
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(MainActivity.this, EntryActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_results) {
            Intent intent = new Intent(MainActivity.this, ResultsActivity.class);
            startActivity(intent);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (nToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}