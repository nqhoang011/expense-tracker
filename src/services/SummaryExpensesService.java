package services;

import constants.Constants;
import repository.Expense;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class SummaryExpensesService {
    public static void summaryExpense(ArrayList<Expense> expenses) {
        int total = 0;
        int totalForFoodAndDrink = 0;
        int totalForVehicle = 0;
        int totalForOthers = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
            if(expense.getCategory().equals(Constants.categories[0])) {
                totalForFoodAndDrink += expense.getAmount();
            }
            else if(expense.getCategory().equals(Constants.categories[1])) {
                totalForVehicle += expense.getAmount();
            }
            else {
                totalForOthers += expense.getAmount();
            }
        }
        System.out.println("Total amount of money for food and drink: " + totalForFoodAndDrink + " VND.");
        System.out.println("Total amount of money for vehicle: " + totalForVehicle + " VND.");
        System.out.println("Total amount of money for others: " + totalForOthers + " VND.");
        System.out.println("Total amount of money: " + total + " VND.");
    }

    public static void summaryExpenseByMonth(Scanner scanner, ArrayList<Expense> expenses) {
        System.out.print("Enter month: ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        if(month <= 0 || month > 12) {
            System.out.println("Invalid month.");
            return;
        }
        if(year < 0) {
            System.out.println("Invalid year.");
            return;
        }
        int total = 0;
        int totalForFoodAndDrink = 0;
        int totalForVehicle = 0;
        int totalForOthers = 0;
        for(Expense expense: expenses) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(expense.getDate());
            if(calendar.get(Calendar.MONTH) + 1 == month && calendar.get(Calendar.YEAR) == year) {
                total += expense.getAmount();
                if(expense.getCategory().equals(Constants.categories[0])) {
                    totalForFoodAndDrink += expense.getAmount();
                }
                else if(expense.getCategory().equals(Constants.categories[1])) {
                    totalForVehicle += expense.getAmount();
                }
                else {
                    totalForOthers += expense.getAmount();
                }
            }
        }
        System.out.println("Total amount of money for food and drink in " + month + "-" + year + ": " + totalForFoodAndDrink + " VND.");
        System.out.println("Total amount of money for vehicle in " + month + "-" + year + ": " + totalForVehicle + " VND.");
        System.out.println("Total amount of money for others in " + month + "-" + year + ": " + totalForOthers + " VND.");
        System.out.println("Total amount of money in " + month + "-" + year + ": " + total + " VND.");
    }
}
