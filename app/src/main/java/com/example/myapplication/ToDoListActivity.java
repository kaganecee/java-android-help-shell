package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ToDoListActivity extends AppCompatActivity {
    EditText taskInput = findViewById(R.id.books);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
    }
    public void addItemToList(View v){
        toDoList.add(taskInput.getText().toString());
    }
    public void openActivity (Class activityClass){
        Intent intent = new Intent(this,activityClass);
        startActivity(intent);
    }
}