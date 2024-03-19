package com.example.lab1_and;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab1_and.Adapter.StudentAdapter;
import com.example.lab1_and.Model.StudentModel.Student;
import com.example.lab1_and.Model.StudentModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Student> students = new ArrayList<>();
        StudentModel studentModel = new StudentModel(); // Tạo một đối tượng StudentModel
        students.add(studentModel.new Student("Nguyen Ngoc Ngan", "123456", 3.5, R.drawable.img_4));
        students.add(studentModel.new Student("Nguyen Ngoc Son", "654321", 3.8, R.drawable.img_4));

        StudentAdapter adapter = new StudentAdapter(students);
        recyclerView.setAdapter(adapter);
    }
}
