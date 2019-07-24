package com.bitm.firebasedatainsertlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bitm.firebasedatainsertlist.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
              /*  User user=new User(name, email, Integer.valueOf(age),blood);
                userList.add(user);*/
                userInsert(name,email,age,blood);


     
            }
        });
        
        getUsers();
    }

    private void getUsers() {
        DatabaseReference userRef=databaseReference.child("usersLevel");
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    userList.clear();
                    for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                        User user=snapshot.getValue(User.class);
                        userList.add(user);
                        userAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void userInsert(String name, String email, String age, String blood) {

    User user=new User(name, email,Integer.valueOf(age),blood);
    DatabaseReference userRef=databaseReference.child("usersLevel");
    userRef.push().setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {
            if (task.isSuccessful()){
                Toast.makeText(getApplicationContext(), "Successful Insert", Toast.LENGTH_SHORT).show();
            }
        }
    });
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
