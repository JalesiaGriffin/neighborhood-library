package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {
    private static Book books[] = new Book[20];
    private static int numOfBooks = 5;
    public static void main(String[] args) {
        // Objects
        Scanner scan = new Scanner(System.in);

        // Add books to array
        books[0] = new Book(123, "abc-159-97dn","Happy Man" ,true, "John Doe");
        books[1] = new Book(456, "def-753-87dn", "Sad Man", true, "Yami Sukehiro");
        books[2] = new Book(789, "ghi-852-77dn", "Angry Man", false, "");
        books[3] = new Book(246,"jkl-153-67dn", "Hopeful Man", false, "");
        books[4] = new Book(369, "mno-759-57dn", "Embarrassed Man", true, "William Williams");

        // Calling Methods
        homeScreen(scan);
        scan.close();
    }

    public static void homeScreen(Scanner scan) {
        while (true) {
            System.out.println("\nHome Screen");
            System.out.println("\n(1) Show Available Books");
            System.out.println("(2) Show Checked Out Books");
            System.out.println("(3) Exit");
            System.out.print("\nPlease select an option: ");
            int selection = scan.nextInt();
            scan.nextLine();

            switch(selection) {
                case 1:
                    System.out.println("\nAvailable Books:");
                    showAvailableBooks(scan);
                    break;
                case 2:
                    System.out.println("\nChecked Out Books:");
                    showCheckedOutBooks(scan);
                    break;
                case 3:
                    System.out.println("\nGoodbye.");
                    return;
                default:
                    System.out.println("Invalid Response");
            }
        }
    }

    public static void showAvailableBooks(Scanner scan) {
    try {
        // Print out book properties
        for (int i = 0; i < numOfBooks; i++) {
            System.out.println(books[i].toString());
        }
        while (true) {
            //Check out or exit back to home screen
            System.out.println("\n(1) Check Out");
            System.out.println("(2) Return Home");
            System.out.print("\nPlease select an option: ");
            int selection = scan.nextInt();
            scan.nextLine();

            if (selection == 1) {
                System.out.print("Which title are you checking out? ");
                String bookTitle = scan.nextLine();

                System.out.print("Enter your name: ");
                String name = scan.nextLine();
                // check out
                for (int i = 0; i < numOfBooks; i++) {
                    if (books[i].getTitle().equalsIgnoreCase(bookTitle)) {
                        books[i].checkOut(name);
                        System.out.println("\n" + books[i].getCheckedOutTo() + " has checked out " + books[i].getTitle() + "\n");
                    }
                }
            } else if (selection == 2) {
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public static void showCheckedOutBooks(Scanner scan) {
       try {
           for (int i = 0; i < numOfBooks; i++) {
               if(books[i].isCheckedOut() == true){
                   System.out.println(books[i]);
               }
           }
           // Prompt user to select book or checkout
           while (true) {
               System.out.println("\nC - Check In Book");
               System.out.println("X - Home");
               System.out.print("Please select an option: ");
               String userChoice = scan.nextLine();

               if (userChoice.equalsIgnoreCase("C")) {
                   System.out.print("Enter the Book ID: ");
                   int bookId = scan.nextInt();
                   scan.nextLine();

                   for (int i = 0; i < numOfBooks; i++) {
                       if (bookId == books[i].getId()) {
                           books[i].checkIn();
                           System.out.println("Thank you for returning " + books[i].getTitle());
                       }
                   }
               } else if (userChoice.equalsIgnoreCase("X")) {
                   break;
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
