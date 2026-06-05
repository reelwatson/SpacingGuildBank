package org.example;

import java.util.Scanner;

public class Deposit {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

    public boolean validationChecks(double depositAmount, double initialAccountAmount) {
        boolean validDeposit = false;
        double maxValue = Double.MAX_VALUE;

        do {
            if (depositAmount <= 0) {
                System.out.print("You cannot deposit zero solaris or a negative number.");
            } else if ((depositAmount + initialAccountAmount) >= maxValue) {
                System.out.print("We apologize, but this account cannot handle such a large transaction.\n Please input a smaller amount.");
            } else {
                // Try to add the amount to the account and return a boolean if successful
                // If success then set validDeposit to true
                // Else display a message to the user
                depositToAccount(depositAmount, initialAccountAmount);
                validDeposit = true;
            }
        }
        while (!validDeposit);

        return validDeposit;
    }

    public boolean depositToAccount(double depositAmount, double initialAccountAmount) {
        boolean depositSuccessful = false;
        double newAccountAmount = depositAmount + initialAccountAmount;
        try {
            // send the new information to the database
            // if successful then display a success message
            // if failure then display a simple non-jargon failure message
        }
        catch (Exception e) {

        }
        return depositSuccessful;
    }


}
