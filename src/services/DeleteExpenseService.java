package services;

import repository.Expense;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteExpenseService {
    public static void deleteExpense(Scanner scanner, ArrayList<Expense> expenses) {
        System.out.print("Enter UUID of the expense you want to delete: ");
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
            expenses.remove(index);
            System.out.println("Expense Deleted.");
        }
    }
}
