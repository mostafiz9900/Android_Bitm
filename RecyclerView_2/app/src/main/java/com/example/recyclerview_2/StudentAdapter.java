package com.example.recyclerview_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private List<Student> studentList;

    public StudentAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_students, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student currentStudent = studentList.get(position);

        holder.sName.setText("Name : " + currentStudent.getsName());
        holder.sDepat.setText("Departmetn : " + currentStudent.getsDept());
        holder.sBatch.setText("Batch : " + currentStudent.getsBach());
        holder.sAge.setText("Age : " + currentStudent.getsAge());
        holder.sImageView.setImageResource(currentStudent.getsImage());

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView sName, sDepat, sBatch, sAge;
        private ImageView sImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sName = itemView.findViewById(R.id.sNameTV);
            sDepat = itemView.findViewById(R.id.sDeptTV);
            sBatch = itemView.findViewById(R.id.sBatchTV);
            sAge = itemView.findViewById(R.id.sAgeTV);
            sImageView = itemView.findViewById(R.id.sIV);
        }
    }
}
