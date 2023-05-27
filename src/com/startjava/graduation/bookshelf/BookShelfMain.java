package com.startjava.graduation.bookshelf;

import java.lang.module.FindException;
import java.util.Scanner;

public class BookShelfMain {
    private static BookShelf bookShelf;
    private static Scanner console;

    public static void main(String[] args) {
        console = new Scanner(System.in);
        String answer;
        bookShelf = new BookShelf(10);
        do {
            showShelf();
            printMenu();
            answer = console.nextLine();
            switch (answer) {
                case "1" -> addBook();
                case "2" -> findBook();
                case "3" -> deleteBook();
                case "4" -> clearBookShelf();
                case "5" -> {
                    System.out.println("Пока!");
                    return;
                }
                default -> System.out.println("Пункт меню не распознан, повторите ввод");
            }
            printEnter();
        } while (true);
    }

    private static void showShelf() {
        Book[] books = bookShelf.getAll();
        if (books.length == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
            return;
        } else {
            System.out.println("В шкафу " + bookShelf.getCountBooks() +
                    " книг и " + bookShelf.getFreePlaces() + " свободных полок.");
        }
        for (Book book : books) {
            showBook(book, bookShelf.getMaxLength());
        }
    }

    private static void printMenu() {
        System.out.println("""
                1. Добавить книгу
                2. Найти книгу
                3. Удалить книгу
                4. Очистить шкаф
                5. Выйти
                """);
    }

    private static void addBook() {
        while (true) {
            System.out.println("Введите автора");
            String author = console.nextLine().trim();
            System.out.println("Введите заголовок");
            String title = console.nextLine().trim();
            System.out.println("Введите год издания");
            String publishYear = console.nextLine().trim();
            if (author.isBlank() || title.isBlank() || publishYear.isBlank()) {
                System.out.println("Ошибка добавления.Поля Автор, Имя, Год должны быть заполненны");
                continue;
            }
            Book book = new Book(author, title, publishYear);
            try {
                bookShelf.add(book);
                System.out.println("Книга успешно добавлена");
                break;
            } catch (ArrayStoreException | ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage() + "\n");
                break;
            }
        }
    }

    private static void findBook() {
        System.out.println("Введите строку для поиска");
        String title = console.nextLine();
        Book book = bookShelf.find(title);
        if (book != null) {
            showBook(book, bookShelf.getMaxLength());
        } else {
            System.out.println("Книга не найдена");
        }
    }

    private static void showBook(Book book, int maxLength) {
        System.out.printf("|%-3s|\n", "-".repeat(maxLength));
        System.out.printf("|%-3s%s|\n", book, " ".repeat(maxLength - book.getInfoLength()));
        System.out.printf("|%-3s|\n", "-".repeat(maxLength));
    }

    private static void deleteBook() {
        System.out.println("Введите строку для поиска книги для удаления");
        String title = console.nextLine();
        try {
            bookShelf.delete(title);
            System.out.println("Книга удалена");
        } catch (FindException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    private static void clearBookShelf() {
        bookShelf.clear();
        System.out.println("Шкаф был очищен");
    }

    private static void printEnter() {
        String str = ".";
        while (!str.isBlank()) {
            System.out.println("Для продолжения работы нажмите <Enter> ");
            str = console.nextLine();
        }
    }
}


