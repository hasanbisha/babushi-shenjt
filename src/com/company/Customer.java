package com.company;

/*
    id
    name
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Customer {
    private static String FILENAME = "customers.csv";

    public int id;
    private String name;

    Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static HashMap<Integer, Customer> readFromFile()
    {
        HashMap<Integer, Customer> customersMap = new HashMap<Integer, Customer>();
        ArrayList<String[]> lines = CSVDatabaseManager.getCSVFileLines(Customer.FILENAME);
        for (String[] line : lines) {
            int id = Integer.parseInt(line[0]);
            String name = line[1];
            Customer customer = new Customer(id, name);
            customersMap.put(id, customer);
        }
        return customersMap;
    }

    public static void writeFromMap(HashMap<Integer, Customer> map) {
        String file = "id,name\n";

        for (Customer customer : map.values()) {
            String line = customer.id + "," + customer.name;
            file += line + "\n";
        }
        try {
            FileWriter fileWriter = new FileWriter(Customer.FILENAME);
            fileWriter.write(file);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
