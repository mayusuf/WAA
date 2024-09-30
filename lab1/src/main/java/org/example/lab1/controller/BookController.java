package org.example.lab1.controller;

import org.example.lab1.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @GetMapping("/")
    public List<Book> index() {

        List<Book> books = new ArrayList<>();
        Book book1 = new Book(1, "Womnen In Heaven", "Mark Juvan", 1000.99);
        Book book2 = new Book(1, "Baby in Morket Garden", "Pure Kori", 12.99);
        Book book3 = new Book(1, "Men wiithout Flaws", "Mathew Hard", 6.02);

        books.add(book1);
        books.add(book3);
        books.add(book2);

        return books;
    }


}
