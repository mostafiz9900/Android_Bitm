package com.bitm.databasehelper_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
private Context context;
private List<Student> studentList;
private DatabaseHelper databaseHelper;

    public StudentAdapter(Context context, List<Student> studentList, DatabaseHelper helper) {
        this.context = context;
        this.studentList = studentList;
        this.databaseHelper = helper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Student currentStudent = studentList.get(position);
        holder.nameTV.setText(currentStudent.getName());
        holder.ageTV.setText(currentStudent.getAge());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                databaseHelper=new DatabaseHelper(context);
                databaseHelper.deleteDate(currentStudent.getId());
                return false;
            }
        });


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTV, ageTV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.nameTv);
            ageTV = itemView.findViewById(R.id.ageTV);
            databaseHelper =new DatabaseHelper(context);
        }
    }
}
