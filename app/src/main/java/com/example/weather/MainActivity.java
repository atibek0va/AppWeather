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

    private EditText etCity;
    private EditText etCountry;
    private Button btnGet;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCity = findViewById(R.id.etCity);
        etCountry = findViewById(R.id.etCountry);
        btnGet = findViewById(R.id.btnGet);
        tvResult = findViewById(R.id.tvResult);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = etCity.getText().toString().trim();
                String country = etCountry.getText().toString().trim();
                WeatherDataAdapter weatherDataAdapter = new WeatherDataAdapter(tvResult);
                weatherDataAdapter.execute(city, country);
            }
        });
    }


}