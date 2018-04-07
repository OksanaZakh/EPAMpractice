package mvcfigures.Model.Figures;

public abstract class Shape implements Drawable,Cloneable {

    protected String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public abstract double calcArea();

    @Override
    public String toString() {
        return "Shape{" +
                "shapeColor='" + shapeColor + '\'' +
                '}';
    }

    public String getShapeColor() {
        return shapeColor;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
