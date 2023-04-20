package com.example.DemoSpring.Controller;


import com.example.DemoSpring.Model.Book;
import com.example.DemoSpring.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping("/student/{studentId}/books")
    public List<Book> getAllBooksByStudentId(@PathVariable int studentId){
        return bookService.getAllBooksByStudentId(studentId);
    }

    @PostMapping("/student/{studentId}/books")
    public void addBookToStudent(@PathVariable int studentId, @RequestBody Book book){
        bookService.addBookToStudent(studentId,book);
    }

    @DeleteMapping("/student/{studentId}/books/{bookId}")
    public void deleteBookFromStudent(@PathVariable int studentId, @PathVariable int bookId){
        bookService.deleteBookFromStudent(studentId,bookId);
    }

    @PutMapping("/student/{studentId}/books/{bookId}")
    public void updateBookFromStudent(@PathVariable int studentId, @PathVariable int bookId, @RequestBody Book book){
        bookService.updateBookFromStudent(studentId,bookId,book);
    }

}
