package com.example.DemoSpring.Service;


import com.example.DemoSpring.Model.Book;
import com.example.DemoSpring.Model.Student;
import com.example.DemoSpring.Repository.BookRepository;
import com.example.DemoSpring.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;
    private StudentRepository studentRepository;

    @Autowired
    public BookService(BookRepository bookRepository, StudentRepository studentRepository){
        this.bookRepository=bookRepository;
        this.studentRepository=studentRepository;
    }

    public List<Book> getAllBooksByStudentId(int studentId){
        Student student=studentRepository.findById(studentId).orElseThrow();
        return student.getBooks();
    }

    public void addBookToStudent(int studentId, Book book){
        Student student=studentRepository.findById(studentId).orElseThrow();
        student.getBooks().add(book);
        book.setStudent(student);
        bookRepository.save(book);
    }

    public void deleteBookFromStudent(int studentId, int bookId) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Book book = bookRepository.findById(bookId).orElseThrow();
        student.getBooks().remove(book);
        book.setStudent(null);
        bookRepository.delete(book);
    }

    public void updateBookFromStudent(int studentId, int bookId, Book book) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        Book oldBook = bookRepository.findById(bookId).orElseThrow();
        oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(book.getAuthor());
        bookRepository.save(oldBook);
    }


}
