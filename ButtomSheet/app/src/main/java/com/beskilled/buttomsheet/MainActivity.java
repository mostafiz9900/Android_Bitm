package com.beskilled.buttomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bottomSheertBtn(View view) {
        DemoBottomSheet demoBottomSheet=new DemoBottomSheet();
        demoBottomSheet.show(getSupportFragmentManager(),"demoBottomSheet");
    }
}
