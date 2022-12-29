package com.secretcitylabs.digitaldna;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExportData extends AppCompatActivity {
    DatabaseHelper exportDatabase;
    Button exportDataBtn;
    TextView dbContentsTextView;
    TextView dbCountTextView;
    //Spinner spinner;

    int databaseEntryCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export_data);
        getSupportActionBar().hide();

        exportDatabase = new DatabaseHelper(this);
        exportDataBtn = (Button) findViewById(R.id.exportDataButton);
        dbContentsTextView = findViewById(R.id.scrollViewTextView);
        dbCountTextView = findViewById(R.id.dbEntryCountTxtView);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner Drop down elements
        List<String> formats = Arrays.asList(" Select Format", "Excel", "CSV", "TSV", "PDF");

        //https://www.youtube.com/watch?v=N8GfosWTt44
        //Create an ArrayAdapter using custom layout
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.spinner_text_color, formats);

        //Specify the custom layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.spinner_drop_down);

        //Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> whatToExport = Arrays.asList(" Select Export Type", "Selected Items", "All");
        ArrayAdapter adapter2 = new ArrayAdapter(getApplicationContext(), R.layout.spinner_text_color, whatToExport);
        adapter2.setDropDownViewResource(R.layout.spinner_drop_down);
        spinner2.setAdapter(adapter2);

        //Get info from database and populate the scroll view
        getDatabaseEntries();
    }

    //Show database contents
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    //Get the db id for each entry and populate the scroll view for now
    public void getDatabaseEntries(){
        Cursor res = exportDatabase.getAllData();
        if(res.getCount() == 0){
            //Show message
            showMessage("Error", "No data to display");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            databaseEntryCount++;
            buffer.append("id: " + res.getString(0) + "\n");
        }
        dbCountTextView.setText(String.valueOf(databaseEntryCount));
        dbContentsTextView.append(buffer.toString());
    }
}