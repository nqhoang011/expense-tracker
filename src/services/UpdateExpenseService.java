package services;

import repository.Expense;

import java.util.ArrayList;
import java.util.Scanner;

public class UpdateExpenseService {
    public static void updateExpense(Scanner scanner, ArrayList<Expense> expenses) {
        System.out.print("Enter UUID of the expense you want to update: ");
        String id = scanner.nextLine();
        int index = -1;
        for(int i = 0; i < expenses.size(); i ++) {
            if(expenses.get(i).getExpenseId().toString().equals(id)) {
                index = i;
                break;
            }
        }
        if(index == -1) {
            System.out.println("Invalid UUID.");
        }
        else {
            System.out.println(expenses.get(index));
            String expenseId = expenses.get(index).getExpenseId().toString();
            System.out.print("Enter new date (dd-MM-yyyy): ");
            String date = scanner.nextLine();
            System.out.print("Enter new description: ");
            String description = scanner.nextLine();
            System.out.print("Enter new amount (VND): ");
            int amount = scanner.nextInt();
            System.out.println("Select new category:");
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
            expenses.set(index, new Expense(expenseId, date, description, amount, category - 1));
            System.out.println("Expense Updated.");
        }
    }
}
