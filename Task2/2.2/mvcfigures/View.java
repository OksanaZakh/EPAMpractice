package com.company.mvcfigures;

import com.company.mvcfigures.Model.Figures.Shape;

public class View {
    public void printData(String data) {
        System.out.println(data);
    }

    public void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - print all shapes\n" +
                "2 - calculate total area\n" +
                "3 - calculate the area of the particular shape\n" +
                "4 - sort shapes from smallest to biggest area\n" +
                "5 - sort shapes on colors\n" +
                "6 - print available actions.\n");
    }

    public void printArray(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}
