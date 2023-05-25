package com.startjava.graduation.bookshelf;

import java.lang.module.FindException;
import java.util.Scanner;

public class BookShelfMain {
    private static BookShelf bookShelf;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer;
        bookShelf = new BookShelf(10);
        do {
            showShelf();
            printMenu(bookShelf);
            answer = console.nextLine();
            switch (answer) {
                case "1" -> addBook(console);
                case "2" -> findBook(console);
                case "3" -> deleteBook(console);
                case "4" -> clearBookShelf();
                case "5" -> {
                    System.out.println("Пока!");
                    return;
                }
                default -> System.out.println("Пункт меню не распознан, повторите ввод");
            }
            printEnter(console);
        } while (!answer.trim().equals("5"));
    }

    private static void addBook(Scanner console) {
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

    private static void findBook(Scanner console) {
        Book book;
        System.out.println("Введите строку для поиска");
        String title = console.nextLine();
        try {
            book = bookShelf.find(title);
            showBook(book, bookShelf.getMaxLength());
        } catch (FindException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    private static void deleteBook(Scanner console) {
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

    private static void showShelf() {
        Book[] books = bookShelf.getAll();
        if (books.length == 0) {
            System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
            return;
        }
        for (Book book : books) {
            showBook(book, bookShelf.getMaxLength());
        }
    }

    private static void showBook(Book book, int maxLength) {
        System.out.printf("|%-3s|\n", "-".repeat(maxLength));
        System.out.printf("|%-3s%s|\n", book, " ".repeat(maxLength - book.getInfoLength()));
        System.out.printf("|%-3s|\n", "-".repeat(maxLength));
    }

    private static void printEnter(Scanner console) {
        String str = ".";
        while (!str.isBlank()) {
            System.out.println("Для продолжения работы нажмите <Enter> ");
            str = console.nextLine();
        }
    }

    private static void printMenu(BookShelf bookShelf) {
        System.out.println("В шкафу " + bookShelf.getCountBooks() +
                " книг и " + bookShelf.getFreePlaces() + " свободных полок.");
        System.out.println("""
                1. Добавить книгу
                2. Найти книгу
                3. Удалить книгу
                4. Очистить шкаф
                5. Выйти
                """);
    }
}


