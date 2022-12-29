package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.FirebaseFirestore;


public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Button loginButton = findViewById(R.id.loginButton2);
        Button registerButton = findViewById(R.id.registerButton2);

        Button roadmapsButton = findViewById(R.id.roadmapsButton);
        Button timerButton = findViewById(R.id.timerButton);
        Button toDoListButton = findViewById(R.id.toDoListButton);
        Button sourcesButton = findViewById(R.id.sourcesButton);


        bottomNavigationView.findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Toast.makeText(MainActivity.this,"Home", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.timer:
                        Toast.makeText(MainActivity.this,"Timer", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.todolist:
                        Toast.makeText(MainActivity.this,"To-Do List", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.sources:
                        Toast.makeText(MainActivity.this,"Sources", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.roadmaps:
                        Toast.makeText(MainActivity.this,"Roadmaps", Toast.LENGTH_LONG).show();
                        break;
                }

                return true;
            }
        });




        roadmapsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(RoadmapActivity.class);
            }
        });
        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(TimerActivity.class);
            }
        });
        toDoListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ListTasksActivity.class);
            }
        });
        sourcesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(SourcesActivity.class);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(LoginActivity.class);
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(SignUpActivity.class);
            }
        });


    }
    public void openActivity(Class activityClass){
        Intent intent = new Intent(this,activityClass);
        startActivity(intent);
    }
}