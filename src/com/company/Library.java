package com.company;

import java.util.HashMap;

public class Library {
    HashMap<Integer, Book> bookMap = new HashMap<Integer, Book>();
    HashMap<Integer, Customer> customerMap = new HashMap<Integer, Customer>();

    /**
     * initializes bookMap and customerMap
     * reads books and customers from file
     */
    Library() {
        // read books from file
        this.bookMap = Book.readFromFile();
        // read customers from file
        this.customerMap = Customer.readFromFile();

        Book book = this.bookMap.get(3);
        this.addBook(book);
    }

    /**
     * adds book to bookMap and saves it to the file
     * @param book book to be added
     */
    public void addBook(Book book) {
        assert this.bookMap.containsKey(book.id) : "Book with id " + book.id + " already exists";
        this.bookMap.put(book.id, book);
        Book.writeFromMap(this.bookMap);
    }

    /**
     * updates book of bookMap and saves it to the file
     * @param book book to be updated
     */
    public void updateBook(Book book) {
        assert !this.bookMap.containsKey(book.id) : "Book with id " + book.id + " doesn't exist";
        this.bookMap.put(book.id, book);
        Book.writeFromMap(this.bookMap);
    }

    /**
     * removes book from bookMap and updates the file
     * @param id id of book to be removed
     */
    public void removeBook(int id) {
        assert !this.bookMap.containsKey(id) : "Book with id " + id + " doesn't exist";
        this.bookMap.remove(id);
        Book.writeFromMap(this.bookMap);
    }

    /**
     * adds customer to customerMap and updates file
     * @param customer customer to be added
     */
    public void addCustomer(Customer customer) {
        assert this.customerMap.containsKey(customer.id) : "Customer with id " + customer.id + " already exists";
        this.customerMap.put(customer.id, customer);
        Customer.writeFromMap(this.customerMap);
    }

    /**
     * updates customer of customerMap and updates file
     * @param customer customer to be updated
     */
    public void updateCustomer(Customer customer) {
        assert !this.customerMap.containsKey(customer.id) : "Customer with id " + customer.id + " doesn't exists";
        this.customerMap.put(customer.id, customer);
        Customer.writeFromMap(this.customerMap);
    }

    /**
     * removes customer from customerMap and updates file
     * @param id id of customer to be removed
     */
    public void removeCustomer(int id) {
        assert !this.customerMap.containsKey(id) : "Customer with id " + id + " doesn't exists";
        this.customerMap.remove(id);
        Customer.writeFromMap(this.customerMap);
    }

    /**
     * adds customer to the list of book borrowers
     * @param book book to be borrowed
     * @param customer customer to borrow the book
     */
    public void borrowBook(Book book, Customer customer) {
        assert !this.bookMap.containsKey(book.id) : "Book with id " + book.id + " doesn't exist";
        assert !this.customerMap.containsKey(customer.id) : "Customer with id " + customer.id + " doesn't exists";
        book.borrowBook(customer);
        Book.writeFromMap(this.bookMap);
    }

    /**
     * removes customer to the list of book borrowers
     * @param book borrowed book
     * @param customer borrower
     */
    public void returnBook(Book book, Customer customer) {
        assert !this.bookMap.containsKey(book.id) : "Book with id " + book.id + " doesn't exist";
        assert !this.customerMap.containsKey(customer.id) : "Customer with id " + customer.id + " doesn't exists";
        book.returnBook(customer);
        Book.writeFromMap(this.bookMap);
    }
}
