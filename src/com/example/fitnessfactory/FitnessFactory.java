package com.example.fitnessfactory;

import java.util.Scanner;

public class FitnessFactory {
    static class Member {
        int age;
        int id;
        String name1;
        String name2;
    }

    public static void main(String[] args) {
        displayChoices();
        switchStructure();
    }

    public static void displayChoices() {
        System.out.println("\n\n");
        System.out.println("********");
        System.out.println("=======WELCOME========");
        System.out.println(" TO ");
        System.out.println(" THE FITNESS FACTORY ");
        System.out.println("\n Our listed services ");
        System.out.println("+ +");
        System.out.println("|(1) Enroll |");
        System.out.println("|(2) Timings |");
        System.out.println("|(3) Rules   |");
        System.out.println("+ +");
    }

    public static void switchStructure() {
        int choice = acceptChoice();

        switch (choice) {
            case 1:
                membership();
                break;
            case 2:
                displayTimings();
                returnToMenu();
                break;
            case 3:
                displayRules();
                returnToMenu();
                break;
            default:
                System.out.println("Invalid choice! Exiting...");
                break;
        }
    }

    public static int acceptChoice() {
        System.out.println("\nEnter number for the desired choice: ");
        return new Scanner(System.in).nextInt();
    }

    public static void displayTimings() {
        System.out.println("\n\nOur timings");
        System.out.println("Monday to Saturday");
        System.out.println("Morning : 5:30am to 10:00am");
        System.out.println("Evening : 3:30pm to 10:00pm");
        System.out.println("Closed on Sunday");
        System.out.println("Thank you\n\n");
    }

    public static void displayRules() {
        System.out.println("\n\n THE FITNESS FACTORY \n");
        System.out.println(".Re-rack the weights");
        System.out.println(".Handle equipment carefully");
        System.out.println(".Don't disturb other members");
        System.out.println(".Train only once a day\n");
    }

    public static void returnToMenu() {
        System.out.println("Enter 0 to exit or 1 to go back\n");
        int n = new Scanner(System.in).nextInt();
        if (n == 1) {
            displayChoices();
            switchStructure();
        }
    }

    public static void membership() {
        System.out.println("\n\nOur membership options");
        System.out.println("1. One month : Rs. 1300");
        System.out.println("2. Three months : Rs. 3500");
        System.out.println("3. Six months : Rs. 6000");
        System.out.println("Membership fee: Rs. 40\n");

        int choice = acceptChoice();
        compute(choice);
    }

    public static void compute(int choice) {
        Member member = new Member();
        member.id = (int) (Math.random() * 1000);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first name: ");
        member.name1 = scanner.next();
        System.out.println("Enter second name: ");
        member.name2 = scanner.next();
        System.out.println("Enter age: ");
        member.age = scanner.nextInt();

        if (!check(member.name1) || !check(member.name2)) {
            System.out.println("Invalid name! Exiting...");
            return;
        }

        if (member.age <= 12 || member.age >= 95) {
            System.out.println("Invalid age! Exiting...");
            return;
        }

        System.out.println("\nThank you for enrollment");
        System.out.println("Name: " + member.name1 + " " + member.name2);
        System.out.println("Age: " + member.age);
        System.out.println("Unique ID: " + member.id);

        int total = switch (choice) {
            case 1 -> 1300 + 40;
            case 2 -> 3500 + 40;
            case 3 -> 6000 + 40;
            default -> {
                System.out.println("Invalid membership choice! Exiting...");
                yield 0;
            }
        };

        System.out.println("Total cost: Rs. " + total);
    }

    public static boolean check(String str) {
        return str.chars().allMatch(Character::isLetter);
    }
}
