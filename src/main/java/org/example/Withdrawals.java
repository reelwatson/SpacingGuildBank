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

        return isValidWithdrawal;
    }
}
