package org.example.LAB3;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book() {}

    public Book(int id, String title, String author, boolean isBorrowed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = isBorrowed;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author +
                ", Borrowed: " + isBorrowed;
    }
}