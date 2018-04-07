package com.company.mvcfigures.Model.Figures;

public class Triangle extends Shape {

    private double base;
    private double height;

    public Triangle(String shapeColor, double base, double height) {
        super(shapeColor);
        this.base = base;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", height=" + height +
                ", shapeColor='" + shapeColor + '\'' +
                '}';
    }

    @Override
    public double calcArea() {
        return 0.5 * base * height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + shapeColor + " " + getClass().getName().toLowerCase() + " with base " + base + " and height " + height);
    }

}
