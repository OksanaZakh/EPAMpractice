package com.company.mvcfigures.Model.Figures;

import java.util.Comparator;

public class ColorComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape o1, Shape o2) {
        return o1.getShapeColor().compareTo(o2.getShapeColor());
    }
}
