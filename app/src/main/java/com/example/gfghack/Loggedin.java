 package com.example.gfghack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;





 public class Loggedin extends AppCompatActivity {
     VideoView video1;
     FirebaseFirestore firestore;
     DatabaseReference databaseReference1,databaseReference2,databaseReference3,databaseReference4;


     CardView Insights;
     TextView humidity, soilmoisture, temperature, light;


     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_loggedin);
         video1 = (VideoView) findViewById(R.id.backk);
         Insights = (CardView) findViewById(R.id.c1);
         soilmoisture = (TextView) findViewById(R.id.c1Text);
         humidity = (TextView) findViewById(R.id.c2Text);
         temperature = (TextView) findViewById(R.id.c3Text);
         light = (TextView) findViewById(R.id.c4Text);


         firestore = FirebaseFirestore.getInstance();
         databaseReference1 = FirebaseDatabase.getInstance().getReference("Data").child("Humidity");
         databaseReference2 = FirebaseDatabase.getInstance().getReference("Data").child("Soil Moisture");
         databaseReference3 = FirebaseDatabase.getInstance().getReference("Data").child("Temperature");
         databaseReference4 = FirebaseDatabase.getInstance().getReference("Data").child("Luminosity");


         gethumidity();
         getsoilmoisture();
         gettemp();
         getlumin();


         Insights.setOnClickListener(view ->
         {
             Intent i = new Intent(Loggedin.this, Insights.class);
             startActivity(i);
         });


         String path = "android.resource://com.example.gfghack/" + R.raw.backk;
         Uri u = Uri.parse(path);
         video1.setVideoURI(u);
         video1.start();

         video1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
             @Override
             public void onPrepared(MediaPlayer mediaPlayer) {
                 mediaPlayer.setLooping(true);
             }
         });


     }

     @Override
     protected void onResume() {
         video1.resume();
         super.onResume();
     }

     @Override
     protected void onPause() {
         video1.suspend();
         super.onPause();
     }

     @Override
     protected void onDestroy() {
         video1.stopPlayback();
         super.onDestroy();
     }


     private void gethumidity() {

         databaseReference1.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange( DataSnapshot snapshot) {
                 String value = snapshot.getValue(String.class);



                 humidity.setText(value);
             }

             @Override
             public void onCancelled( DatabaseError error) {
                 // calling on cancelled method when we receive
                 // any error or we are not able to get the data.
                 Toast.makeText(Loggedin.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
             }
         });

     }


     private void getsoilmoisture() {

         databaseReference2.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange( DataSnapshot snapshot) {
                 String value = snapshot.getValue(String.class);



                 soilmoisture.setText(value);
             }

             @Override
             public void onCancelled( DatabaseError error) {
                 // calling on cancelled method when we receive
                 // any error or we are not able to get the data.
                 Toast.makeText(Loggedin.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
             }
         });

     }

     private void gettemp() {

         databaseReference3.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange( DataSnapshot snapshot) {
                 String value = snapshot.getValue(String.class);



                 temperature.setText(value);
             }

             @Override
             public void onCancelled( DatabaseError error) {
                 // calling on cancelled method when we receive
                 // any error or we are not able to get the data.
                 Toast.makeText(Loggedin.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
             }
         });

     }

     private void getlumin() {

         databaseReference4.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange( DataSnapshot snapshot) {
                 String value = snapshot.getValue(String.class);



                 light.setText(value);
             }

             @Override
             public void onCancelled( DatabaseError error) {
                 // calling on cancelled method when we receive
                 // any error or we are not able to get the data.
                 Toast.makeText(Loggedin.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
             }
         });

     }
 }


