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
        books[4] = new Book(369, "mno-759-57dn", "Embarrased Man", true, "William Williams");


        // Calling Methods
        homeScreen(scan);
    }

    public static void homeScreen(Scanner scan) {
        while (true) {
            System.out.println("\nHome Screen");
            System.out.println("\n(1) Show Available Books");
            System.out.println("(2) Show Checked Out Books");
            System.out.println("(3) Exit");
            System.out.print("\nPlease select an option: ");
            int selection = scan.nextInt();

            switch(selection) {
                case 1:
                    System.out.println("\nAvailable Books:");
                    showAvailableBooks(scan);
                    break;
                case 2:
                    System.out.println("\nChecked Out Books:");
                    showCheckedOutBooks();
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
        // Print out book properties
        for (int i = 0; i < numOfBooks; i++) {
            System.out.println(books[i].toString());
        }
        while (true) {
            //Check out or exit back to home screen
            System.out.println("(1) Check Out");
            System.out.println("(2) Return Home");
            int selection = scan.nextInt();
            scan.nextLine();

            if (selection == 1) {
                System.out.print("Which title are you checking out? ");
                String bookTitle = scan.nextLine();

                System.out.print("Enter your name: ");
                String name = scan.nextLine();


                for (int i = 0; i < numOfBooks; i++) {
                    if (books[i].getTitle().equalsIgnoreCase(bookTitle)) {
                        books[i].checkOut(name);
                        System.out.println("\n" + books[i].getCheckedOutTo() + " has checked out " + books[i].getTitle() + "\n");
                    }
                }
            } else if (selection == 2) {
                return;
            }
        }
    }

    public static void showCheckedOutBooks() {
        for (int i = 0; i < numOfBooks; i++) {
            if(books[i].isCheckedOut() == true){
                System.out.println(books[i]);
            }
        }
    }
}
