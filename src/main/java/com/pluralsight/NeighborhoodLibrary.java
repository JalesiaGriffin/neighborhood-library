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


        // Methods
        homeScreen(scan);
    }

    public static void homeScreen(Scanner scan) {
        while (true) {
            System.out.println("Home Screen");
            System.out.println("\n(1) Show Available Books");
            System.out.println("(2) Show Checked Out Books");
            System.out.println("(3) Exit");
            System.out.println("Please select an option.");
            int selection = scan.nextInt();

            switch(selection) {
                case 1:
                    showAvailableBooks();
                    break;
                case 2:
                    showCheckedOutBooks();
                    break;
                case 3:
                    System.out.println("Goodbye.");
                    return;
                default:
                    System.out.println("Invalid Response");
            }
        }
    }

    public static void showAvailableBooks() {
        for (int i = 0; i < numOfBooks; i++) {
            System.out.println(books[i].toString());
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
