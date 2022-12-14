package com.secretcitylabs.digitaldna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainController extends AppCompatActivity {

    Button recordDataBtn;
    Button viewMapBtnx;
    Button viewEditDataBtn;
    Button exportDtaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_controller);
        getSupportActionBar().hide();

        //Button to start export data activity
        exportDtaBtn = findViewById(R.id.mc_ExportDataBtn);
        exportDtaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent exportIntent = new Intent(MainController.this, ExportData.class);
                startActivity(exportIntent);
            }
        });

        //Open the input data activity when user clicks button
        recordDataBtn = findViewById(R.id.mc_InputDataBtn);
        recordDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainController.this, RecordData.class);
                startActivity(intent);
            }
        });

        //Open the search data window when user clicks button
        viewMapBtnx = findViewById(R.id.mc_ViewMapBtn);
        viewMapBtnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(MainController.this, MapsActivity.class);
                startActivity(intent2);
            }
        });

        //Open the view edit data window when user clicks button
        viewEditDataBtn = findViewById(R.id.mc_ViewEditBtn);
        viewEditDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainController.this, ViewData.class);
                startActivity(intent3);
            }
        });
    }
}
