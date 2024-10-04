package org.example.lab3jpahibernate.model.dao.UnidirectionalOneToOne;

import jakarta.persistence.*;

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
