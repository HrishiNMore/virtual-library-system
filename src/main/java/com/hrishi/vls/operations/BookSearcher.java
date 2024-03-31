package com.hrishi.vls.operations;

import com.hrishi.vls.models.Book;
import com.hrishi.vls.models.Library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookSearcher {
    private static Library library;
    private static Scanner sc=new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private BookLender borrow;
    private static List<Book> books;

    public BookSearcher(Library lib){
        this.library=new Library();
        this.books=lib.books;
    }



    public static void search() {

        List<Book> result = new ArrayList<>();
        if (books.isEmpty()) {
            System.err.println("Library is Empty. Please add books");
        } else {


            System.out.println("Search By : ");
            System.out.println("1. Title");
            System.out.println("2. Author");
            System.out.println("3. ISBN");
            System.out.println("4. Genre");
            System.out.println("5. Published Date");
            System.out.println("6. No of Copies");
            System.out.print("Choose an option: ");
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Enter the Title of Book :");
                    sc.nextLine();
                    String title = sc.nextLine().trim();
                    result = searchByTitle(title, books);
                    break;

                case 2:
                    System.out.println("Enter the Author of Book :");
                    sc.nextLine();
                    String author = sc.nextLine();
                    result = searchByAuthor(author, books);
                    break;

                case 3:
                    System.out.println("Enter the ISBN of Book :");
                    sc.nextLine();
                    String isbn = sc.nextLine();
                    result = searchByISBN(isbn, library.books);
                    break;

                case 4:
                    System.out.println("Enter Genre of Book :");
                    sc.nextLine();
                    String Genre = sc.nextLine();
                    result = searchByGenre(Genre, books);
                    break;

                case 5:
                    System.out.println("Enter the Published Date of Book :");
                    sc.nextLine();
                    String d = sc.nextLine();
                    LocalDate date = LocalDate.parse(d, formatter);
                    result = searchByDate(date, books);
                    break;

                case 6:
                    System.out.println("Enter the No of Copies of Book :");
                    sc.nextLine();
                    int noOfCopies = sc.nextInt();
                    result = searchByCopies(noOfCopies, books);

                default:
                    System.out.println("Invalid input");

            }

            if (result.isEmpty()) {
                System.out.println("Book Not Found");
            } else if (result.size() == 1) {
                System.out.println("Book Found in Library:");
                Book foundBook = result.get(0);
                System.out.println(foundBook.getTitle());
                library.showStatus(foundBook);
            } else {
                // Only prompt for filtering if there are multiple results
                for (Book res : result) {
                    System.out.println("Title : "+res.getTitle()+" ISBN - "+res.getISBN());
                }
                result = addfilter(result);

                if (result.isEmpty()) {
                    System.out.println("No books match the specified criteria.");
                }

            }
        }
    }

    public static List<Book> searchByTitle(String title, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> searchByAuthor(String author, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> searchByGenre(String Genre, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(Genre)) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> searchByISBN(String isbn, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(isbn)) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> searchByDate(LocalDate date, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getPublication_Date().isEqual(date)) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> searchByCopies(int copies, List<Book> books) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getNoOfCopies() == copies) {
                result.add(book);
            }
        }
        return result;
    }

    public static List<Book> addfilter(List<Book> result) {
        System.out.println("Do you want to Filter the result(Y/N) ?:");
        String ch = sc.next();
        if (!ch.equalsIgnoreCase("y")) {
            return result; // If user doesn't want to filter, return the original result
        }
        while (ch.equalsIgnoreCase("y")) {
            System.out.println("Filter By : ");
            System.out.println("1. Title");
            System.out.println("2. Author");
            System.out.println("3. ISBN");
            System.out.println("4. Genre");
            System.out.println("5. Published Date");
            System.out.println("6. No of Copies");
            System.out.print("Choose an option: ");
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("Enter the Title of Book :");
                    String title = sc.next();
                    result = searchByTitle(title, result);
                    break;
                case 2:
                    System.out.println("Enter the Author of Book :");
                    String author = sc.next();
                    result = searchByAuthor(author, result);
                    break;
                case 3:
                    System.out.println("Enter the ISBN of Book :");
                    String isbn = sc.next();
                    result = searchByISBN(isbn, result);
                    break;
                case 4:
                    System.out.println("Enter Genre of Book :");
                    String genre = sc.next();
                    result = searchByGenre(genre, result);
                    break;
                case 5:
                    System.out.println("Enter the Publication Date of Book :");
                    String d = sc.next();
                    LocalDate date = LocalDate.parse(d, formatter);
                    result = searchByDate(date, result);
                    break;
                case 6:
                    System.out.println("Enter the No of copies of book :");
                    int noOfCopies = sc.nextInt();
                    result = searchByCopies(noOfCopies, result);
                    break;
                default:
                    System.out.println("Invalid input");
                    continue;
            }

            if (result.isEmpty()) {
                System.out.println("No books match the specified criteria.");
                return Collections.emptyList();
            } else {
                System.out.println("Filtered Books :");
                for (int i = 0; i < result.size(); i++) {
                    System.out.println((i + 1) + ". " + result.get(i).getTitle());
                }
            }

            System.out.println("Choose a book from the filtered list (Enter the corresponding number): ");
            int bookIndex = sc.nextInt();
            if (bookIndex > 0 && bookIndex <= result.size()) {
                Book selectedBook = result.get(bookIndex - 1);
                library.showStatus(selectedBook);
                return Collections.singletonList(selectedBook); // Return a list containing the selected book
            } else {
                System.out.println("Invalid book selection.");
                return Collections.emptyList();
            }

        }
        return result;
    }
}
