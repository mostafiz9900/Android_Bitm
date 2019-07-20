package com.beskilled.firebaseauthsigningsignup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.beskilled.firebaseauthsigningsignup.databinding.ActivitySignInBinding;
import com.beskilled.firebaseauthsigningsignup.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivitySignInBinding signInBinding;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signInBinding= DataBindingUtil.setContentView(this,R.layout.activity_sign_in);
        firebaseAuth=FirebaseAuth.getInstance();
        signInBinding.signInBtn.setOnClickListener(this);
        signInBinding.singInToSingUpTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signInBtn:
                userlogin();
                break;
            case R.id.singInToSingUpTv:
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void userlogin() {
        String email=signInBinding.emailSignInEt.getText().toString().trim();
        String password=signInBinding.passwordSignInEt.getText().toString().trim();
firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()){
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);

            startActivity(intent);
        }else {
            Toast.makeText(SignInActivity.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
        }
    }
});
    }
}
