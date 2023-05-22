package com.startjava.graduation.bookshelf;

import java.lang.module.FindException;
import java.util.Scanner;

public class BookShelfMain {
    private final static String menu = """
            1. Добавить книгу
            2. Найти книгу
            3. Удалить книгу
            4. Очистить шкаф
            5. Показать все книги
            6. Выйти
            """;
    private static BookShelf bookShelf;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String answer;
        bookShelf = new BookShelf(10);
        System.out.println("Шкаф пуст. Вы можете добавить в него первую книгу");
        printMenu(bookShelf);
        do {
            answer = console.nextLine();
            switch (answer) {
                case "1" -> addBook();
                case "2" -> findBook();
                case "3" -> deleteBook();
                case "4" -> clearBookShelf();
                case "5" -> showShelf();
                case "6" -> System.out.println("Пока!");
                default -> System.out.println("Пункт меню не распознан, повторите ввод");
            }
            printEnter(console);
            printMenu(bookShelf);
        } while (!answer.trim().equals("6"));
    }

    private static void addBook() {
        while (true) {
            Scanner console = new Scanner(System.in);
            System.out.println("Введите автора");
            String author = console.nextLine();
            System.out.println("Введите заголовок");
            String title = console.nextLine();
            System.out.println("Введите год издания");
            String publishYear = console.nextLine();
            author = author.trim();
            title = title.trim();
            publishYear = publishYear.trim();
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
        Scanner console = new Scanner(System.in);
        Book book;
        System.out.println("Введите строку для поиска");
        String searchPattern = console.nextLine();
        try {
            book = bookShelf.find(searchPattern);
            showBook(book, bookShelf.getMaxLength());
        } catch (FindException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }

    private static void deleteBook() {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите строку для поиска книги для удаления");
        String searchPattern = console.nextLine();
        try {
            bookShelf.delete(searchPattern);
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
        while (true) {
            System.out.println("Для продолжения работы нажмите <Enter> ");
            String str = console.nextLine();
            if (str.isBlank()) {
                break;
            }
        }
    }

    private static void printMenu(BookShelf bookShelf) {
        System.out.println("В шкафу " + bookShelf.getCountBooks() +
                " книг и " + bookShelf.getFreePlaces() + " свободных полок.");
        System.out.println(menu);
    }
}


