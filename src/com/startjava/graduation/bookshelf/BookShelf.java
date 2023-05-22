package com.startjava.graduation.bookshelf;

public class BookShelf {
    private final int maxBooks;
    private int booksCount;
    private int freePlaces;
    private Book[] books;
    private int maxLength;

    public BookShelf(int maxBooks) {
        this.booksCount = 0;
        this.maxBooks = maxBooks;
        this.books = new Book[maxBooks - 1];
        freePlaces = maxBooks;
        maxLength = 0;
    }

    public int getBooksCount() {
        return booksCount;
    }

    public int getFreePlaces() {
        return freePlaces;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength() {
        maxLength = 0;
        for (Book book : books) {
            int len = book.getInfoLength();
            if (len > maxLength) {
                maxLength = len;
            }
        }
    }

    public void addBook(String author, String title, String publishYear) {
        author = author.trim();
        title = title.trim();
        publishYear = publishYear.trim();
        if (freePlaces < 1) {
            throw new ArrayIndexOutOfBoundsException("В шкафу нет места");
        }
        if (author.isBlank() || title.isBlank() || publishYear.isBlank()) {
            throw new IllegalArgumentException("Ошибка добавления.Поля Автор, Имя, Год должны быть заполненны");
        }
        try {
            findBook(author + " , " + title + " , " + publishYear);
            throw new ArrayIndexOutOfBoundsException("Ошибка добавления.Книга уже существует");
        } catch (NullPointerException e) {
            books[booksCount] = new Book(author, title, publishYear);
            int bookLength = books[booksCount].getInfoLength();
            if (bookLength > maxLength) {
                maxLength = bookLength;
            }
            booksCount++;
            freePlaces--;
        }
    }

    public Book findBook(String bookStr) {
        for (Book book : books) {
            if (book.toString().toLowerCase().contains(bookStr.toLowerCase())) {
                return book;
            }
        }
        throw new NullPointerException("Книга не найдена");
    }

    public int findIndexBook(String bookStr) {
        int index = 0;
        for (Book book : books) {
            if (book.toString().toLowerCase().contains(bookStr.toLowerCase())) {
                return index;
            }
            index++;
        }
        throw new NullPointerException("Книга не найдена");
    }

    public void deleteBook(String bookStr) {
        int index;
        try {
            index = findIndexBook(bookStr);
        } catch (NullPointerException e) {
            throw new NullPointerException("Книга не найдена");
        }
        if (booksCount == 1) {
            clear();
            return;
        }
        try {
            Book[] copyBooks = new Book[booksCount - 1];
            int len = books[index].getInfoLength();
            System.arraycopy(books, 0, copyBooks, 0, index);
            System.arraycopy(books, index + 1, copyBooks, index, booksCount - index - 1);
            books = copyBooks;
            if (maxLength == len) {
                setMaxLength();
            }
            booksCount--;
            freePlaces++;
        } catch (IndexOutOfBoundsException | ArrayStoreException | NullPointerException e) {
            throw new NullPointerException("Ошибка при удалении книги");
        }
    }

    public Book[] getAllBooks() {
        Book[] copyBooks = new Book[booksCount];
        System.arraycopy(books, 0, copyBooks, 0, booksCount);
        return copyBooks;
    }

    public void clear() {
        for (int i = 0; i < maxBooks; i++) {
            books[i] = null;
        }
        booksCount = 0;
        freePlaces = maxBooks;
        maxLength = 0;
    }
}
