package com.example.groupdisscussion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class LoginActivity extends AppCompatActivity {

    EditText e_Email, e_Password;
    Button b_Login;
    TextView b_Register;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindViews();
        initialize();

        b_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        b_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = e_Email.getText().toString();
                String Password = e_Password.getText().toString();

                if(Email.isEmpty()){
                    e_Email.setError("Enter your Email ID");
                }
                else if(Password.isEmpty()){
                    e_Password.setError("Enter Your Password");
                }
                else {
                    mAuth.signInWithEmailAndPassword(Email,Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull @NotNull Exception e) {
                            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

    private void initialize() {

        mAuth = FirebaseAuth.getInstance();
    }

    private void bindViews() {

        e_Email = findViewById(R.id.etEmail);
        e_Password = findViewById(R.id.etPassword);
        b_Login = findViewById(R.id.btLogin);
        b_Register = findViewById(R.id.btRegister);
    }
}