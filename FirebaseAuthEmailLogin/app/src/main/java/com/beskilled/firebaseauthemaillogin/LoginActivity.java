package com.beskilled.firebaseauthemaillogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.beskilled.firebaseauthemaillogin.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityLoginBinding loginBinding;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        this.setTitle("Login Activity");

        mAuth = FirebaseAuth.getInstance();
        loginBinding.loginBtn.setOnClickListener(this);
        loginBinding.loginToSignupBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginBtn:

                userLogin();
                break;
            case R.id.loginToSignupBtn:
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void userLogin() {
        String email = loginBinding.emailLoginEt.getText().toString().trim();
        String password = loginBinding.passwordLoginEt.getText().toString().trim();
        if (email.isEmpty()) {
            loginBinding.emailLoginEt.setError("Enter Your Email Addaress");
            loginBinding.emailLoginEt.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            loginBinding.emailLoginEt.setError("Dous not Match email addresss");
            loginBinding.emailLoginEt.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            loginBinding.passwordLoginEt.setError("Enter Your Password");
            loginBinding.passwordLoginEt.requestFocus();
            return;
        }
        if (password.length() < 6) {
            loginBinding.passwordLoginEt.setError("Minimum Length of a password should be 6");
            loginBinding.passwordLoginEt.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//button click borle toper sob clear hobe
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login Uncuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
