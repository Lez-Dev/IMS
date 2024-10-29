package org.inventory;

import org.inventory.Models.Customer;
import org.inventory.Models.Product;
import org.inventory.Models.Order;

import java.util.Scanner;

/**
 * Main class to run the inventory management system.
 */
public class InventorySystem {

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
                System.out.println("Enter ID and Name: ");
                //
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

            default:
                System.out.println("Unknown command.");
        }
    }
}

