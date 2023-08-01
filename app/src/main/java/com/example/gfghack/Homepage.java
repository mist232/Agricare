package com.example.gfghack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        TextView username=(TextView) findViewById(R.id.username);
        TextView password=(TextView) findViewById(R.id.password);
        ImageView aboutus=(ImageView) findViewById(R.id.side);

        MaterialButton loginbtn=(MaterialButton) findViewById(R.id.loginbtn);


        aboutus.setOnClickListener(view ->
        {
            Intent i = new Intent(Homepage.this, Aboutus.class);
            startActivity(i);
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    Toast.makeText(Homepage.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Homepage.this,Homescreen.class));
                }
                else{
                    Toast.makeText(Homepage.this, "LOGIN FAILED", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}