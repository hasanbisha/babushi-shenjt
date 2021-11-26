package com.company;

import java.util.HashMap;

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
    HashMap<Integer, Customer> customerMap = new HashMap<Integer, Customer>();

    Library() {
        this.bookMap = Book.readFromFile();
        this.customerMap = Customer.readFromFile();

        this.addCustomer(new Customer(
            5,
            "Kolloz Kallini"
        ));
    }

    public void addBook(Book book) {
        this.bookMap.put(book.id, book);
        Book.writeFromMap(this.bookMap);
    }

    public void updateBook(Book book) {
        this.bookMap.put(book.id, book);
        Book.writeFromMap(this.bookMap);
    }

    public void removeBook(int id) {
        this.bookMap.remove(id);
        Book.writeFromMap(this.bookMap);
    }

    public void addCustomer(Customer customer) {
        this.customerMap.put(customer.id, customer);
        Customer.writeFromMap(this.customerMap);
    }

    public void updateCustomer(Customer customer) {
        this.customerMap.put(customer.id, customer);
        Customer.writeFromMap(this.customerMap);
    }

    public void removeCustomer(int id) {
        this.customerMap.remove(id);
        Customer.writeFromMap(this.customerMap);
    }
}
