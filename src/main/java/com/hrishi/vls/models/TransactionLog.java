package com.hrishi.vls.models;

import java.time.LocalDate;

public class TransactionLog {

    private int UserId;
    private String ISBN;
    private String borrowed;
    private LocalDate borrowDate;

    private String Returned;

    private LocalDate returnDate;

    public TransactionLog(int UserId, String ISBN,String borrowed, LocalDate borrowDate,String returned,LocalDate returnDate){
        this.UserId=UserId;
        this.ISBN=ISBN;
        this.borrowed=borrowed;
        this.borrowDate=borrowDate;
        this.Returned=returned;
        this.returnDate=returnDate;
    }
    public TransactionLog(int UserId, String ISBN,String borrowed){
        this(UserId,ISBN,borrowed,LocalDate.now(),"No",null);
    }


    public int getUserId() {
        return UserId;
    }

    public String getISBN() {
        return ISBN;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public String getReturned() {
        return Returned;
    }

    public void setReturned(String returned) {
        Returned = returned;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getBorrowed() {
        return borrowed;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setBorrowed(String borrowed) {
        this.borrowed = borrowed;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
