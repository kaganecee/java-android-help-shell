package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText username = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        Button registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNewUsers(username.getText().toString(),email.getText().toString(),password.getText().toString());
                clearInputs(username,email,password);
            }
        });
    }
    public void handleNewUsers(String username, String email, String password) {
        Boolean isUserExist = findUserByUsername(username);
        if(!isUserExist){
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("username", username);
            userInfo.put("email", email);
            userInfo.put("password", password);
            db.collection("users").add(userInfo);
        }
        // Make toast message
    }
    public void clearInputs(EditText username, EditText email, EditText password){
        username.getText().clear();
        email.getText().clear();
        password.getText().clear();
    }
    public boolean findUserByUsername(String username){
        // Must be user type
        Task users = db.collection("users").get();
        Boolean isUserExist = false;
        // Scope issue of variable
        users.addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        if (document.getString("username") == username) {
                            isUserExist = true;
                        }
                    }
                }
            }
        });
        return isUserExist;
    };
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