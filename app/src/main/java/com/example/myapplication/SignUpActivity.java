package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Boolean isUserExist = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText username = findViewById(R.id.usernameInput);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.passwordInput);
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
        Boolean isUserExist = isUserExist(username);
        if(!isUserExist){
            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("username", username);
            userInfo.put("email", email);
            userInfo.put("password", password);
            db.collection("users").add(userInfo);
            Toast.makeText(getApplicationContext(),"Success!!",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"This username is already exist.",Toast.LENGTH_SHORT).show();
        }
    }
    public void clearInputs(EditText username, EditText email, EditText password){
        username.getText().clear();
        email.getText().clear();
        password.getText().clear();
    }
    public boolean isUserExist(String username){
        Task users = db.collection("users").get();
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