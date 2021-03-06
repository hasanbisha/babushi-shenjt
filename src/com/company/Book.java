package com.company;

/*
 * name
 * author
 * pages
 * price
 * count
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Book {
    private static String FILENAME = "books.csv";

    public int id;
    private String name;
    private String author;
    private int pages;
    private Double price;
    private int count;
    // borrowers is an array list because the length is dynamic
    private ArrayList<Integer> borrowers;

    Book(int id, String name, String author, int pages, Double price, int count, ArrayList<Integer> borrowers) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.count = count;
        this.borrowers = borrowers;
    }

    /**
     * reads file and translates it to a hashmap of books
     * @return hashmap of books from the file
     */
    public static HashMap<Integer, Book> readFromFile()
    {
        HashMap<Integer, Book> booksMap = new HashMap<Integer, Book>();
        ArrayList<String[]> lines = CSVDatabaseManager.getCSVFileLines(Book.FILENAME);
        for (String[] line : lines) {
            int id = Integer.parseInt(line[0]);
            String name = line[1];
            String author = line[2];
            int pages = Integer.parseInt(line[3]);
            Double price = Double.parseDouble(line[4]);
            int count = Integer.parseInt(line[5]);
            ArrayList<Integer> borrowers = new ArrayList<Integer>();
            for (String customerId : line[6].split(" ")) {
                borrowers.add(Integer.parseInt(customerId));
            }
            Book book = new Book(id, name, author, pages, price, count, borrowers);
            booksMap.put(id, book);
        }
        return booksMap;
    }

    /**
     * receives a hashmap of books and saves it to the file
     * @param map hashmap of books to be written to file
     */
    public static void writeFromMap(HashMap<Integer, Book> map) {
        String file = "id,name,author,pages,price,count,borrowers\n";

        for (Book book : map.values()) {
            String line = book.id + ","
                + book.name + ","
                + book.author + ","
                + book.pages + ","
                + book.price + ","
                + book.count + ",";

            for (int borrowerId : book.borrowers) {
                line += borrowerId + " ";
            }
            file += line + "\n";
        }
        try {
            FileWriter fileWriter = new FileWriter(Book.FILENAME);
            fileWriter.write(file);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * adds customer to the list of borrowers
     * @param customer customer who borrows
     */
    public void borrowBook(Customer customer) {
        this.borrowers.add(customer.id);
    }

    /**
     * removes customer from list of borrowers
     * @param customer customer who has borrowed
     */
    public void returnBook(Customer customer) {
        for (int i = 0; i < this.borrowers.size(); i++) {
            int borrowerId = this.borrowers.get(i);
            if (customer.id == borrowerId) {
                this.borrowers.remove(i);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", count=" + count +
                ", borrowers=" + borrowers +
                '}';
    }
}
