package services;

import repository.Expense;

import java.util.ArrayList;
import java.util.Scanner;

public class AddExpenseService {
    public static void addExpense(Scanner scanner, ArrayList<Expense> expenses) {
        System.out.print("Enter date (dd-MM-yyyy): ");
        String date = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter amount (VND): ");
        int amount = scanner.nextInt();
        System.out.println("Select category:");
        int category;
        while(true) {
            System.out.println("1. Food & Drink");
            System.out.println("2. Vehicle");
            System.out.println("3. Others");
            System.out.print("Enter your choice: ");
            category = scanner.nextInt();
            if(category <= 0 || category > 3) {
                System.out.println("Invalid choice. Please try again.");
            }
            else {
                break;
            }
        }
        expenses.add(new Expense(date, description, amount, category - 1));
        System.out.println("Expense added.");

    }
}
