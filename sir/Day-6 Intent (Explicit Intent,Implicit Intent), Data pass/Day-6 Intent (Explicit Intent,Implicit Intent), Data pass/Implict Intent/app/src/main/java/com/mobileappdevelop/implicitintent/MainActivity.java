package com.mobileappdevelop.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText phoneNoET;
    private Button callBtn;
    private String phoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNoET = findViewById(R.id.phoneNoET);
        callBtn = findViewById(R.id.callBtn);

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNo = phoneNoET.getText().toString().trim();

                if (phoneNo.equals("")) {

                    Toast.makeText(MainActivity.this, "Please Input Your Number",
                            Toast.LENGTH_LONG).show();

                } else {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + phoneNo));
                    startActivity(intent);

                }

            }
        });

    }
}
