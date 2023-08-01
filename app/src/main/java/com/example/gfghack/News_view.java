package com.example.gfghack;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class News_view extends AppCompatActivity {
    WebView gwv;
    ProgressBar progressBar;
    final Handler handler = new Handler();

    @SuppressLint({"SetJavaScriptEnabled", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_view);

        progressBar = findViewById(R.id.progress_barNv);
        progressBar.setVisibility(View.VISIBLE);

        gwv=findViewById(R.id.NewsWV);
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
        if ("News".equals(url)) {
            url = "https://krishijagran.com/";
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

