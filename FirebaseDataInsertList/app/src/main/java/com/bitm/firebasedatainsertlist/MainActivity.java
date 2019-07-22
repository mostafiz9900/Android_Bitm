package com.bitm.firebasedatainsertlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bitm.firebasedatainsertlist.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private List<User> userList;
private RecyclerView recyclerView;
private UserAdapter userAdapter;
private FirebaseAuth firebaseAuth;
private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);

        init();
        initRecyclerView();
       /* String name=binding.nameEt.getText().toString().trim();
        String email=binding.emailEt.getText().toString().trim();
        String age=binding.ageEt.getText().toString().trim();
        String blood=binding.bloodGroupEt.getText().toString().trim();
        User user=new User(1,"Mostafiz","mostafiz@gmail.com",27,"O+");*/
       /* userList.add(user);*/
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=binding.nameEt.getText().toString().trim();
                String email=binding.emailEt.getText().toString().trim();
                String age=binding.ageEt.getText().toString().trim();
                String blood=binding.bloodGroupEt.getText().toString().trim();
                User user=new User(name, email, Integer.valueOf(age),blood);
                userList.add(user);
                userInsert(name,email,age,blood);


            }
        });
    }

    private void userInsert(String name, String email, String age, String blood) {

    User user=new User(name, email,Integer.valueOf(age),blood);
}
    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);
    }

    private void init() {
        userList=new ArrayList<>();
        recyclerView=findViewById(R.id.userRCV);
        userAdapter=new UserAdapter(userList,this);
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
    }
}
