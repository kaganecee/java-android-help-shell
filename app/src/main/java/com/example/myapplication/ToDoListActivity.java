package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ToDoListActivity extends AppCompatActivity {
    EditText taskName = findViewById(R.id.books);
    EditText taskPriority = findViewById(R.id.books);
    EditText taskStatus = findViewById(R.id.books);
    EditText taskDeadline = findViewById(R.id.books);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
    }
    public void addNewTask(View v){

        Map<String, Object> docData = new HashMap<>();
        docData.put("name", taskName);
        docData.put("priority", taskPriority);
        docData.put("status", taskStatus);
        docData.put("deadline", taskDeadline);
        db.collection("data").add(docData);
    }
    public object getTask(View v){
        Array tasks = db.collection("tasks").get();
    }
    public void openActivity (Class activityClass){
        Intent intent = new Intent(this,activityClass);
        startActivity(intent);
    }
}