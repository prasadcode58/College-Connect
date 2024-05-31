package com.example.collageapp.websites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.collageapp.R;

public class WebsiteActivity extends AppCompatActivity {
    
    private TextView vierp, viittit, viitdesc, vittit, vitdesc;
    private ImageView vierplogo, viitlogo, vitlogo;
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Websites");
        
        vierp = findViewById(R.id.vierp);
        vierplogo = findViewById(R.id.vierplogo);
        viittit = findViewById(R.id.viittit);
        viitlogo = findViewById(R.id.viitlogo);
        viitdesc = findViewById(R.id.viitdesc);
        vittit = findViewById(R.id.vittit);
        vitdesc = findViewById(R.id.vitdesc);
        vitlogo = findViewById(R.id.vitlogo);

        vierp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://learner.vierp.in/");
            }
        });
        vierplogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WebsiteActivity.this, VierpActivity.class);
                startActivity(intent);
            }
        });
        viitlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WebsiteActivity.this, VIITActivity.class);
                startActivity(intent);
            }
        });
        viitdesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.viit.ac.in/");
            }
        });
        viittit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WebsiteActivity.this, VIITActivity.class);
                startActivity(intent);
            }
        });
        vittit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WebsiteActivity.this, VITActivity.class);
                startActivity(intent);
            }
        });
        vitdesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.vit.edu/");
            }
        });
        vitlogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WebsiteActivity.this, VITActivity.class);
                startActivity(intent);
            }
        });

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}