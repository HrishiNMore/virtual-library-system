package com.hrishi.vls.analyzers;

import com.hrishi.vls.models.Library;
import com.hrishi.vls.models.TransactionLog;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BorrowingTrendAnalyzer {

    public static void analyzeBorrowingTrendsPerMonth(Library library) {
        List<TransactionLog> transactionLogs = library.log;

        if (transactionLogs.isEmpty()) {
            System.out.println("No transaction logs found. Cannot analyze borrowing trends.");
            return;
        }

        // Get the current year
        int currentYear = LocalDate.now().getYear();

        // Initialize an array to store borrowing counts for each month
        int[] borrowingCounts = new int[12];

        // Loop through transaction logs and count borrowings for each month
        for (TransactionLog log : transactionLogs) {
            if (log.getReturned().equalsIgnoreCase("No") && log.getBorrowDate().getYear() == currentYear) {
                int monthIndex = log.getBorrowDate().getMonthValue() - 1; // Month index starts from 0
                borrowingCounts[monthIndex]++;
            }
        }

        // Print borrowing trends for each month
        System.out.println("Borrowing Trends per Month:");
        for (int i = 0; i < 12; i++) {
            Month month = Month.of(i + 1);
            int borrowingCount = borrowingCounts[i];
            if (borrowingCount > 0) {
                System.out.println(month.toString() + ": " + borrowingCount + " books borrowed");
            }
        }
    }

    public static void analyzeBorrowingTrendsPerQuarter(Library library) {
        List<TransactionLog> transactionLogs = library.log;

        if (transactionLogs.isEmpty()) {
            System.out.println("No transaction logs found. Cannot analyze borrowing trends.");
            return;
        }

        // Get the current year
        int currentYear = LocalDate.now().getYear();

        // Initialize a map to store borrowing counts for each quarter
        Map<Integer, Integer> quarterBorrowingCounts = new TreeMap<>();

        // Loop through transaction logs and count borrowings for each quarter
        for (TransactionLog log : transactionLogs) {
            if (log.getReturned().equalsIgnoreCase("No") && log.getBorrowDate().getYear() == currentYear) {
                int month = log.getBorrowDate().getMonthValue();
                int quarter = (month - 1) / 3 + 1; // Determine quarter based on month
                quarterBorrowingCounts.put(quarter, quarterBorrowingCounts.getOrDefault(quarter, 0) + 1);
            }
        }

        // Print borrowing trends for each quarter
        System.out.println("Borrowing Trends per Quarter:");
        quarterBorrowingCounts.forEach((quarter, count) ->
                System.out.println("Quarter " + quarter + ": " + count + " books borrowed"));
    }

    public static void analyzeBorrowingTrendsPerYear(Library library, int year) {
        List<TransactionLog> transactionLogs = library.log;

        if (transactionLogs.isEmpty()) {
            System.out.println("No transaction logs found. Cannot analyze borrowing trends.");
            return;
        }

        // Initialize a map to store borrowing counts for each month
        Map<Month, Integer> borrowingCounts = new TreeMap<>();

        // Loop through transaction logs and count borrowings for each month of the specified year
        for (TransactionLog log : transactionLogs) {
            if (log.getReturned().equalsIgnoreCase("No") && log.getBorrowDate().getYear() == year) {
                Month month = log.getBorrowDate().getMonth();
                borrowingCounts.put(month, borrowingCounts.getOrDefault(month, 0) + 1);
            }
        }

        // Print borrowing trends for the specified year
        System.out.println("Borrowing Trends for Year " + year + ":");
        borrowingCounts.forEach((month, count) ->
                System.out.println(month.toString() + ": " + count + " books borrowed"));
    }
}