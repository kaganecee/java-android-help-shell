package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SourcesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sources);

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
        youtubebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new YoutubeChannels());
            }
        });
        websitesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {replaceFragment(new Websites());
            }
        });

        githubreposButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {replaceFragment(new GithubRepos());
            }
        });


    }
    private void replaceFragment (Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        Fragment bookFragment = fm.findFragmentById("books");
        fm.beginTransaction().replace(R.id.containerView,bookFragment).commit();
    }
}