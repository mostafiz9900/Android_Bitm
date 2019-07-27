package com.beskilled.retropicjsonformate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> userList;

    public UserAdapter( List<User> userList) {

        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user=userList.get(position);

      holder.userIdTV.setText("User Id : "+String.valueOf(user.getUserId()));
      holder.idTV.setText("Id : "+String.valueOf(user.getId()));
      holder.titleTV.setText("Title : "+user.getTitle());
      holder.bodyTV.setText("Body : "+user.getBody());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView userIdTV, idTV,titleTV,bodyTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userIdTV=itemView.findViewById(R.id.userIdTV);
            idTV=itemView.findViewById(R.id.idTV);
            titleTV=itemView.findViewById(R.id.titleTV);
            bodyTV=itemView.findViewById(R.id.bodyTV);
        }
    }
}
