package com.example.DemoSpring.Service;

import com.example.DemoSpring.Model.Student;
import com.example.DemoSpring.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //getting all student records
    public List<Student> getAllStudent(){
        List<Student> students= new ArrayList<Student>();

        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }


    //getting a specific record
    public Student getStudentById(int id){
        return studentRepository.findById(id).get();
    }

    public void saveOrUpdate(Student student){
        studentRepository.save(student);
    }

    public void delete(int id){
        studentRepository.deleteById(id);
    }

    public void update(Student student){studentRepository.save(student);}

}
