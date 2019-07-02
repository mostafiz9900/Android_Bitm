package com.example.recyclerviewex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private List<Movie> movieList;
private RecyclerView recyclerView;
private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        recyclerviewCon();
        getMoviData();
    }

    private void recyclerviewCon() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(movieAdapter);

    }

    private void getMoviData() {
        Movie movie=new Movie("Lifestyle","Mostafizur",R.drawable.clock);
        Movie movie2=new Movie("Pram amar","Mahabur",R.drawable.mostafiz);
        movieList.add(movie);
        movieList.add(movie2);
        movieList.add(movie);
        movieList.add(movie2);
        movieList.add(movie);
        movieList.add(movie2);
        movieList.add(movie);
        movieList.add(movie2);
        movieList.add(movie);
        movieList.add(movie2);
        movieList.add(movie);
        movieList.add(movie2);


        movieAdapter.notifyDataSetChanged();
    }


    private void init() {
        movieList=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerLayout);
        movieAdapter=new MovieAdapter(movieList,this);
    }
}
