package com.oksana.zakharchenko.journalmvc;

public class View {

    public void printData(String data) {
        System.out.println(data);
    }

    public void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - add new entry\n" +
                "2 - print all entries in journal\n" +
                "3 - print available actions.\n");
    }
}
