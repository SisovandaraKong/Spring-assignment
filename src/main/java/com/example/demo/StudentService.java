package com.example.demo;

import java.util.List;

public interface StudentService {
    String addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int id);
    Student updateStudentById(int id, Student student);
    Integer deleteStudentById(int id);
}
