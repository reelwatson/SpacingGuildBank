package org.example;

import java.util.Scanner;

public class Withdrawals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Withdrawals newWithdrawal = new Withdrawals();
        double placeholderInitialAccountAmount = 1500000;

        System.out.println("Please input the amount you wish to withdraw.");
        double withdrawalAmount = scanner.nextDouble();
        boolean withdrawalCompleted = newWithdrawal.withdrawalValidation(withdrawalAmount, placeholderInitialAccountAmount);
        if (withdrawalCompleted) {
            System.out.println("Thank you for doing business with us. Would you like to complete another transaction?");
        }

        scanner.close();
    }

    public boolean withdrawalValidation(double withdrawalAmount, double initialAccountAmount) {
        boolean isValidWithdrawal = false;
        double maxDouble = Double.MAX_VALUE;
        do {
            if (withdrawalAmount <= 0) {
                System.out.println("You must withdraw at least one solari.");
            }
            else if (withdrawalAmount > initialAccountAmount) {
                System.out.println("You cannot withdraw more than is in your account.");
                // In real life ATMs let you overdraft, but I find it scummy, so we're going to prevent it in this program
            }
            else if (withdrawalAmount >= maxDouble) {
                System.out.println("The amount you are trying to withdraw is too high. Please select a smaller amount.");
            }
            else {
                isValidWithdrawal = true;

            }
        }
        while (!isValidWithdrawal);
        return isValidWithdrawal;
    }
}
