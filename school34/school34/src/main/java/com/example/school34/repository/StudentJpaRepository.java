package com.example.school34.repository;

import com.example.school34.domain.Department;
import com.example.school34.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentJpaRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s where department = :department")
    List<Student> findByDept(Department department);
}
