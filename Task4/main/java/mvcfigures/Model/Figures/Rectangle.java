package mvcfigures.Model.Figures;

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


    public void draw() {
        System.out.println("Drawing " + shapeColor + " " + getClass().getName().toLowerCase() + " with sides: " + side1 + ", " + side2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.side1, side1) == 0 &&
                Double.compare(rectangle.side2, side2) == 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Rectangle(shapeColor, side1, side2);
    }
}
