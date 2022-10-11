package com.example.mouri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mouri.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{



}
