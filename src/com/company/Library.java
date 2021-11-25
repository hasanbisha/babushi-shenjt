package com.company;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
* libraries
*
* addLibrary
* deleteLibrary
*
*
*
* bookList
* borrowedBooks
*
* borrowBook
* addBook
* deleteBook
*
*
* usersList
*
* borrowedBooks
* addUser
* removeUser
* borrowBooks
* */

public class Library {
    HashMap<Integer, Book> bookMap = new HashMap<Integer, Book>();
    HashMap<Integer, Customer> customersMap = new HashMap<Integer, Customer>();

    Library() {
        this.bookMap = Book.readFromFile();
        this.customersMap = Customer.readFromFile();

        System.out.println(this.customersMap);

        Customer customer = new Customer(6, "Cak arito");
        this.customersMap.put(6, customer);

        Customer.writeFromMap(this.customersMap);
    }
}
