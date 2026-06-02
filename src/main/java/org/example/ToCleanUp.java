package org.example;

import java.util.Scanner;

public class ToCleanUp {
    public static void main(String[] args) {

    }

    public void bankInterface() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String lastName;
        System.out.println("Welcome to the Spacing Guild Interplanetary Bank!\nInput your last name: ");
        lastName = scanner.nextLine();
        // Should also ask for a specific PIN to authenticate
        // Stretch goal - multifactor authentication

        // Do-while loop when the response is not a valid name
        do {
            switch (lastName) {
                case "Atreides": {
                    System.out.println("Welcome, Duke Leto!");
                    break;
                }
                case "Harkonnen": {
                    System.out.println("Greetings, beloved Na-Baron!");
                    break;
                }
                case "Corrino": {
                    System.out.println("All hail the Padishah Emperor of the Known Universe!");
                    break;
                }
                default: {
                    System.out.println("I apologize, you do not seem to have an account here. Please try again:");
                    lastName = scanner.nextLine();
                }
            }
        }
        while (!lastName.equals("Atreides") && !lastName.equals("Harkonnen") && !lastName.equals("Corrino"));

        int decision;
        do {
            Thread.sleep(1000);
            System.out.println("Please select what you would like to do (1-4): ");
            Thread.sleep(1000);
            System.out.println("1: Check your account's total amount.");
            System.out.println("2: Make a deposit into your account.");
            System.out.println("3: Make a withdrawal from your account");
            System.out.println("4: End this transaction.");

            decision = scanner.nextInt();
            switch (decision) {
                case 1: {
                    showAccounts(lastName);
                    break;
                }
                case 2: {
                    System.out.println("Please input the amount you would like to deposit into checking");
                    long deposit = scanner.nextLong();
                    long newTotal = depositToAccount(lastName, deposit);
                    System.out.println("Thank you for your deposit!");
                    System.out.println("Your new total amount is " + newTotal);
                    break;
                }
                case 3: {
                    System.out.println("Please input the amount you would like to withdraw");
                    long withdrawal = scanner.nextLong();
                    // TO DO: Check in advance that withdrawal amount is not greater than checking acct
                    long newTotal = withdrawFromAccount(lastName, withdrawal);
                    System.out.println("Your new total amount is " + newTotal);
                    if (newTotal < 0) {
                        System.out.println("Your checking account now has a negative balance.");
                    }
                    break;
                }
                case 4: {
                    break;
                }
                default: {
                    System.out.println("The number you entered is invalid, please try again.");
                    decision = scanner.nextInt();
                }
            }
        }
        while (decision != 4);

        System.out.println("Thank you for choosing to do business with the Spacing Guild!\n");
        Thread.sleep(1000);
        System.out.printf("We appreciate the business of House %s and look forward to seeing you again!", lastName);
        scanner.close();
    }

    // Should these methods live in separate classes? Ehhhh but I'm in too deep now
    void showAccounts(String householdName) {
        allAccounts showAccount = new allAccounts();
        switch (householdName) {
            // Does not really follow DRY - easy to refactor if running a search to a database
            // Possible TO DO: set up an actual database and have this class make queries
            // TO DO: Refactor for DRY
            case "Atreides": {
                System.out.println("Checking account: " + showAccount.atreidesChecking);
                System.out.println("Savings account: " + showAccount.atreidesSavings);
                System.out.println("Total amount: " + (showAccount.atreidesChecking + showAccount.atreidesSavings));
                break;
            }
            case "Harkonnen": {
                System.out.println("Checking account: " + showAccount.harkonnenChecking);
                System.out.println("Savings account: " + showAccount.harkonnenSavings);
                System.out.println("Total amount: " + (showAccount.harkonnenChecking + showAccount.harkonnenSavings));
                break;
            }
            case "Corrino": {
                System.out.println("Checking account: " + showAccount.corrinoChecking);
                System.out.println("Savings account: " + showAccount.corrinoSavings);
                System.out.println("Total amount: " + (showAccount.corrinoChecking + showAccount.corrinoSavings));
                break;
            }
        }
    }

    long depositToAccount(String householdName, long deposit) {
        // TO DO: Refactor code to avoid overflow issues
        // Show message to user when total would be greater than max long
        // Restart transaction
        allAccounts depositAccount = new allAccounts();
        long newTotal = 0;
        // TO DO: Refactor code so a negative number is not allowed

        // Why do I feel like someone would use a nested ternary operator here...
        // No IntelliJ I did NOT in fact forget a question mark, quit autocorrecting me about it
        switch (householdName) {
            case "Atreides": {
                newTotal = deposit + depositAccount.atreidesChecking;
                break;
            }
            case "Harkonnen": {
                newTotal = deposit + depositAccount.harkonnenChecking;
                break;
            }
            case "Corrino": {
                newTotal = depositAccount.corrinoChecking;
                break;
            }
        }
        return newTotal;
    }

    long withdrawFromAccount(String householdName, long withdrawal) {
        // TO DO: Refactor code to avoid going below MIN long value
        // Show message to user telling them to pick a smaller withdrawal
        // Restart the loop
        allAccounts withdrawAccount = new allAccounts();
        long newTotal = 0;

        switch (householdName) {
            case "Atreides": {
                newTotal = withdrawAccount.atreidesChecking - withdrawal;
                break;
            }
            case "Harkonnen": {
                newTotal = withdrawAccount.harkonnenChecking - withdrawal;
                break;
            }
            case "Corrino": {
                newTotal = withdrawAccount.corrinoChecking - withdrawal;
                break;
            }
        }

        return newTotal;
    }

    // Private classes to contain info on each particular house - static or non-static?
    // In real life would reach back into a database through a query, then make database updates as needed
    // TO DO: Implement the above line with a database (SQLite)
    // Short-term idea for refactoring - keep all of these in a single class rather than multiple separate classes
    class allAccounts {
        long atreidesChecking = 3600200;
        long atreidesSavings = 456898444;
        long harkonnenChecking = 13254689;
        long harkonnenSavings = 865456211;
        long corrinoChecking = 43521235;
        long corrinoSavings = 568644355;
    }
}
