package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nameEt,emailEt;
    private Button save,welcome;
    private String name,email;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void setDateSharepreference() {
        name=nameEt.getText().toString();
        email=emailEt.getText().toString();

        sharedPreferences=getSharedPreferences("login", MODE_PRIVATE);
        editor=sharedPreferences.edit();
        editor.putString("name",name);
        editor.putString("email",email);
        editor.apply();
    }

    private void init() {
        nameEt=findViewById(R.id.nameET);
        emailEt=findViewById(R.id.emailET);
    }

    public void saveData(View view) {
        setDateSharepreference();
        Intent intent=new Intent(getApplicationContext(),WelcomeActivity.class);
        startActivity(intent);
    }

    public void Welcome(View view) {
        Intent intent=new Intent(getApplicationContext(),WelcomeActivity.class);
        startActivity(intent);
    }
}
