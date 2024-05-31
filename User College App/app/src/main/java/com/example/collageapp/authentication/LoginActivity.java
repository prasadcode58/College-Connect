package com.example.collageapp.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.collageapp.MainActivity;
import com.example.collageapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private TextView openReg, openForgetPass;
    private EditText logEmail, logPassword;
    private Button loginBtn;
    private String email, password;
    private FirebaseAuth auth;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        openReg = findViewById(R.id.openReg);

        pd = new ProgressDialog(this);

        logEmail = findViewById(R.id.logEmail);
        logPassword = findViewById(R.id.logPass);
        loginBtn = findViewById(R.id.loginBtn);
        openForgetPass = findViewById(R.id.openForgetPass);

        openReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });

        openForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
            }
        });

    }

    private void validateData() {
        email = logEmail.getText().toString();
        password = logPassword.getText().toString();

        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Please provide all fields.", Toast.LENGTH_SHORT).show();
        }else {
            pd.setMessage("Logging you in...");
            pd.show();
            loginUser();
        }
    }

    private void loginUser() {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            pd.dismiss();
                            Toast.makeText(LoginActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                            openMain();
                        }else {
                            pd.dismiss();
                            Toast.makeText(LoginActivity.this, "Error : "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(LoginActivity.this, "Error : "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openMain() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    private void openRegister() {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        finish();
    }
}