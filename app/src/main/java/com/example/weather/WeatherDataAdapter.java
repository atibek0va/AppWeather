package com.example.weather;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherDataAdapter extends AsyncTask<String, Void, String> {
    private TextView resultTextView;

    public WeatherDataAdapter(TextView resultTextView) {
        this.resultTextView = resultTextView;
    }

    @Override
    protected String doInBackground(String... strings) {
        String data = "";
        HttpURLConnection httpURLConnection = null;
        try {
            String city = strings[0];
            String country = strings[1];
            String apiKey = "1a7d3d2143e64f4106c1156fe81fe117";

            String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&appid=" + apiKey;
            URL url = new URL(urlString);

            httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            double tempKelvin = jsonObject.getJSONObject("main").getDouble("temp");
            double tempCelsius = tempKelvin - 273.15;
            String weatherData = "Temperature: " + String.format("%.2f", tempCelsius) + "°C\n"
                    + "Description: " + jsonObject.getJSONArray("weather").getJSONObject(0).getString("description") + "\n"
                    + "Humidity: " + jsonObject.getJSONObject("main").getString("humidity") + "%\n"
                    + "Wind Speed: " + jsonObject.getJSONObject("wind").getString("speed") + "m/s";
            resultTextView.setText(weatherData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
