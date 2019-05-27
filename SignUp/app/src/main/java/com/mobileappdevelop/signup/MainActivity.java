package com.mobileappdevelop.signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText fistName, lastName, email, password;
    private CheckBox conditionChk;
    private RadioButton mail, femail;
    private Button sing;
    private TextView singIn;
   private AutoCompleteTextView blootgroup;
String[] blootGroopACTV={"A+","A-","B+","B-","AB+","AB-","O+","O-"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fistName=findViewById(R.id.firstET);
        lastName=findViewById(R.id.lastET);
        email=findViewById(R.id.emailET);
        password=findViewById(R.id.passwordlET);
        conditionChk=findViewById(R.id.conditionchkB);
        mail=findViewById(R.id.mailRB);
        femail=findViewById(R.id.femailRB);
        sing=findViewById(R.id.signBtn);
        singIn=findViewById(R.id.signInBtn);

        blootgroup=findViewById(R.id.bloodACTV);
        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,blootGroopACTV);
        blootgroup.setAdapter(adapter);
        blootgroup.setThreshold(1);



    }
}
