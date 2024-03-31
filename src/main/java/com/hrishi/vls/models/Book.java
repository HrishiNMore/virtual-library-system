package com.hrishi.vls.models;

import java.time.LocalDate;

public class Book {
    private String Title, Author, ISBN, Genre;
    private LocalDate Publication_Date;
    private int noOfCopies;
    private String status;
    public Book(String Title,String Author,String ISBN,String Genre ,LocalDate Publication_Date,int noOfCopies){
        this.Title=Title;
        this.Author=Author;
        this.ISBN=ISBN;
        this.Genre=Genre;
        this.Publication_Date=Publication_Date;
        this.noOfCopies=noOfCopies;
    }

    public Book(String Title,String Author,String ISBN,String Genre ,LocalDate Publication_Date){
        this(Title,Author,ISBN,Genre,Publication_Date,100);

    }

    public Book(String Title,String Author,String ISBN,String Genre ,int noOfCopies){
        this(Title,Author,ISBN,Genre,LocalDate.now(),noOfCopies);
    }

    public Book(String Title,String Author,String ISBN,String Genre ){
        this(Title,Author,ISBN,Genre,LocalDate.now(),100);

    }


    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return Author;
    }

    public String getGenre() {
        return Genre;
    }

    public String getTitle() {
        return Title;
    }

    public int getNoOfCopies() {
        return noOfCopies;
    }

    public LocalDate getPublication_Date() {
        return Publication_Date;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setNoOfCopies(int noOfCopies) {
        this.noOfCopies = noOfCopies;
    }

    public void setPublication_Date(LocalDate publication_Date) {
        Publication_Date = publication_Date;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


