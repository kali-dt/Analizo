package com.dhanrajataware.analizo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    private EditText Emailid, password;
    private Button Registerbtn;
    private TextView login;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        firebaseAuth = FirebaseAuth.getInstance();

        login = findViewById(R.id.createText);
        Emailid = findViewById(R.id.email);
        password = findViewById(R.id.password);
        Registerbtn = findViewById(R.id.regBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(register.this,login.class));
                finish();
            }
        });

        Registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterUser();
            }
        });

    }

    private void RegisterUser() {
        String email,pass;
        email = Emailid.getText().toString();
        pass = password.getText().toString();

        if (email.isEmpty()){
            Emailid.setError("Please enter the credential");
        } if (pass.isEmpty()){
            password.setError("Please enter the password");
        }

        firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(register.this,login.class));
                    finish();
                } else {
                    Toast.makeText(register.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}