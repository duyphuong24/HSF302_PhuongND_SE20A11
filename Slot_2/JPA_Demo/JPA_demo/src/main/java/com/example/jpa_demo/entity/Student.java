package com.example.jpa_demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullname;
    private String email;
    private int age;


    public Student(String name, String email, int age) {
        this.fullname = name;
        this.email = email;
        this.age = age;
    }
}
