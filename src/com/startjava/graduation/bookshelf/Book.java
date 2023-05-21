package com.startjava.graduation.bookshelf;

public class Book {
    private String author;
    private String title;
    private String publishYear;
    private int infoLength;

    public Book(String author, String title, String publishYear ) {
        this.author = author;
        this.title = title;
        this.publishYear = publishYear;
        this.infoLength = this.toString().length();
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

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public int getInfoLength() {
        return infoLength;
    }

    public void setInfoLength(int infoLength) {
        this.infoLength = this.toString().length();
    }

    @Override
    public String toString() {
        return  author + " , " + title+ " , " + publishYear;
    }
}
