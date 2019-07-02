package com.example.recyclerviewex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private List<Movie> movieList;
    private Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);


        return new ViewHolder(itemView);


    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Movie currentMovi = movieList.get(position);
        holder.image.setImageResource(currentMovi.getImage());
        holder.nameTV.setText(currentMovi.getName());
        holder.directorTV.setText(currentMovi.getDirectorName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,DetailesActivityf.class);
                intent.putExtra("name",currentMovi.getName());
                intent.putExtra("director",currentMovi.getDirectorName());
                intent.putExtra("image",currentMovi.getImage());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTV, directorTV;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.nameTV);
            directorTV = itemView.findViewById(R.id.directoTV);
            image = itemView.findViewById(R.id.imageIV);
        }
    }
}
