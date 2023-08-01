package com.example.gfghack;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Homescreen extends AppCompatActivity {
    CardView iot,crop_news,disease_pred,weat;

    CardView g1,g2,g3,g4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        iot=findViewById(R.id.CV1);
        crop_news=findViewById(R.id.CV2);
        disease_pred=findViewById(R.id.CV3);

        weat=findViewById(R.id.weatherbut);

        g1=findViewById(R.id.HC1);
        g2=findViewById(R.id.HC2);
        g3=findViewById(R.id.HC3);
        g4=findViewById(R.id.HC4);

        disease_pred.setOnClickListener(view -> {
            Intent i=new Intent(Homescreen.this,Disease_Pred.class);
            startActivity(i);
        });

        weat.setOnClickListener(view -> {
            Intent i=new Intent(Homescreen.this,Weather.class);
            startActivity(i);
        });

        g1.setOnClickListener(view ->
        {
            Intent i=new Intent(Homescreen.this,Govt_view.class);
            String temp ="Agri1";
            i.putExtra("url", temp);
            startActivity(i);
        });
        g2.setOnClickListener(view -> {
            Intent i=new Intent(Homescreen.this,Govt_view.class);
            String temp ="Agri2";
            i.putExtra("url", temp);
            startActivity(i);
        });
        g3.setOnClickListener(view -> {
            Intent i=new Intent(Homescreen.this,Govt_view.class);
            String temp ="Agri3";
            i.putExtra("url", temp);
            startActivity(i);
        });
        g4.setOnClickListener(view -> {
            Intent i=new Intent(Homescreen.this,Govt_view.class);
            String temp ="Agri4";
            i.putExtra("url", temp);
            startActivity(i);
        });




        crop_news.setOnClickListener(view -> {
            Intent i=new Intent(Homescreen.this,News_view.class);
            String temp ="News";
            i.putExtra("url", temp);
            startActivity(i);
        });



        iot.setOnClickListener(view ->
        {
            Intent i = new Intent(Homescreen.this, Loggedin.class);
            startActivity(i);
        });

    }



   /* private void getLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                Log.d("Location", "Latitude: " + latitude + ", Longitude: " + longitude);

                String apiUrl = String.format(API_URL, latitude, longitude);
                new FetchWeatherTask().execute(apiUrl);
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };

        // Request location updates
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, locationListener, null);
        }
    }

    private class FetchWeatherTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String apiUrl = urls[0];
            try {
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
                connection.disconnect();

                return response.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String response) {
            Log.d("API Response", response);

            if (response != null) {
                try {
                    JSONObject json = new JSONObject(response);

                    if (json.has("city_name")) {
                        String city = json.getString("city_name");
                        textViewCity.setText(city);
                    } else {
                        textViewCity.setText("City Not Found");
                    }

                    if (json.has("current_weather")) {
                        JSONObject current = json.getJSONObject("current_weather");
                        String temperature = current.getString("temperature");
                        String description = current.getString("weathercode");
                        textViewTemperature.setText(temperature);
                        textViewDescription.setText(description);
                    } else {
                        textViewTemperature.setText("N/A");
                        textViewDescription.setText("N/A");
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

*/
}

