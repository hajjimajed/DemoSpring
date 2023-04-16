package com.example.DemoSpring.Repository;

import com.example.DemoSpring.Model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
