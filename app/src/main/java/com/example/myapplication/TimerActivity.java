package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class TimerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button chronometerBtn = findViewById(R.id.chronometer);
        setContentView(R.layout.activity_timer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Chronometer chronometer = (Chronometer) findViewById(R.id.TimeValue);
        boolean isRunning;
        long pauseOffSet;
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000)
                    chronometer.setBase(SystemClock.elapsedRealtime());
                Toast.makeText(TimerActivity.this, "Bing!", Toast.LENGTH_SHORT);
            }
        });
    }


    public void startOrPauseChronometer(Boolean isRunning,Chronometer chronometer,Long pauseOffSet) {
        if (!isRunning) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffSet);
            chronometer.start();
            isRunning = true;

        }
    }

    public void pauseChronometer(Boolean isRunning,Chronometer chronometer,Long pauseOffSet) {
        if (isRunning) {
            pauseOffSet = SystemClock.elapsedRealtime() - chronometer.getBase();
            chronometer.stop();
            isRunning = false;
        }
    }

    public void resetChronometer(Boolean isRunning,Chronometer chronometer,Long pauseOffSet) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffSet = (long) 0;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}