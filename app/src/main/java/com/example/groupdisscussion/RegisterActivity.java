package com.example.groupdisscussion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    Button b_Register;
    LinearLayout b_Login;
    EditText e_Email, e_Password, e_Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bindViews();

        initilize();


        b_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = e_Email.getText().toString();
                String Password = e_Password.getText().toString();
                String Name = e_Name.getText().toString();

                if (Email.isEmpty() || Password.isEmpty() || Name.isEmpty() ){
                    if (Email.isEmpty()){
                        e_Email.setError("Enter the email");
                    }
                }
                else{
                    mAuth.createUserWithEmailAndPassword(Email,Password);
                }
            }
        });
    }

    private void initilize() {
        mAuth = FirebaseAuth.getInstance();
    }

    private void bindViews() {

        b_Login = findViewById(R.id.btLogin);
        b_Register = findViewById(R.id.btRegister);
        e_Email = findViewById(R.id.etEmail);
        e_Password = findViewById(R.id.etPassword);
        e_Name = findViewById(R.id.etName);
    }
}