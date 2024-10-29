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
            System.out.println("Enter command:\n" +
                    "  - addCustomer\n" +
                    "  - addProduct\n" +
                    "  - addOrder\n" +
                    "  - listCustomer\n" +
                    "  - listProducts\n" +
                    "  - listOrders\n" +
                    "  - updateCustomer\n" +
                    "  - updateProduct\n" +
                    "  - deleteCustomer\n" +
                    "  - deleteProduct\n" +
                    "  - deleteOrder\n" +
                    "  - exit");

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
                addProduct(scanner);
                break;

            case "addOrder":
                addOrder(scanner);
                break;

            case "listCustomer":
                listCustomers();
                break;

            case "listProducts":
                listProducts();
                break;

            case "listOrders":
                listOrders();
                break;

            case "updateCustomer":
                updateCustomer(scanner);
                break;

            case "updateProduct":
                updateProduct(scanner);
                break;

            case "deleteCustomer":
                deleteCustomer(scanner);
                break;

            case "deleteProduct":
                deleteProduct(scanner);
                break;

            case "deleteOrder":
                deleteOrder(scanner);
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

    private static void addProduct(Scanner scanner) {
        System.out.println("Enter Name, Price: ");
        String[] productInfo = scanner.nextLine().split(",");
        String productName = productInfo[0].trim();
        double productPrice = Double.parseDouble(productInfo[1].trim());
        int productId = productIdCounter++;
        Product product = new Product(productId, productName, productPrice);
        products.put(String.valueOf(productId), product);
        System.out.println("Product added: " + productName + " (ID: " + productId + ")");
    }

    private static void addOrder(Scanner scanner) {
        System.out.println("Enter Customer ID, Product ID:");
        String[] orderInfo = scanner.nextLine().split(",");
        String orderCustomerId = orderInfo[0].trim();
        String orderProductId = orderInfo[1].trim();

        Customer orderCustomer = customers.get(orderCustomerId);
        Product orderProduct = products.get(orderProductId);
        if (orderCustomer != null && orderProduct != null) {
            int orderId = orderIdCounter++;
            Order order = new Order(orderId, orderCustomer.getId(), orderProduct.getId());
            orders.put(String.valueOf(orderId), order);
            System.out.println("Order added for customer: " + orderCustomer.getName() + " (Order ID: " + orderId + ")");
        } else {
            System.out.println("Invalid customer or product ID.");
        }
    }

    private static void listCustomers() {
        System.out.println("Customers: ");
        for (Customer customer : customers.values()) {
            System.out.println(customer);
        }
    }

    private static void listProducts() {
        System.out.println("Products: ");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    private static void listOrders() {
        System.out.println("Orders: ");
        for (Order o : orders.values()) {
            System.out.println(o);
        }
    }


    private static void updateCustomer(Scanner scanner) {
        System.out.println("Enter Customer ID and new Name: ");
        String[] updateInfo = scanner.nextLine().split(",");
        String customerId = updateInfo[0].trim();
        String newName = updateInfo[1].trim();

        if (customers.containsKey(customerId)) {
            customers.get(customerId).setName(newName);
            System.out.println("Updated Customer: " + customers.get(customerId));
        } else {
            System.out.println("Customer not found");
        }
    }

    private static void updateProduct(Scanner scanner) {
        System.out.println("Enter Product ID and new Name/Price (format: name,price): ");
        String[] updateInfo = scanner.nextLine().split(",");
        String productId = updateInfo[0].trim();

        if (products.containsKey(productId)) {
            String newName = updateInfo[1].trim();
            double newPrice = Double.parseDouble(updateInfo[2].trim());
            Product product = products.get(productId);
            product.setName(newName);
            product.setPrice(newPrice);
            System.out.println("Updated Product: " + product);
        } else {
            System.out.println("Product not found");
        }
    }

    private static void deleteCustomer(Scanner scanner) {
        System.out.println("Enter Customer ID to delete: ");
        String customerId = scanner.nextLine().trim();

        if (customers.remove(customerId) != null) {
            System.out.println("Customer with ID " + customerId + " deleted.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.println("Enter Product ID to delete: ");
        String productId = scanner.nextLine().trim();

        if (products.remove(productId) != null) {
            System.out.println("Product with ID " + productId + " deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void deleteOrder(Scanner scanner) {
        System.out.println("Enter Order ID to delete: ");
        String orderId = scanner.nextLine().trim();

        if (orders.remove(orderId) != null) {
            System.out.println("Order with ID " + orderId + " deleted.");
        } else {
            System.out.println("Order not found.");
        }
    }

}

