package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class TimerActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private boolean isRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chronometer = findViewById(R.id.chronometer);
        setContentView(R.layout.activity_timer);
    }

    public void startOrPauseChronometer (View v) {
        if (!isRunning) {
            chronometer.start();
            isRunning = true;

        }
    }
    public void pauseChronometer (View v) {
        if (isRunning) {
            chronometer.stop();
            isRunning = false;
        }
    }


}