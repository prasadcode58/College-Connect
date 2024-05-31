package com.example.collageapp.vidlec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.collageapp.R;

public class VidLecActivity extends AppCompatActivity {

    private TextView urEng, gateSmash, codeWithHarry, gatesmashers, codeWith, codehelp;
    private ImageView uefLogo, gatesm, codewithar, codehelplogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vid_lec);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Video Lectures");

        urEng = findViewById(R.id.urEng);
        codehelp = findViewById(R.id.codehelp);
        gateSmash = findViewById(R.id.gateSmash);
        codeWithHarry = findViewById(R.id.codeWithHarry);
        gatesmashers = findViewById(R.id.gatesmashers);
        codeWith = findViewById(R.id.codeWith);
        uefLogo = findViewById(R.id.uefLogo);
        codehelplogo = findViewById(R.id.codehelplogo);
        gatesm = findViewById(R.id.gatesm);
        codewithar = findViewById(R.id.codewithar);


        urEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/UrEngineeringFriend");
            }
        });

        codehelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.youtube.com/@CodeHelp");
            }
        });

        gateSmash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/GateSmashers");
            }
        });

        codeWithHarry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://youtube.com/c/CodeWithHarry");
            }
        });
        gatesmashers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VidLecActivity.this, GateSmActivity.class);
                startActivity(intent);
            }
        });
        codeWith.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VidLecActivity.this, CoWiHaActivity.class);
                startActivity(intent);
            }
        });
        uefLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VidLecActivity.this, UEFActivity.class);
                startActivity(intent);
            }
        });

        codehelplogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VidLecActivity.this, CodeHelpActivity.class);
                startActivity(intent);
            }
        });

        gatesm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VidLecActivity.this, GateSmActivity.class);
                startActivity(intent);
            }
        });
        codewithar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VidLecActivity.this, CoWiHaActivity.class);
                startActivity(intent);
            }
        });

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}