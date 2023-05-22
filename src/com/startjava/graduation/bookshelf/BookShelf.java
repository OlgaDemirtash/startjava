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
        if (getFreePlaces() < 1) {
            throw new ArrayIndexOutOfBoundsException("В шкафу нет места");
        }
        try {
            find(book.toString());
            throw new ArrayStoreException("Ошибка добавления.Книга уже существует");
        } catch (FindException e) {
            books[countBooks] = book;
            lengthChangeIfMax(books[countBooks].getInfoLength());
            countBooks++;
        }
    }

    private void lengthChangeIfMax(int length) {
        if (length > maxLength) {
            maxLength = length;
        }
    }

    public Book find(String title) {
        for (int i = 0; i < countBooks; i++) {
            if (books[i].toString().toLowerCase().contains(title.toLowerCase())) {
                return books[i];
            }
        }
        throw new FindException("Книга не найдена");
    }

    private int findIndex(String title) {
        int index = 0;
        for (Book book : books) {
            if (book.toString().toLowerCase().contains(title.toLowerCase())) {
                return index;
            }
            index++;
        }
        throw new FindException("Книга не найдена");
    }

    public void delete(String title) {
        int index;
        try {
            index = findIndex(title);
        } catch (FindException e) {
            throw new FindException("Книга не найдена");
        }
        if (countBooks == 1) {
            clear();
            return;
        }
        try {
            int length = books[index].getInfoLength();
            System.arraycopy(books, index + 1, books, index, countBooks - index - 1);
            if (maxLength == length) {
                calculateMaxLength();
            }
            countBooks--;
        } catch (IndexOutOfBoundsException | ArrayStoreException | NullPointerException e) {
            throw new NullPointerException("Ошибка при удалении книги");
        }
    }

    private void calculateMaxLength() {
        maxLength = 0;
        for (Book book : books) {
            lengthChangeIfMax(book.getInfoLength());
        }
    }

    public Book[] getAll() {
        return Arrays.copyOf(books, countBooks);
    }

    public void clear() {
        Arrays.fill(books, null);
        countBooks = 0;
        maxLength = 0;
    }
}
