import repository.Expense;
import repository.ExpenseStorage;

import java.util.ArrayList;
import java.util.Scanner;

import static repository.ExpenseStorage.exportExpensesToCsv;
import static services.AddExpenseService.addExpense;
import static services.DeleteExpenseService.deleteExpense;
import static services.SummaryExpensesService.summaryExpense;
import static services.SummaryExpensesService.summaryExpenseByMonth;
import static services.UpdateExpenseService.updateExpense;
import static services.ViewAllExpensesService.viewAllExpenses;

public class ExpenseTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Expense> expenses = ExpenseStorage.loadExpenses();
        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. Update Expense");
            System.out.println("3. Delete Expense");
            System.out.println("4. View All Expenses");
            System.out.println("5. View Summary of All Expenses");
            System.out.println("6. View Summary of Expenses for a Specific Month");
            System.out.println("7. Export expenses data to a csv file");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addExpense(scanner, expenses);
                    break;
                case 2:
                    updateExpense(scanner, expenses);
                    break;
                case 3:
                    deleteExpense(scanner, expenses);
                    break;
                case 4:
                    viewAllExpenses(expenses);
                    break;
                case 5:
                    summaryExpense(expenses);
                    break;
                case 6:
                    summaryExpenseByMonth(scanner, expenses);
                    break;
                case 7:
                    exportExpensesToCsv(expenses);
                    break;
                case 8:
                    ExpenseStorage.saveExpenses(expenses);
                    System.out.println("Expenses saved. Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}