package com.eshan.mobileappdevelop.menuitem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.one:
                Toast.makeText(this,"one",Toast.LENGTH_LONG).show();
                break;
            case R.id.two:
                Toast.makeText(this,"two",Toast.LENGTH_LONG).show();
                break;
            case R.id.three:
                Toast.makeText(this,"Three",Toast.LENGTH_LONG).show();
                break;
                default:
        }
        return super.onOptionsItemSelected(item);
    }
}
