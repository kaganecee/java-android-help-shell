package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Button books = findViewById(R.id.books);
        Button youtubebutton = findViewById(R.id.youtubebutton);
        Button websitesButton = findViewById(R.id.websitesbutton);
        Button githubreposButton = findViewById(R.id.githubreposButton);

        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Books());
            }
        });
        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new YoutubeChannels());
            }
        });

        Button loginButton = (Button) findViewById(R.id.button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(this,loginActivity.class);
                intent.putExtra("msg","hello");
                startActivity(intent);
            }
        });
    }
    private void replaceFragment (Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        Fragment bookFragment = fm.findFragmentById("books");
        fm.beginTransaction().replace(R.id.containerView,bookFragment).commit();
    }
}