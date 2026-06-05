package org.example;

import java.util.Scanner;
// TO DO: Ultimately create UI interface and remove Scanner requirements

public class DisplayInformation {
    public static void main (String[] args) {
        /*
        TO DO: Have this class accept the placeholderId as a parameter
        Would collect from another class/method that first requests PIN/ID and confirms
        using encryption methods as needed
         */
        String placeholderId = String.valueOf(Math.random());
        DisplayInformation newDisplay = new DisplayInformation();
        newDisplay.selectAccountToDisplay(placeholderId);
    }

    // Params - take account holder's ID to pull data from database
    void selectAccountToDisplay(String accountHolderId) {
        // Request an account to display
        // Based on selection get certain information
        // Display to the end user
        // Handle indeterminate number of accounts per user (min 1 checking account but could be more)

        // TO DO: Get all accounts linked to accountHolderId from database, add to list to display
        /* Wait, is that inefficient? Is it more efficient to query each account and its transactions one at a time, or
        would it be better to query them all at once?
         */
        // Won't handle null because ALL valid accountHolderIds should have at least one linked account
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select which account you would like to review: ");
        String placeholderSelection = scanner.nextLine();

        // I need to learn how to query records...

        // Then populate display with last 10 transactions

        scanner.close();

    }
}
