package com.tsi.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
// Define a entidade Book, que representa um livro na biblioteca
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer pages;

    private Integer publishedYear;
    
    @ManyToOne
    @JoinColumn(name = "author_id")
private Author author;
    public Book() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPages() {
        return pages;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }
    
    public Author getAuthor() {
    return author;
    }

    public void setAuthor(Author author) {
    this.author = author;
    }
}
