package bd.com.seip.retrofitgetpost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bd.com.seip.retrofitgetpost.retrofit.ApiClieant;
import bd.com.seip.retrofitgetpost.retrofit.RetrofitInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
private RecyclerView recyclerView;
private UserAdapter userAdapter;
private List<User> userList;
private RetrofitInterface retrofitInterface;

private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofitInterface= ApiClieant.getInstance().getApi();
        init();
       /* getData();*/

    }

    /*private void getData() {
        retrofitInterface= ApiClieant.getInstance().getApi();
        Call<List<User>> usersCall=retrofitInterface.getDatas();
        usersCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                userList=response.body();
                userAdapter=new UserAdapter(userList);
                progressBar.setVisibility(View.GONE);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    private void init() {
        progressBar=findViewById(R.id.progerssBar);
        recyclerView=findViewById(R.id.userRecyclerView);
        userList=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void search(View view) {
        Call<List<User>> searchCall=retrofitInterface.getSearch(2);
        searchCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                 userList=response.body();
                userAdapter=new UserAdapter(userList);
                progressBar.setVisibility(View.GONE);
                recyclerView.setAdapter(userAdapter);
                Toast.makeText(MainActivity.this, "Success ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
