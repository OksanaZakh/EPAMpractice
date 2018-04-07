package figurestest;

import mvcfigures.Model.Figures.Circle;
import mvcfigures.Model.Figures.Rectangle;
import mvcfigures.Model.Figures.Shape;
import mvcfigures.Model.Figures.Triangle;

public class TestFiguresCreator {
    public static Shape[] createShapes() {
        Shape[] shapes = new Shape[10];
        shapes[0] = new Circle("PURPLE", 9);
        shapes[1] = new Circle("RED", 8);
        shapes[2] = new Triangle("PINK", 1, 1);
        shapes[3] = new Rectangle("ORANGE", 5, 6);
        shapes[4] = new Circle("GREEN", 8);
        shapes[5] = new Rectangle("PURPLE", 6, 1);
        shapes[6] = new Circle("GREEN", 4);
        shapes[7] = new Rectangle("PINK", 4, 5);
        shapes[8] = new Circle("PURPLE", 1);
        shapes[9] = new Rectangle("GREEN", 6, 5);
        return shapes;
    }

    public static Shape[] getSortedByAreaArray(){
        Shape[] shapes = new Shape[10];
        shapes[9] = new Circle("PURPLE", 9);
        shapes[7] = new Circle("RED", 8);
        shapes[0] = new Triangle("PINK", 1, 1);
        shapes[4] = new Rectangle("ORANGE", 5, 6);
        shapes[8] = new Circle("GREEN", 8);
        shapes[2] = new Rectangle("PURPLE", 6, 1);
        shapes[6] = new Circle("GREEN", 4);
        shapes[3] = new Rectangle("PINK", 4, 5);
        shapes[1] = new Circle("PURPLE", 1);
        shapes[5] = new Rectangle("GREEN", 6, 5);
        return shapes;
    }

    public static Shape[] getSortedByColorArray(){
        Shape[] shapes = new Shape[10];
        shapes[2] = new Rectangle("GREEN", 6, 5);
        shapes[1] = new Circle("GREEN", 4);
        shapes[0] = new Circle("GREEN", 8);
        shapes[3] = new Rectangle("ORANGE", 5, 6);
        shapes[4] = new Triangle("PINK", 1, 1);
        shapes[5] = new Rectangle("PINK", 4, 5);
        shapes[8] = new Circle("PURPLE", 1);
        shapes[7] = new Rectangle("PURPLE", 6, 1);
        shapes[6] = new Circle("PURPLE", 9);
        shapes[9] = new Circle("RED", 8);
        return shapes;
    }
}
