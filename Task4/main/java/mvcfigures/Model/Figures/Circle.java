package mvcfigures.Model.Figures;


public class Circle extends Shape {
    private double radius;

    public Circle(String shapeColor, double radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", shapeColor='" + shapeColor + '\'' +
                '}';
    }


    public void draw() {
        System.out.println("Drawing " + shapeColor + " " + getClass().getName().toLowerCase() + " with radius " + radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Circle(shapeColor, radius);
    }
}
