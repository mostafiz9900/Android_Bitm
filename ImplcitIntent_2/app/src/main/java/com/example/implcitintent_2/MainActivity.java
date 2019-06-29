package com.example.implcitintent_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText callET;
private Button callBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callET=findViewById(R.id.callET);
        callBtn=findViewById(R.id.callBtn);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callET.equals("")){
                    Toast.makeText(MainActivity.this,"this is not nubme",Toast.LENGTH_LONG).show();
                }else {
                    Intent intent=new Intent();
                    intent.setAction(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel"+callET));
                    startActivity(intent);
                }
            }
        });
    }
}
