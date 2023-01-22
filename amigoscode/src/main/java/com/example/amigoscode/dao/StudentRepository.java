package com.example.amigoscode.dao;

import com.example.amigoscode.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
