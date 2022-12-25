package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.sql.Array;

public class ListTasksActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tasks);
        TableLayout taskTable = findViewById(R.id.taskTable);
        getTasks(taskTable);

        Button addNewTask = findViewById(R.id.addNewTask);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });
    }
    public void getTasks(TableLayout taskTable){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Task tasks = db.collection("data").get();
                tasks.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                TableRow tr = new TableRow(ListTasksActivity.this);

                                TextView name = new TextView(ListTasksActivity.this);
                                name.setText("test");
                                tr.addView(name);

                                TextView priority = new TextView(ListTasksActivity.this);
                                priority.setText(document.getString("priority"));
                                tr.addView(priority);

                                TextView status = new TextView(ListTasksActivity.this);
                                status.setText(document.getString("status"));
                                tr.addView(status);

                                TextView deadline = new TextView(ListTasksActivity.this);
                                deadline.setText(document.getString("deadline"));
                                tr.addView(deadline);
                                tr.setLayoutParams(new LinearLayout.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                                taskTable.addView(tr);

                                Toast.makeText(
                                        ListTasksActivity.this,tr.getChildAt(0).toString()
                                        , Toast.LENGTH_LONG).show();

                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
            }
        });
        t.start();
    }

    public void openActivity (){
        Intent intent = new Intent(ListTasksActivity.this,ToDoListActivity.class);
        startActivity(intent);
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