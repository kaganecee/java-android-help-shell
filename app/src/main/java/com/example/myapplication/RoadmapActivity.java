package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoadmapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button frontendRoadmapBtn = findViewById(R.id.frontendRoadmapBtn);
        Button backendRoadmapBtn = findViewById(R.id.backendRoadmapBtn);
        Button mobileRoadmapBtn = findViewById(R.id.mobileRoadmapBtn);
        Button blockchainRoadmapBtn = findViewById(R.id.blockchainRoadmapBtn);

        frontendRoadmapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedButton("https://roadmap.sh/frontend");
            }
        });
        backendRoadmapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedButton("https://roadmap.sh/backend");
            }
        });
        mobileRoadmapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedButton("https://roadmap.sh/android");
            }
        });
        blockchainRoadmapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedButton("https://roadmap.sh/blockchain");
            }
        });
    }
    public void clickedButton(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);

    }
}