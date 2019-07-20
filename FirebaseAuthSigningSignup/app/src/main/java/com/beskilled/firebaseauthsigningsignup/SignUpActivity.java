package com.beskilled.firebaseauthsigningsignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.beskilled.firebaseauthsigningsignup.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivitySignUpBinding signUpBinding;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        signUpBinding.signUpBtn.setOnClickListener(this);
        signUpBinding.sinUpToSingInTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signUpBtn:
                userRegister();
                break;
            case R.id.sinUpToSingInTv:
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void userRegister() {
        String name = signUpBinding.nameSingUpEt.getText().toString().trim();
        String email = signUpBinding.emailSignUpEt.getText().toString().trim();
        String password = signUpBinding.passwordSignUpEt.getText().toString().trim();
        if (name.isEmpty()) {
            signUpBinding.nameSingUpEt.setError("Enter Your name");
            signUpBinding.nameSingUpEt.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            signUpBinding.emailSignUpEt.setError("Enter Your email");
            signUpBinding.emailSignUpEt.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpBinding.emailSignUpEt.setError("invelit email address");
            signUpBinding.emailSignUpEt.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            signUpBinding.passwordSignUpEt.setError("Enter Your password");
            signUpBinding.passwordSignUpEt.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "All redy register", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });
    }
}
