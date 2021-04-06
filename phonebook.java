package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("----------------------------------");
        System.out.println("\nPHONE BOOK v1.0");
        System.out.print("\nHur många nummer vill du registrera?");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        Person[] pBook = new Person[n];
        for (int i = 0; i < n; i++) {

            System.out.println("Person " + (i+1));
            System.out.println("Förnamn: ");
            String firstName = scan.nextLine();
            System.out.println("Efternamn: ");
            String lastName = scan.nextLine();
            System.out.println("Telefonnummer: ");
            String phone = scan.nextLine();

            pBook[i] = new Person(firstName, lastName, phone );
        }

        boolean exit = false;

        while(!exit) {
            System.out.println("Sök i telefonboken (avsluta med \"exit\"):");
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
                System.out.println("Förnamn: " + p.firstName + "\nEfternamn: " + p.lastName + "\ntfn: " + p.phone + "\n\n");
                contactFound = true;
            }
        }
        if(!contactFound) {
            System.out.println("Hittas ingen i telefonboken med efternamnet \"" + searchString + "\"");
        }
    }
}
