package com.example.demo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InMemoryDatabase {
    List<Student> students =new ArrayList<>(List.of(
            new Student(1, "Dara", "male", 80.2),
            new Student(2, "Bora", "male", 80.0),
            new Student(3, "Sokha", "female", 85.5),
            new Student(4, "Rith", "male", 75.3),
            new Student(5, "Sreymom", "female", 90.0),
            new Student(6, "Vuthy", "male", 68.9),
            new Student(7, "Sokun", "female", 72.5),
            new Student(8, "Pisey", "female", 88.1),
            new Student(9, "Chenda", "female", 91.4),
            new Student(10, "Mony", "male", 77.8)
    ));

}
