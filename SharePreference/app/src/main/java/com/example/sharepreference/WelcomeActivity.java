package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
private TextView nameTv,emailTv;
private SharedPreferences sharedPreferences;
private String name,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
        getData();
    }

    private void getData() {
        sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        name=sharedPreferences.getString("name",null);
        email=sharedPreferences.getString("email",null);



               nameTv.setText(name);
               emailTv.setText(email);


    }

    private void init() {
        nameTv=findViewById(R.id.nameTV);
        emailTv=findViewById(R.id.emailTV);
    }

    public void ClearData(View view) {
       SharedPreferences.Editor editor=sharedPreferences.edit();
       editor.clear();
       editor.commit();

    }
}
