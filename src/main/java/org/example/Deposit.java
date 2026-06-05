package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Deposit {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deposit newDeposit = new Deposit();

        System.out.println("Input the total amount you wish to deposit");
        double depositAmount = scanner.nextDouble();
        double placeholderInitialAccountAmount = 1200000; // Will change to a queried amount down the line

        boolean validDeposit = newDeposit.validationChecks(depositAmount, placeholderInitialAccountAmount);
        if (validDeposit) {
            System.out.println("Would you like to complete another transaction? Y/N");
        }

        scanner.close();
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
                boolean depositSuccessful = depositToAccount(depositAmount, initialAccountAmount);
                if (depositSuccessful) {
                    validDeposit = true;
                }
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
            System.out.println("Your deposit was successful. The new total is " + newAccountAmount);
        }
        catch (Exception e) {
            System.out.println("We apologize, an error occurred while depositing your amount.");
            System.out.println("Please try again, or press X to end the transaction.");
            // Okay well now I need to actually implement "press X" in my method(s)
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return depositSuccessful;
    }


}
