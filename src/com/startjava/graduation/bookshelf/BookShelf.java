package com.startjava.graduation.bookshelf;

import java.lang.module.FindException;
import java.util.Arrays;

public class BookShelf {
    private final int maxBooks;
    private final Book[] books;
    private int countBooks;
    private int maxLength;

    public BookShelf(int maxBooks) {
        this.maxBooks = maxBooks;
        books = new Book[maxBooks];
    }

    public int getCountBooks() {
        return countBooks;
    }

    public int getFreePlaces() {
        return maxBooks - countBooks;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void add(Book book) {
        if (countBooks == maxBooks) {
            throw new ArrayIndexOutOfBoundsException("В шкафу нет места");
        }

        int index = findIndex(book.getTitle());
        if (index == -1) {
            books[countBooks] = book;
            changeLengthIfMax(books[countBooks].getInfoLength());
            countBooks++;
        } else {
            throw new ArrayStoreException("Ошибка добавления.Книга уже существует");
        }
    }

    public Book find(String title) {
        for (int i = 0; i < countBooks; i++) {
            if (books[i].getTitle().toLowerCase().contains(title.toLowerCase())) {
                return books[i];
            }
        }
        return null;
    }

    public Book[] getAll() {
        return Arrays.copyOf(books, countBooks);
    }

    public void delete(String title) {
        int index = findIndex(title);
        if (index == -1) {
            throw new FindException("Книга не найдена");
        }
        if (countBooks == 1) {
            clear();
            return;
        }
        int length = books[index].getInfoLength();
        System.arraycopy(books, index + 1, books, index, countBooks - index - 1);
        if (maxLength == length) {
            calculateMaxLength();
        }
        countBooks--;
    }

    public void clear() {
        Arrays.fill(books, 0, countBooks, null);
        countBooks = 0;
        maxLength = 0;
    }

    private int findIndex(String title) {
        for (int i = 0; i < countBooks; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    private void calculateMaxLength() {
        maxLength = 0;
        for (int i = 0; i < countBooks; i++) {
            changeLengthIfMax(books[i].getInfoLength());
        }
    }

    private void changeLengthIfMax(int length) {
        if (length > maxLength) {
            maxLength = length;
        }
    }
}
