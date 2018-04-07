package mvcfigures;

import java.util.Scanner;

public class Utils {
    private Scanner scanner;
    View view;

    public Utils(View view) {
        this.scanner = new Scanner(System.in);
        this.view = view;
    }

    public int inputIntValueWithScanner() {
        while (!scanner.hasNextInt()) {
            view.printData(Constants.WRONG_INPUT_DATA);
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void goForward() {
        scanner.nextLine();
    }
}
