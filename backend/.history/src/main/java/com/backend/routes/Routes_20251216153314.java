package com.backend.routes;

import jakarta.persistence.*;

@Entity
@Table(name = "book_tbl")
public class Routes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = )
    private Integer bookId;
}
