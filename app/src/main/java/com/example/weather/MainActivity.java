package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText City;
    private EditText Country;
    private Button btnGet;
    private TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        City = findViewById(R.id.city);
        Country = findViewById(R.id.country);
        btnGet = findViewById(R.id.btnGet);
        Result = findViewById(R.id.resultText);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = City.getText().toString().trim();
                String country = Country.getText().toString().trim();
                WeatherDataAdapter weatherDataAdapter = new WeatherDataAdapter(Result);
                weatherDataAdapter.execute(city, country);
            }
        });
    }


}