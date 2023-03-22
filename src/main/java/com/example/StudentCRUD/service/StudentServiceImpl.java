package com.example.StudentCRUD.service;

import com.example.StudentCRUD.entity.Student;
import com.example.StudentCRUD.exception.ResourceNotFoundException;
import com.example.StudentCRUD.repository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRespository studentRespository;
    @Override
    public List<Student> getAllStudent() {
        return studentRespository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRespository.save(student);
    }

    @Override
    public Student getStudentById(int ID) {
        Optional<Student> student = studentRespository.findById(ID);
        if(student.isPresent()){
            return student.get();
        }else {
            throw new ResourceNotFoundException("Student", "ID", ID);
        }
    }

    @Override
    public Student updateStudent(Student student, int ID) {
        Student existingStudent = studentRespository.findById(ID).orElseThrow(
                ()-> new ResourceNotFoundException("Student", "ID", ID));

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentRespository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteStudent(int ID) {
        studentRespository.findById(ID).orElseThrow(
                ()-> new ResourceNotFoundException("Student", "ID", ID));

        studentRespository.deleteById(ID);
    }

}
