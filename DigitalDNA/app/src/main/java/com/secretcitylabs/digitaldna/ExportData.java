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
import java.util.List;

public class ExportData extends AppCompatActivity {
    DatabaseHelper exportDatabase;
    Button exportDataBtn;
    TextView dbContentsTextView;
    //Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export_data);
        getSupportActionBar().hide();

        exportDatabase = new DatabaseHelper(this);
        exportDataBtn = (Button) findViewById(R.id.exportDataButton);
        dbContentsTextView = findViewById(R.id.scrollViewTextView);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner Drop down elements
        List<String> formats = new ArrayList<String>();
        formats.add("Excel");
        formats.add("CSV");
        formats.add("TSV");
        formats.add("PDF");

        //https://www.tutorialspoint.com/android/android_spinner_control.htm
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  android.R.layout.simple_spinner_item, formats);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

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
            buffer.append("id: " + res.getString(0) + "\n");
        }
        dbContentsTextView.append(buffer.toString());
    }
}