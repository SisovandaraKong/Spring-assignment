package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    InMemoryDatabase database;
    @Override
    public String addStudent(Student student) {
        database.students.add(student);
        return student.toString();
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        for (Student student : database.students) {
            students.add(student);
        }
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        for (Student student : database.students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public Student updateStudentById(int id, Student student) {
        for ( Student stud : database.students) {
            if (stud.getId() == id) {
                database.students.set(id, student); // Replace the student at the same position
                return student;
            }
        }
        return student;
    }

    @Override
    public Integer deleteStudentById(int id) {
        for (Student student : database.students) {
            if (student.getId() == id) {
                database.students.remove(student);
            }
        }
        return id;
    }
}
