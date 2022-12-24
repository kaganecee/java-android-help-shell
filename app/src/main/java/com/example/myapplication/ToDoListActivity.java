package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ToDoListActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button submitBtn = findViewById(R.id.addTaskBtn);
        EditText taskName = findViewById(R.id.taskName);
        EditText taskPriority = findViewById(R.id.taskPriority);
        EditText taskStatus = findViewById(R.id.taskStatus);
        EditText taskDeadline = findViewById(R.id.taskDeadline);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewTask(taskName.getText().toString(), taskPriority.getText().toString(), taskStatus.getText().toString(), taskDeadline.getText().toString());
                clearInputs(taskName,taskPriority,taskStatus,taskDeadline);
            }
        });
    }
    public void clearInputs(EditText taskName,EditText taskPriority,EditText taskStatus,EditText taskDeadline){
        taskName.getText().clear();
        taskPriority.getText().clear();
        taskStatus.getText().clear();
        taskDeadline.getText().clear();
    }
    public void addNewTask(String taskName,String taskPriority,String taskStatus,String taskDeadline){
        Map<String, Object> docData = new HashMap<>();
        docData.put("name", taskName);
        docData.put("priority", taskPriority);
        docData.put("status", taskStatus);
        docData.put("deadline", taskDeadline);
        db.collection("data").add(docData);
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