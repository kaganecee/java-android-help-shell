package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SourcesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sources);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button books = findViewById(R.id.books);
        Button youtubebutton = findViewById(R.id.youtubebutton);
        Button websitesButton = findViewById(R.id.websitesbutton);
        Button githubreposButton = findViewById(R.id.githubreposButton);

        books.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new Books(), R.id.booksContainer);
            }
        });
        youtubebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new YoutubeChannels(), R.id.youtubeContainer);
            }
        });
        websitesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {replaceFragment(new Websites(), R.id.websitesContainer);
            }
        });

        githubreposButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {replaceFragment(new GithubRepos(),R.id.githubContainer);
            }
        });


    }
    public void changeVisibilityOfElements(){
        findViewById(R.id.books).setVisibility(View.GONE);
        findViewById(R.id.textView).setVisibility(View.GONE);
        findViewById(R.id.textView3).setVisibility(View.GONE);
        findViewById(R.id.youtubebutton).setVisibility(View.GONE);
        findViewById(R.id.websitesbutton).setVisibility(View.GONE);
        findViewById(R.id.githubreposButton).setVisibility(View.GONE);
    }
    private void replaceFragment (Fragment fragment, int containerId){
        changeVisibilityOfElements();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(containerId,fragment).commit();
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