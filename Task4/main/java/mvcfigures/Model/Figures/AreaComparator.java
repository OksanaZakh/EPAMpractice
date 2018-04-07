package mvcfigures.Model.Figures;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    public int compare(Shape o1, Shape o2) {
        if (o1.calcArea() == o2.calcArea()) {
            return 0;
        } else if (o1.calcArea() > o2.calcArea()) {
            return 1;
        } else return -1;
    }
}
