package com.example.gfghack;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Govt_view extends AppCompatActivity {

    WebView gwv;
    ProgressBar progressBar;
    final Handler handler = new Handler();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt_view);

        progressBar = findViewById(R.id.progress_barGv);
        progressBar.setVisibility(View.VISIBLE);

        gwv=findViewById(R.id.GameWV);
        String url = getIntent().getExtras().getString("url");
/*
        Toast.makeText(this, ""+url, Toast.LENGTH_SHORT).show();
*/
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(ProgressBar.INVISIBLE);
            }
        }, 8000);
        switch (url)
        {
            case "Agri1":
                url = "https://www.india.gov.in/topics/agriculture";
                break;
            case "Agri2":
                url = "https://agricoop.nic.in/#gsc.tab=0";
                break;
            case "Agri3":
                url = "https://www.enam.gov.in/web/";
                break;
            case "Agri4":
                url = "https://mkisan.gov.in/";
                break;
        }
        gwv.loadUrl(url);
        gwv.getSettings().setJavaScriptEnabled(true);
        gwv.setWebViewClient(new WebViewClient());
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        finish();
    }
}
