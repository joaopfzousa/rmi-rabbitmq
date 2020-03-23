package edu.ufp.inf.sd.rmi.diglib.server;

import java.io.Serializable;

public class Book implements Serializable {

    private String author;
    private String title;

    public Book(String author, String title) {
        this.setAuthor(author);
        this.setTitle(title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

