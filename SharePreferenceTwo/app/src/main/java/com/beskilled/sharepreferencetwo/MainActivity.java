package com.beskilled.sharepreferencetwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText name, email;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String names, emils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        name = findViewById(R.id.nameEt);
        email = findViewById(R.id.emailEt);
    }

    private void setSharedPreferences() {
        names = name.getText().toString();
        emils = email.getText().toString();
        sharedPreferences = getSharedPreferences("login", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("name", names);
        editor.putString("emil", emils);
        editor.apply();
    }

    public void saveBtn(View view) {
        setSharedPreferences();
        Intent intent =new Intent(getApplicationContext(),WelcomeActivity.class);
        startActivity(intent);
    }

    public void welcomeBtn(View view) {
        Intent intent =new Intent(getApplicationContext(),WelcomeActivity.class);
        startActivity(intent);
    }
}
