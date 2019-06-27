package com.example.recyclearviewinput;

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
        holder.studentIdTV.setText("Id : " + currentStudent.getStudentId());
        holder.studentNameTV.setText("Name : " + currentStudent.getStudentName());
        holder.studentAgeTV.setText("Age : " + currentStudent.getStudentAge());
        holder.studentEmailTV.setText("Email : " + currentStudent.getStudentEmail());
        holder.studetnImageIV.setImageResource(currentStudent.getStudentImage());


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView studentNameTV, studentIdTV, studentAgeTV, studentEmailTV;
        private ImageView studetnImageIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            studentIdTV = itemView.findViewById(R.id.idTV);
            studentNameTV = itemView.findViewById(R.id.nameTV);
            studentAgeTV = itemView.findViewById(R.id.ageTV);
            studentEmailTV = itemView.findViewById(R.id.emailTV);
            studetnImageIV = itemView.findViewById(R.id.studentIV);


        }
    }
}
