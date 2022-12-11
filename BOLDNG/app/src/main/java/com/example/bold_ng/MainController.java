package com.example.bold_ng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainController extends AppCompatActivity {

    Button recordDataBtn;
    Button searchDataBtnx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_controller);
        getSupportActionBar().hide();

        //Open the input data window when user clicks button
        recordDataBtn = findViewById(R.id.recordDataBtn);
        recordDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainController.this, RecordData.class);
                startActivity(intent);
            }
        });

        //Open the search data window when user clicks button
        searchDataBtnx = findViewById(R.id.searchDataBtn);
        searchDataBtnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(MainController.this, SearchData.class);
                startActivity(intent2);
            }
        });
    }
}
