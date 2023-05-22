package com.startjava.graduation.bookshelf;

public class Book {
    private final String author;
    private final String title;
    private final String publishYear;
    private final int infoLength;

    public Book(String author, String title, String publishYear) {
        this.author = author;
        this.title = title;
        this.publishYear = publishYear;
        infoLength = toString().length();
    }

    public int getInfoLength() {
        return infoLength;
    }

    @Override
    public String toString() {
        return author + " , " + title + " , " + publishYear;
    }
}