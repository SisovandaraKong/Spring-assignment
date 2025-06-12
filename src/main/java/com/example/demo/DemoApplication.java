package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner run (StudentServiceImpl studentService){
		return (args) -> {
			while (true){
				System.out.println("""
				1. Add new student
				2. View all students
				3. View student by ID
				4. Update student by ID
				5. Delete student by ID	
				6. Exit program
				""");
				System.out.print("Enter your choice: ");
				int opt = new Scanner(System.in).nextInt();
				switch(opt){
					case 1:
						System.out.print("Enter student ID: ");
						int	id = new Scanner(System.in).nextInt();
						System.out.print("Enter student full name: ");
						String fullName = new Scanner(System.in).nextLine();
						System.out.print("Enter student gender: ");
						String gender = new Scanner(System.in).nextLine();
						System.out.print("Enter student score: ");
						double score = new Scanner(System.in).nextDouble();
						Student newStudent = new Student(id,fullName,gender,score);
						studentService.addStudent(newStudent);
						System.out.println("Student added successfully");
						break;
					case 2:
						System.out.println("View all students");
						for(Student student : studentService.getAllStudents()){
							System.out.println(student);
						}
						break;
					case 3:
						System.out.print("Enter student ID: ");
						studentService.getStudentById(new Scanner(System.in).nextInt());
						break;
					case 4:
						System.out.print("Enter student ID to update: ");
						int updateId = new Scanner(System.in).nextInt();
						studentService.getStudentById(updateId);
						System.out.print("Enter student full name: ");
						String newFullName = new Scanner(System.in).nextLine();
						System.out.print("Enter student gender: ");
						String newGender = new Scanner(System.in).nextLine();
						System.out.print("Enter student score: ");
						double newScore = new Scanner(System.in).nextDouble();
						Student updatedStudent = new Student(updateId,newFullName,newGender,newScore);
						studentService.updateStudentById(updateId,updatedStudent);
						System.out.println("Student updated successfully");
						break;
					case 5:
						System.out.print("Enter student ID to delete: ");
						int deleteId = new Scanner(System.in).nextInt();
						studentService.deleteStudentById(deleteId);
						System.out.println("Student deleted successfully");
						break;
					case 6:
						System.exit(0);
						break;
					default:
						System.out.println("Invalid option");
						break;

				}
			}

		};
	}
}
