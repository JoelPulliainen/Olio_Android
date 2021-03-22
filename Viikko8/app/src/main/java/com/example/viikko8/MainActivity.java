package com.example.viikko8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context context = null;

    TextView text;
    TextView text2;
    TextView text3;
    TextView text4;
    EditText Ntext;
    SeekBar seekBar;
    Spinner spinner;
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = MainActivity.this;
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        text2 = (TextView) findViewById(R.id.textView2);
        text3 = (TextView) findViewById(R.id.textView3);
        text4 = (TextView) findViewById(R.id.textView6);
        Ntext = (EditText) findViewById(R.id.NumberText);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        Ntext.setText(String.valueOf(seekBar.getProgress()));
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        System.out.println(context.getFilesDir());

        BottleDispenser.getInstance().fillArrayList();

        ArrayList<Double> Sizes = new ArrayList<Double>();
        Sizes.add(0.5);Sizes.add(1.0);Sizes.add(1.5);
        ArrayList<String> Sodanames = new ArrayList<String>();
        String[] names = {"Pepsi Max","Pepsi","Coca-Cola Zero","Coca-Cola","Fanta Zero"};
        for (int i = 0; i<5; i++) {
            Sodanames.add(names[i]);
        }


        ArrayAdapter dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Sodanames);
        ArrayAdapter dataAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Sizes);

        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                int i = parent.getSelectedItemPosition();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
                int i = spinner.getSelectedItemPosition();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressvalue = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressvalue = progress;
                Ntext.setText(String.valueOf(progressvalue));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                progressvalue = seekBar.getProgress();
                Ntext.setText(String.valueOf(progressvalue));
            }
        });

    }
    public void cashIN(View v) {
        int s = seekBar.getProgress();
        BottleDispenser.getInstance().addMoney(s);
        text.setText("Money Added");
        seekBar.setProgress(0);
        text2.setText("");
    }
    public void cashOUT(View v) {
        text2.setText("Money returned " +  BottleDispenser.getInstance().getMoney());
        text.setText("");
        BottleDispenser.getInstance().returnMoney();
    }
    public void buy(View v) {
        String a = spinner.getSelectedItem().toString();
        Double b = (Double) spinner2.getSelectedItem();
        int index = 0;
        for (Bottle name : BottleDispenser.getInstance().Bottles) {
            if (a == name.getName()) {
                if (b == name.getSize()) {
                    if (BottleDispenser.getInstance().getMoney() >= name.getPrize()) {
                        text3.setText("Soda: " + a + " Size: " + b + " comes out");
                        BottleDispenser.getInstance().buyBottle1(index);
                        return;
                    } else {
                        text3.setText("In stock, but not enough money");
                    }
                }
            } index++;
        }
        text3.setText("Out of Stock");
    }

    public void printReceipt(View v) {

        if (BottleDispenser.getInstance().lastpurchase.getName() != null) {
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("Kuitti.txt", Context.MODE_PRIVATE));
                outputStreamWriter.write("Receipt\n" + BottleDispenser.getInstance().lastpurchase.getName() + "\n" + BottleDispenser.getInstance().lastpurchase.getSize() + " l\n" + BottleDispenser.getInstance().lastpurchase.getPrize() + "e");
                outputStreamWriter.close();
            }catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
            }
            finally {
            System.out.println("Written to file");
            text4.setText("Receipt printed");
            }

        } else {
            text3.setText("No purchase has been made");
        }


    }


}