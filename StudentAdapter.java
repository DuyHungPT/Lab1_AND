package com.example.lab1_and.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab1_and.Model.StudentModel;
import com.example.lab1_and.R;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
private List<StudentModel.Student> students;

public StudentAdapter(List<StudentModel.Student> students) {
        this.students = students;
        }

public static class StudentViewHolder extends RecyclerView.ViewHolder {
    ImageView imageViewAvatar;
    TextView textViewName, textViewStudentId, textViewGPA;
    ImageButton imageButtonEdit, imageButtonDelete;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewStudentId = itemView.findViewById(R.id.textViewStudentId);
        textViewGPA = itemView.findViewById(R.id.textViewGPA);
        imageButtonEdit = itemView.findViewById(R.id.imageButtonEdit);
        imageButtonDelete = itemView.findViewById(R.id.imageButtonDelete);
    }
}

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        StudentModel.Student currentStudent = students.get(position);
        holder.imageViewAvatar.setImageResource(currentStudent.getAvatar());
        holder.textViewName.setText(currentStudent.getName());
        holder.textViewStudentId.setText(currentStudent.getStudentId());
        holder.textViewGPA.setText(String.valueOf(currentStudent.getGpa()));

        holder.imageButtonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện khi nút sửa được nhấn
            }
        });

        holder.imageButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện khi nút xóa được nhấn
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
