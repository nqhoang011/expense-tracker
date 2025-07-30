package services;

import repository.Expense;

import java.util.ArrayList;

public class ViewAllExpensesService {
    public static void viewAllExpenses(ArrayList<Expense> expenses) {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }
}
