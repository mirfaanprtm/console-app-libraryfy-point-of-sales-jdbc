package org.example.models;

import java.util.List;
import java.util.stream.Stream;

public class Books {
    private String id;
    private String title;
    private Integer publication_year;
    private String author;
    private String publisher;
    private String category_id;

    public Books(String id, String title, Integer publication_year, String author, String publisher, String category_id) {
        this.id = id;
        this.title = title;
        this.publication_year = publication_year;
        this.author = author;
        this.publisher = publisher;
        this.category_id = category_id;
    }

    public Books() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(Integer publication_year) {
        this.publication_year = publication_year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publication_year=" + publication_year +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", categories=" + category_id +
                '}';
    }
}
