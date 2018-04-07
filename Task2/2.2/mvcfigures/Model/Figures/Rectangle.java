package com.company.mvcfigures.Model.Figures;

public class Rectangle extends Shape {

    private double side1;
    private double side2;

    public Rectangle(String shapeColor, double side1, double side2) {
        super(shapeColor);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public double calcArea() {
        return side1 * side2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", shapeColor='" + shapeColor + '\'' +
                '}';
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + shapeColor + " " + getClass().getName().toLowerCase() + " with sides: " + side1 + ", " + side2);
    }
}
