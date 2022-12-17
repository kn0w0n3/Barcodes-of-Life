package com.example.bold_ng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class SearchData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        Button searchBtn1, searchBtn2, searchBtn3;
        EditText et1, et2, et3;
        ListView apiListV;

        searchBtn1 = findViewById(R.id.sd_searchBtn);
        searchBtn2 = findViewById(R.id.sd_searchBtn2);
        searchBtn3 = findViewById(R.id.sd_searchBtn3);

        et1 = findViewById(R.id.sd_SearchEditTxt);
        et2 = findViewById(R.id.sd_SearchEditTxt2);
        et3 = findViewById(R.id.sd_SearchEditTxt3);

        apiListV = findViewById(R.id.apiListView);

        //CLick listeners for buttons
        searchBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(SearchData.this);
                String url = "http://v3.boldsystems.org/index.php/API_Public/specimen?taxon=Aves&geo=Costa%20Rica&format=tsv";

                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                //textView.setText("Response is: " + response.substring(0,500));
                                Toast.makeText(SearchData.this, response, Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SearchData.this, "Error occurred with API call", Toast.LENGTH_SHORT).show();
                    }
                });

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }
        });

        searchBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SearchData.this, "The text entered is: " + et2.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        searchBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SearchData.this, "The text entered is: " + et3.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}