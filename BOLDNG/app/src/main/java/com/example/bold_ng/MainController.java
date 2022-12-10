package com.example.bold_ng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainController extends AppCompatActivity {

    Button recordDataBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_controller);
        getSupportActionBar().hide();

        recordDataBtn = findViewById(R.id.recordDataBtn);
                recordDataBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainController.this, DataInput.class);
                        startActivity(intent);
                    }
                });
    }
}