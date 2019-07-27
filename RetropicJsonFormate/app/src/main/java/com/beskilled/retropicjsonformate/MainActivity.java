package com.beskilled.retropicjsonformate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.beskilled.retropicjsonformate.retrofit.ApiClient;
import com.beskilled.retropicjsonformate.retrofit.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private List<User> userList;
    private UserAdapter userAdapter;
    private RecyclerView recyclerView;
    private RetrofitInterface retrofitInterface;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initRecyclerView();
        getData();


    }

    private void getData() {
        retrofitInterface = ApiClient.getInstance().getapi();
        Call<List<User>> listCall = retrofitInterface.getUser();
        listCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList = response.body();
                userAdapter = new UserAdapter(userList);
                recyclerView.setAdapter(userAdapter);
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void init() {
        userList = new ArrayList<>();
        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.userRCV);

    }
}
