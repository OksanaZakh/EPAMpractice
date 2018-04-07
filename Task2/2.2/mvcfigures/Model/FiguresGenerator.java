package com.company.mvcfigures.Model;

import com.company.mvcfigures.Model.Figures.Circle;
import com.company.mvcfigures.Model.Figures.Rectangle;
import com.company.mvcfigures.Model.Figures.Shape;
import com.company.mvcfigures.Model.Figures.Triangle;

import java.util.Random;

public class FiguresGenerator {

    public static final String[] COLORS = {"RED", "BLUE", "GREEN", "BLACK", "ORANGE", "PURPLE", "WHITE", "GREY", "YELLOW", "PINK"};

    public static Shape[] generateFigures() {
        Random random = new Random();
        Shape[] shapes = new Shape[10];
        for (int i = 0; i < shapes.length; i++) {
            int num = random.nextInt(3) + 1;
            switch (num) {
                case 1:
                    shapes[i] = new Circle(COLORS[random.nextInt(10)], random.nextInt(10));
                    break;
                case 2:
                    shapes[i] = new Rectangle(COLORS[random.nextInt(10)], random.nextInt(10), random.nextInt(10));
                    break;
                case 3:
                    shapes[i] = new Triangle(COLORS[random.nextInt(10)], random.nextInt(10), random.nextInt(10));
                    break;
            }
        }
        return shapes;
    }
}
