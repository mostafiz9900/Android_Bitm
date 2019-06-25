package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button fragmentOne, fragmentTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        fragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replecFragemt(new OneFragment());

            }
        });
        fragmentTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            replecFragemt(new TwoFragment());
            }
        });
    }

    private void replecFragemt(Fragment fragment) {
        //FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment, fragment);

    }

    private void init() {
        fragmentOne=findViewById(R.id.fragmentOne);
        fragmentTwo=findViewById(R.id.fragmentTwo);

    }


}
