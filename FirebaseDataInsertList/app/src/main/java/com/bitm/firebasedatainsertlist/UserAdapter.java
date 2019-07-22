package com.bitm.firebasedatainsertlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolher> {
    private List<User> userList;
    private Context context;

    public UserAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolher onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new ViewHolher(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolher holder, int position) {
        User currentUser = userList.get(position);
        holder.name.setText(currentUser.getName());
        holder.email.setText(currentUser.getEmail());
        //holder.age.setText(currentUser.getAge());
        holder.blood.setText(currentUser.getBloodGroup());


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolher extends RecyclerView.ViewHolder {
        private TextView name, email, age, blood;

        public ViewHolher(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameTv);
            email = itemView.findViewById(R.id.emailTv);
            age = itemView.findViewById(R.id.ageEt);
            blood = itemView.findViewById(R.id.bloodGroupTv);
        }
    }
}
