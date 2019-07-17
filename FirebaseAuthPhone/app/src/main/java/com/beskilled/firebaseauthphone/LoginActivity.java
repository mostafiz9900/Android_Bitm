package com.beskilled.firebaseauthphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText phoneNumberEt;
    private Button nextBtn;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        phoneNumberEt = findViewById(R.id.phoneNumberEt);
        nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phone = phoneNumberEt.getText().toString().trim();


                if(phone.length()==11){
                    Intent intent = new Intent(LoginActivity.this,VerifyActivity.class);
                    intent.putExtra("phone",phone);
                }
                else{
                    Toast.makeText(LoginActivity.this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
