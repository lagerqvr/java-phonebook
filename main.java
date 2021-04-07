package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.out.println("\nPHONE BOOK v1.0");
        System.out.print("\nHow many phone numbers do you want to register?");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        Person[] pBook = new Person[n];
        for (int i = 0; i < n; i++) {

            System.out.println("Person " + (i+1));
            System.out.println("First name: ");
            String firstName = scan.nextLine();
            System.out.println("Last name: ");
            String lastName = scan.nextLine();
            System.out.println("Phone number: ");
            String phone = scan.nextLine();

            pBook[i] = new Person(firstName, lastName, phone );
        }

        boolean exit = false;

        while(!exit) {
            System.out.println("Search in the phone directory (exit with \"exit\"):");
            String input = scan.nextLine();
            if(input.equals("exit")) {
                exit = true;
            }
            else {
                search(input, pBook);
            }
        }
    }

    private static void search(String searchString, Person[] pBook) {
        boolean contactFound = false;
        for(Person p : pBook) {
            if(p.lastName.contains(searchString)) {
                System.out.println("First name: " + p.firstName + "\nLast name: " + p.lastName + "\ntfn: " + p.phone + "\n\n");
                contactFound = true;
            }
        }
        if(!contactFound) {
            System.out.println("Can't find anyone in the phone directory with the last name \"" + searchString + "\"");
        }
    }
}
