package com.oksana.zakharchenko.dictionary;

import java.util.Scanner;

public class ScannerInput {
    private Scanner scanner;

    public ScannerInput() {
        this.scanner = new Scanner(System.in);
    }

    public int inputIntValueWithScanner() {
        while (!scanner.hasNextInt()) {
            System.out.println("Wrong input data!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String inputStringWithScanner() {
        while (!scanner.hasNextLine()) {
            System.out.println("Wrong input data!");
            scanner.next();
        }
        return scanner.nextLine();
    }

    public void goForward() {
        scanner.nextLine();
    }
}
