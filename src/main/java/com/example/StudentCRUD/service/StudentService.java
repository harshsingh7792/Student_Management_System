package com.example.StudentCRUD.service;

import com.example.StudentCRUD.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Student saveStudent(Student student);
    Student getStudentById(int ID);
    Student updateStudent(Student student, int ID);
    void deleteStudent(int ID);
}
