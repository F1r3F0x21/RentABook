package com.example.myapplication.Book;

public class Book {
    public String title;
    public String author;
    public String genre;
    public String releaseDate;
    public Long serialNumber; // Changed from String to Long

    public Book() {
        // Default constructor required for calls to DataSnapshot.getValue(com.example.myapplication.Book.Book.class)
    }

    public Book(String title, String author, String genre, String releaseDate, Long serialNumber) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.serialNumber = serialNumber;
    }

    // getters and setters
    // Remember to change the getter and setter for serialNumber to return and accept Long instead of String
    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }
}
