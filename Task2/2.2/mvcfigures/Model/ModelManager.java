package com.company.mvcfigures.Model;

import com.company.mvcfigures.Model.Figures.AreaComparator;
import com.company.mvcfigures.Model.Figures.ColorComparator;
import com.company.mvcfigures.Model.Figures.Shape;

import java.util.Arrays;

public class ModelManager {

    private Shape[] shapes;

    public ModelManager() {
        shapes = FiguresGenerator.generateFigures();
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

    public void sortByArea() {
        Arrays.sort(shapes, new AreaComparator());
    }

    public void sortByColor() {
        Arrays.sort(shapes, new ColorComparator());
    }
}
