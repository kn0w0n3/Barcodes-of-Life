package com.secretcitylabs.bold_ng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainController extends AppCompatActivity {

    Button recordDataBtn;
    Button searchDataBtnx;
    Button viewEditDataBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_controller);
        getSupportActionBar().hide();


        //Open the input data window when user clicks button
        recordDataBtn = findViewById(R.id.mc_InputDataBtn);
        recordDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainController.this, RecordData.class);
                startActivity(intent);
            }
        });

        //Open the search data window when user clicks button
        searchDataBtnx = findViewById(R.id.mc_SearchDataBtn);
        searchDataBtnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(MainController.this, SearchData.class);
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
