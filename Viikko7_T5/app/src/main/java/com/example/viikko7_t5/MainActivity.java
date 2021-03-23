package com.example.viikko7_t5;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    Context context = null;

    TextView text;
    EditText inputFile;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = MainActivity.this;
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        input = (EditText) findViewById(R.id.Input);
        inputFile = (EditText) findViewById(R.id.InputFile);
    }


    public void save(View v) {

        String InputToFile = input.getText().toString();
        String Filename = inputFile.getText().toString();

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(Filename, Context.MODE_PRIVATE));
            outputStreamWriter.write(InputToFile);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        finally {
            System.out.println("Written to file");
    }

    }

    public void loadTo(View v) {

        String Filename = inputFile.getText().toString();

        try {
            InputStream ins = context.openFileInput(Filename);

            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String text_from_file = "";

            while ((text_from_file = br.readLine()) != null) {
                text.setText(text_from_file);
            }

            ins.close();
        } catch (FileNotFoundException e) {
            Log.e("FileNotFoundException", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("IOException", "Invalid input");
        } finally {
            System.out.println("Read from file successfully");
        }
    }

}