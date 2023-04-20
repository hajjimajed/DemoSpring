package com.example.DemoSpring.Model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String email;



    @OneToMany(mappedBy = "student",
    cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Book> books=new ArrayList<>();



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
