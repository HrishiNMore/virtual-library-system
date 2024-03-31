package com.hrishi.vls.models;


import com.hrishi.vls.isbn.ISBNChecker;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Library {



    public  List<Book> books = new ArrayList<>();
    private ISBNChecker check = new ISBNChecker();
    public List<TransactionLog> log = new ArrayList<>();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    Scanner sc = new Scanner(System.in);


    public Library() {
        this.books = new ArrayList<>();
        this.check = new ISBNChecker();
    }


    // add book
    public void add(Book book) {
        boolean isbnUnique = check.isISBNUnique(book.getISBN(), books);
        if (isbnUnique) {
            books.add(book);
        }
    }

    //-------------------------------------------------------------------------------------------------


    public void showStatus(Book bk) {

        System.out.println("Here is the details of the book: \nTitle : " + bk.getTitle() + "\n"
                + "Author : " + bk.getAuthor() + "\n" + "ISBN : " + bk.getISBN() + "\n"
                + "Genre : " + bk.getGenre() + "\n"
                + "Publication date : " + bk.getPublication_Date());
        if (bk.getNoOfCopies() < 1) {
            bk.setStatus("Out of stock");
            System.out.println("Current availability status : " + bk.getStatus());
        } else {
            bk.setStatus("Available");
            System.out.println("Current availability status : " + bk.getStatus());
        }
    }


    //-----------------------------------------------------------------------------------------------

    public void viewLog() {
        for (TransactionLog lg : log) {
            System.out.println("UserID : " + lg.getUserId() + "," + "ISBN : " + lg.getISBN() + "," +"Borrowed : "+lg.getBorrowed()+","+ "Borrow Date : " + lg.getBorrowDate()
            +","+"Returned : "+lg.getReturned()+","+"Return Date : "+lg.getReturnDate());
        }
    }

    //----------------------------------------------------------------------------------------------------


    public void bookInventory() {
        for (Book bk : books) {
            System.out.println("Title : " + bk.getTitle() +" , "+ "No of copies : " + bk.getNoOfCopies());
        }
    }


}
