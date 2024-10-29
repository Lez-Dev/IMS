package org.inventory;

import org.inventory.Models.Customer;
import org.inventory.Models.Product;
import org.inventory.Models.Order;

import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;

/**
 * Main class to run the inventory management system.
 */
public class InventorySystem {

    // HashMaps to store unique IDs and their corresponding objects
    private static Map<String, Customer> customers = new HashMap<>();
    private static Map<String, Product> products = new HashMap<>();
    private static Map<String, Order> orders = new HashMap<>();

    // Counters for generating unique IDs
    private static int customerIdCounter = 1;
    private static int productIdCounter = 1;
    private static int orderIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Enter command (addCustomer, addProduct, addOrder, exit): ");
            command = scanner.nextLine();

            if (command.equals("exit")) {
                break;
            }

            handleCommand(command, scanner);
        }
        scanner.close();
    }

    private static void handleCommand(String command, Scanner scanner) {
        switch (command) {
            case "addCustomer":
                addCustomer(scanner);
                break;

            case "addProduct":
                System.out.println("Enter ID, Name, Price: ");
                //
                break;

            case "addOrder":
                System.out.println("Enter Order ID, Customer ID, Product ID, Quantity: ");
                if (//customer != null && product != null
                ) {
                    //create order
                    //} else {
                    //System.out.println("Invalid customer or product ID.");
                }
                break;

            case "deleteCustomer":
                System.out.println("Confirm ID of Customer");
                // deleting customer...
                break;

            case "deleteProduct":
                System.out.println("Confirm ID of Product");
                break;

            case "deleteOrder":
                System.out.println("Confirm ID of Order");
                break;

            default:
                System.out.println("Unknown command.");
        }
    }


    private static void addCustomer(Scanner scanner) {
        System.out.println("Enter Name: ");
        String customerName = scanner.nextLine().trim();
        int customerId = customerIdCounter++;
        Customer customer = new Customer(customerId, customerName);
        customers.put(String.valueOf(customerId), customer);
        System.out.println("Customer added: " + customerName + " (ID: " + customerId + ")");
    }



    private void updateCustomers (int id, String name){
        if (customers.containsKey(id)) {
            customers.get(id).setName(name);
            System.out.println("Updated Customer: " + customers.get(id));
        } else {
            System.out.println("Customer not found");
        }
    }
    private void updateProduct ( int id, String name){
        if (products.containsKey(id)) {
            products.get(id).setName(name);
            System.out.println("Updated Customer: " + products.get(id));
        } else {
            System.out.println("Customer not found");
        }
    }
    private void updateOrder ( int id, String name){
        if (orders.containsKey(id)) {
            orders.get(id).setName(name);
            System.out.println("Updated Customer: " + orders.get(id));
        } else {
            System.out.println("Customer not found");
        }
    }
}

