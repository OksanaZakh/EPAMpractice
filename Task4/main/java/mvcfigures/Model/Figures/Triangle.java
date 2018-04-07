package mvcfigures.Model.Figures;

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


    public void draw() {
        System.out.println("Drawing " + shapeColor + " " + getClass().getName().toLowerCase() + " with base " + base + " and height " + height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.base, base) == 0 &&
                Double.compare(triangle.height, height) == 0;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Triangle(super.shapeColor, base, height);
    }
}
