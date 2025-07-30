package repository;

import constants.Constants;
import utils.Utilities;

import java.io.*;
import java.util.ArrayList;

import static constants.Constants.FILENAME_TXT;

public class ExpenseStorage {

    public static ArrayList<Expense> loadExpenses() {
        ArrayList<Expense> expenses = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILENAME_TXT));
            String line;
            while(true) {
                line = reader.readLine();
                if(line == null) {
                    break;
                }
                String[] parts = line.split(",");
                expenses.add(new Expense(
                        parts[0],
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Utilities.categoryToId(parts[4])
                ));
            }
        } catch (IOException e) {
            System.out.println("Error when loading expenses from local: " + e.getMessage());
        }
        return expenses;
    }

    public static void saveExpenses(ArrayList<Expense> expenses) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(FILENAME_TXT))) {
            for(Expense e: expenses) {
                printWriter.println(e.getExpenseId().toString() + "," + Utilities.DateToString(e.getDate()) + "," + e.getDescription() + "," + e.getAmount() + "," + e.getCategory());
            }
        } catch (IOException e) {
            System.out.println("Error when saving expenses: " + e.getMessage());
        }
    }

    public static void exportExpensesToCsv(ArrayList<Expense> expenses) {
        try (FileWriter writer = new FileWriter(Constants.FILENAME_CSV)){
            writer.write("ExpenseId,Date,Description,Amount,Category\n");
            for(Expense expense: expenses) {
                writer.write(expense.getExpenseId().toString() + ",");
                writer.write(Utilities.DateToString(expense.getDate()) + ",");
                writer.write(expense.getDescription() + ",");
                writer.write(expense.getAmount().toString() + ",");
                writer.write(expense.getCategory() + "\n");
            }
            System.out.println("Export expenses data completed.");
        } catch (IOException e) {
            System.out.print("Error when exporting CSV file: " + e.getMessage());
        }
    }
}
