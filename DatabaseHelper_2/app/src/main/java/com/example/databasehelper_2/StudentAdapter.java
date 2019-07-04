package com.example.databasehelper_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private Context context;
    private List<Student> studentList;
    private DatabaseHelper helper;

    public StudentAdapter(Context context, List<Student> studentList, DatabaseHelper helper) {
        this.context = context;
        this.studentList = studentList;
        this.helper = helper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student currentStudent = studentList.get(position);
        holder.nameTv.setText(currentStudent.getName());
        holder.ageTv.setText(currentStudent.getAge());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTv, ageTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTV);
            ageTv = itemView.findViewById(R.id.ageTv);

            studentList = new ArrayList<>();
            helper = new DatabaseHelper(context);
        }
    }
}
