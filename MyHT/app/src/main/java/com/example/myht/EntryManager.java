package com.example.myht;

import android.content.Context;
import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

// Singleton class that manages the entries. Writes to and read from Json files.

public class EntryManager {

    private static EntryManager entryManager;

    public static EntryManager getInstance() {
        if (entryManager == null) {
            entryManager = new EntryManager();
        }
        return entryManager;
    }

    // entryWriter writes the data except Weight data. Inputs are the Ilmastodieetti API URL, Filename to write and the context. Uses Gson for writing.

    protected void entryWriter(String url1, String name, Context c) {
        String response = null;
        Gson gson = new Gson();
        URL url = null;
        try {
            url = new URL(url1);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            response = sb.toString();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (name.equals("Consumption")) {
            ConsumptionEntry consumptionEntry = gson.fromJson(response, ConsumptionEntry.class);
            consumptionEntry.setDateCreated();
            try (FileWriter writer = new FileWriter(c.getFilesDir() + "/" + name + ".json", true)) {
                gson.toJson(consumptionEntry, writer);
                writer.append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Written to file: " + c.getFilesDir() + "/" + name + ".json");
            }
        }

        else if (name.equals("Housing")) {
            HousingEntry housingEntry = gson.fromJson(response, HousingEntry.class);
            housingEntry.setDateCreated();
            try (FileWriter writer = new FileWriter(c.getFilesDir().getAbsolutePath() + "/" + name +".json",true)) {
                gson.toJson(housingEntry, writer);
                writer.append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (name.equals("Transport")) {

            // Parse the string manually since ilmastodieetti gives the values differently that i wanted them to the TransportEntry class

            String[] splitResponse = response.split(",");
            splitResponse[0] = splitResponse[0].replace("{", "");
            int Index = splitResponse[4].indexOf("{");
            splitResponse[4] = splitResponse[4].substring(Index+1);
            splitResponse[7] = splitResponse[7].replace(splitResponse[7].substring(splitResponse[7].length()-1), "");
            splitResponse[7] = splitResponse[7].replace("o", "");
            splitResponse[8] = splitResponse[8].replace(splitResponse[8].substring(splitResponse[8].length()-1), "");
            response = Arrays.toString(splitResponse);
            response = response.replace("[", "{");
            response = response.replace("]", "}");
            TransportEntry transportEntry = gson.fromJson(response, TransportEntry.class);
            transportEntry.setDateCreated();
            try (FileWriter writer = new FileWriter(c.getFilesDir().getAbsolutePath() + "/" + name +".json",true)) {
                gson.toJson(transportEntry, writer);
                writer.append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (name.equals("Food")) {
            FoodEntry foodEntry = gson.fromJson(response, FoodEntry.class);
            foodEntry.setDateCreated();
            try (FileWriter writer = new FileWriter(c.getFilesDir().getAbsolutePath() + "/" + name +".json",true)) {
                gson.toJson(foodEntry, writer);
                writer.append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Ilmastodieetti doesn't give a json response for the waste calculator. Instead it gives just the total. So no Gson is needed here. Still write the file in Json

        else if (name.equals("Waste")) {
            try {

                WasteEntry wasteEntry = new WasteEntry(Float.parseFloat(response));
                OutputStreamWriter objectOut = new OutputStreamWriter(c.openFileOutput(name+".json", Context.MODE_APPEND));
                objectOut.write(gson.toJson(wasteEntry));
                objectOut.write("\n");
                objectOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Writes the weight entries to json files using Gson

    protected void weightEntryWriter(Float weight,String name,  Context c) {
        Gson gson = new Gson();
        WeightEntry weightEntry = new WeightEntry(weight);
        try (FileWriter writer = new FileWriter(c.getFilesDir() + "/" + name + ".json", true)) {
            gson.toJson(weightEntry, writer);
            writer.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Reads the weight entries from json files using Gson

    protected ArrayList<WeightEntry> entryReaderWeight(String name, Context c) {
        ArrayList<WeightEntry> a = new ArrayList<WeightEntry>();
        Gson gson = new Gson();
        try {
            InputStream ins = c.openFileInput(name + ".json");
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String text_from_file = "";
            while ((text_from_file = br.readLine()) != null) {
                WeightEntry weightEntry = gson.fromJson(text_from_file, WeightEntry.class);
                a.add(weightEntry);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;

    }

    // Reads the consumption entries from json files using Gson

    protected ArrayList<ConsumptionEntry> entryReaderConsumption(String name, Context c) {
        ArrayList<ConsumptionEntry> a = new ArrayList<ConsumptionEntry>();
        Gson gson = new Gson();
        try {
            InputStream ins = c.openFileInput(name + ".json");
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String text_from_file = "";
            while ((text_from_file = br.readLine()) != null) {
                ConsumptionEntry consumptionEntry = gson.fromJson(text_from_file, ConsumptionEntry.class);
                a.add(consumptionEntry);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return a;

    }

    // Reads the housing entries from json files using Gson

    protected ArrayList<HousingEntry> entryReaderHousing(String name, Context c) {
        ArrayList<HousingEntry> a = new ArrayList<HousingEntry>();
        Gson gson = new Gson();
        try {
            InputStream ins = c.openFileInput(name + ".json");
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String text_from_file = "";
            while ((text_from_file = br.readLine()) != null) {
                HousingEntry housingEntry = gson.fromJson(text_from_file, HousingEntry.class);
                a.add(housingEntry);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;

    }

    // Reads the food entries from json files using Gson

    protected ArrayList<FoodEntry> entryReaderFood(String name, Context c) {
        ArrayList<FoodEntry> a = new ArrayList<FoodEntry>();
        Gson gson = new Gson();
        try {
            InputStream ins = c.openFileInput(name + ".json");
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String text_from_file = "";
            while ((text_from_file = br.readLine()) != null) {
                FoodEntry foodEntry = gson.fromJson(text_from_file, FoodEntry.class);
                a.add(foodEntry);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;

    }

    // Reads the Transport entries from json files using Gson

    protected ArrayList<TransportEntry> entryReaderTransport(String name, Context c) {
        ArrayList<TransportEntry> a = new ArrayList<TransportEntry>();
        Gson gson = new Gson();
        try {
            InputStream ins = c.openFileInput(name + ".json");
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String text_from_file = "";
            while ((text_from_file = br.readLine()) != null) {
                TransportEntry transportEntry= gson.fromJson(text_from_file, TransportEntry.class);
                a.add(transportEntry);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;

    }


    // Reads the Waste entries from json files using Gson

    protected ArrayList<WasteEntry> entryReaderWaste(String name, Context c) {
        ArrayList<WasteEntry> a = new ArrayList<WasteEntry>();
        Gson gson = new Gson();
        try {
            InputStream ins = c.openFileInput(name + ".json");
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String text_from_file = "";
            while ((text_from_file = br.readLine()) != null) {
                WasteEntry wasteEntry = gson.fromJson(text_from_file, WasteEntry.class);
                a.add(wasteEntry);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;

    }


}

