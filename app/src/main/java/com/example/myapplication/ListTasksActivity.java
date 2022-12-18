package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.Array;

public class ListTasksActivity extends AppCompatActivity {
    EditText addNewTask = findViewById(R.id.ConstrainLayout);
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tasks);
        addNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
                );
            }
        });
    }
    public void getTask(View v){
        Array tasks = db.collection("tasks").get();
    }

    public void openActivity (){
        Intent intent = new Intent(this,ToDoListActivity.class);
        startActivity(intent);
    }
}