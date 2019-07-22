package com.beskilled.firebaseauthsignindatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.beskilled.firebaseauthsignindatabase.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {
private ActivitySignUpBinding signUpBinding;
private FirebaseAuth firebaseAuth;
private DatabaseReference database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding= DataBindingUtil.setContentView(this,R.layout.activity_sign_up);
init();
        signUpBinding.signUpToSingInTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SignInActivity.class);
                startActivity(intent);
            }
        });
        signUpBinding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userRegistation();
            }
        });
    }

    private void init() {
        firebaseAuth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance().getReference();
    }

    private void userRegistation() {
        final String name=signUpBinding.nameSignUpEt.getText().toString().trim();
        final String email=signUpBinding.emailSignUpEt.getText().toString().trim();
        String password=signUpBinding.passwordSignUpEt.getText().toString().trim();
        signUpBinding.signUpPB.setVisibility(View.VISIBLE);
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    signUpBinding.signUpPB.setVisibility(View.GONE);
                  String userId=firebaseAuth.getCurrentUser().getUid();
                  DatabaseReference userRef=database.child("student").child(userId);
                    HashMap<String,Object> student=new HashMap<>();
                    student.put("name",name);
                    student.put("email",email);
                    userRef.setValue(student).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                finish();
                                Intent intent = new Intent(getApplicationContext(),SignInActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                            }
                        }
                    });
                }else {
                   if (task.getException() instanceof FirebaseAuthUserCollisionException){
                       Toast.makeText(getApplicationContext(), "User already registered", Toast.LENGTH_SHORT).show();
                   }else {
                       Toast.makeText(getApplicationContext(), "Error :" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });
    }
}
