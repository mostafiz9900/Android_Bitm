package com.beskilled.firebaseauthemaillogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.beskilled.firebaseauthemaillogin.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;
import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivitySignUpBinding signUpBinding;
    private FirebaseAuth mAuth;
private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);
        this.setTitle("Sign Up Activity");
        mAuth = FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        signUpBinding.signUpBtn.setOnClickListener(this);
        signUpBinding.signUpToLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signUpBtn:
                userRegister();
                break;
            case R.id.signUpToLoginBtn:
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void userRegister() {
        final String userName = signUpBinding.nameSignEt.getText().toString().trim();
        final String email = signUpBinding.emailSignEt.getText().toString().trim();
        String passWord = signUpBinding.passwordSignUpEt.getText().toString().trim();
signUpBinding.signUpToLoginBtn.setVisibility(View.VISIBLE);
        if (userName.isEmpty()) {
            signUpBinding.nameSignEt.setError("Enter Your Name");
            signUpBinding.nameSignEt.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            signUpBinding.emailSignEt.setError("Enter an Email Address");
            signUpBinding.emailSignEt.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpBinding.emailSignEt.setError("Enter an valid Email Address");
            signUpBinding.emailSignEt.requestFocus();
            return;
        }
        //password Validation
        if (passWord.isEmpty()) {
            signUpBinding.passwordSignUpEt.setError("Enter a Password");
            signUpBinding.passwordSignUpEt.requestFocus();
            return;
        }
        if (passWord.length() < 6) {
            signUpBinding.passwordSignUpEt.setError("Minimum lenth of a password show be 6");
            signUpBinding.passwordSignUpEt.requestFocus();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
               // signUpBinding.signUpToLoginBtn.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    String userId=mAuth.getCurrentUser().getUid();
                    DatabaseReference userRef=databaseReference.child("users").child(userId);
                    HashMap<String,Object> userMap=new HashMap<>();
                    userMap.put("userName",userName);
                    userMap.put("email",email);
                    userRef.setValue(userMap);
                  /*  finish();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//button click borle toper sob clear hobe
                    startActivity(intent);*/
                    //Toast.makeText(getApplicationContext(), "Register is successful", Toast.LENGTH_SHORT).show();
                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(), "user is alredy register", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(), "Error "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
