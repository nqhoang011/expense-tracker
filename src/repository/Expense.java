package repository;

import utils.Utilities;

import java.util.Date;
import java.util.UUID;

import static constants.Constants.categories;

public class Expense {
    private UUID expenseId;
    private Date date;
    private String description;
    private Integer amount;
    private String category;

    public Expense(String date, String description, Integer amount, Integer categoryID) {
        this.expenseId = UUID.randomUUID();
        this.date = Utilities.stringToDate(date);
        this.description = description;
        this.amount = amount;
        this.category = categories[categoryID];
    }

    public Expense(String expenseId, String date, String description, Integer amount, Integer categoryID) {
        this.expenseId = UUID.fromString(expenseId);
        this.date = Utilities.stringToDate(date);
        this.description = description;
        this.amount = amount;
        this.category = categories[categoryID];
    }

    public UUID getExpenseId() {
        return expenseId;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "ID: " + this.expenseId.toString()
                + "; Date: " + this.date.toString()
                + "; Description: " + this.description
                + "; Amount: " + this.amount.toString()
                + "; Category: " + this.category
                + "\n";
    }
}
