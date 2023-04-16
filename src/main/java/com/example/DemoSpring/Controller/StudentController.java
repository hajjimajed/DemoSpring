package com.example.DemoSpring.Controller;

import com.example.DemoSpring.Model.Student;
import com.example.DemoSpring.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    private List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/student/{id}")
    private Student getStudent(@PathVariable("id") int id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/student/{id}")
    private void deleteStudent(@PathVariable("id") int id){
        studentService.delete(id);
    }

    @PostMapping("/student")
    private int saveStudent(@RequestBody Student student){
        studentService.saveOrUpdate(student);
        return student.getId();
    }

}
