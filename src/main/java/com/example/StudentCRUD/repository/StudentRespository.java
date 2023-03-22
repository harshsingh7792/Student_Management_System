package com.example.StudentCRUD.repository;

import com.example.StudentCRUD.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespository extends JpaRepository<Student, Integer> {

}
