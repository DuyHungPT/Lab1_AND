package com.example.lab1_and.Model;

public class StudentModel {

    public class Student {
        private String name;
        private String studentId;
        private double gpa;
        private int avatar;

        public Student(String name, String studentId, double gpa, int avatar) {
            this.name = name;
            this.studentId = studentId;
            this.gpa = gpa;
            this.avatar = avatar;
        }

        public String getName() {
            return name;
        }

        public String getStudentId() {
            return studentId;
        }

        public double getGpa() {
            return gpa;
        }

        public int getAvatar() {
            return avatar;
        }
    }
}
