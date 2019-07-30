package com.beskilled.retrofitjsonformatetwo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = userList.get(position);
        holder.userId.setText("User Id : "+String.valueOf(user.getUserId()));
        holder.id.setText("Id : "+String.valueOf(user.getId()));
        holder.title.setText("Title : "+user.getTitle());
        holder.body.setText("Body : "+user.getBody());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userId, id, title, body;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userId = itemView.findViewById(R.id.userIdTV);
            id = itemView.findViewById(R.id.idTV);
            title = itemView.findViewById(R.id.titleTV);
            body = itemView.findViewById(R.id.bodyTV);
        }
    }
}
