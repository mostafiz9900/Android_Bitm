package com.beskilled.firebaseauthphonethree;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.beskilled.firebaseauthphonethree.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
private ActivityLoginBinding loginBinding;
private String phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding= DataBindingUtil.setContentView(this,R.layout.activity_login);


        loginBinding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber=loginBinding.phoneNumberEt.getText().toString().trim();
                if (phoneNumber.length()==11){
                    Intent intent=new Intent(LoginActivity.this,VerifyActivity.class);
                    intent.putExtra("phone",phoneNumber);
                    startActivity(intent);
                }
            }
        });
    }
}
