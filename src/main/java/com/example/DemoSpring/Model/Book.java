package com.example.DemoSpring.Model;

import jakarta.persistence.*;

@Entity
public class Book {

    @Id
    @Column
    private int id;
    @Column
    private String title;
    @Column
    private String author;

    @ManyToOne
    @JoinColumn(name ="student_id")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
