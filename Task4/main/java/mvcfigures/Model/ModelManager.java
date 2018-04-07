package mvcfigures.Model;



import mvcfigures.Model.Figures.AreaComparator;
import mvcfigures.Model.Figures.ColorComparator;
import mvcfigures.Model.Figures.Shape;

import java.util.Arrays;

public class ModelManager implements Cloneable{

    private Shape[] shapes;

    public ModelManager() {
        shapes = FiguresGenerator.generateFigures();
    }

    public ModelManager(Shape[] shapes) {
        this.shapes = shapes;
    }

    public Shape[] getShapes() {
        return shapes;
    }

    public int calculateTotalArea() {
        int area = 0;
        for (Shape shape : shapes) {
            area += shape.calcArea();
        }
        return area;
    }

    public int calculateAreaOfParticularShape(String shapeName) {
        int area = 0;
        for (Shape shape : shapes) {
            String currName = shape.getClass().getSimpleName();
            if (currName.equals(shapeName)) {
                area += shape.calcArea();
            }
        }
        return area;
    }

    public Shape[] sortByArea() {
        Shape[] sortedArray=shapes.clone();
        Arrays.sort(sortedArray, new AreaComparator());
        return sortedArray;
    }

    public Shape[] sortByColor() {
        Shape[] sortedArray=shapes.clone();
        Arrays.sort(sortedArray, new ColorComparator());
        return sortedArray;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Shape[] newShapes=new Shape[shapes.length];
        for (int i=0; i<shapes.length; i++){
            newShapes[i]=(Shape) shapes[i].clone();
        }

        return newShapes;
    }
}
