package org.example.lab2crud.controllers;

import org.example.lab2crud.models.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    List<Book> books = new ArrayList<>();

    @GetMapping(value = "", produces = "application/v1+json")
    public List<Book> getBooks1() {

        books.add(new Book(1,"Few Deu Remaining", "Abu Yusuf", 35.89));
        books.add(new Book(2,"Good People In Cloud", "Berge Dow", 3.89));
        return books;
    }

    @GetMapping(value = "", produces = "application/v2+json")
    public List<Book> getBooks2() {

        books.add(new Book(1,"Few Deu Remaining", "Abu Yusuf", 30.89));
        books.add(new Book(2,"Good People In Cloud", "Berge Dow", 4.89));
        return books;
    }

    @GetMapping(value = "/{id}", headers = "API-VERSION=1")
    public ResponseEntity<Book> getBook1(@PathVariable int id) {

        if(id == 1){
            Book b  = new Book(1,"Few Deu Remaining v1", "Abu Yusuf", 35.89);
            return new ResponseEntity<>(b, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping(value = "/{id}", headers = "API-VERSION=2")
    public ResponseEntity<Book> getBook2(@PathVariable int id) {

        if(id == 1){
            Book b  = new Book(1,"Few Deu Remaining v1", "Abu Yusuf", 35.89);
            return new ResponseEntity<>(b, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping(value = "", params = "v=1")
    public ResponseEntity<Book> save1(@RequestBody Book book) {
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PostMapping(value = "", params = "v=2")
    public ResponseEntity<Book> save2(@RequestBody Book book) {
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable int id , @RequestBody Book book) {
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if(id == 1){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
   }

}
