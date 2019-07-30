package com.beskilled.sharepreferencetwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
private TextView nameTv,emialTv;
private String name,email;
private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        
        init();
        getData();
    }

    private void getData() {
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        name=sharedPreferences.getString("name",null);
        email=sharedPreferences.getString("email",null);

        nameTv.setText(name);
        nameTv.setText(email);
    }

    private void init() {
        nameTv=findViewById(R.id.nameTv);
        emialTv=findViewById(R.id.emailTv);
    }

    public void clearBtn(View view) {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}
