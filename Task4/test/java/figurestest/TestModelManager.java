package figurestest;

import mvcfigures.Model.Figures.Shape;
import mvcfigures.Model.ModelManager;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestModelManager {
    Shape[] shapes;
    ModelManager modelManager;

    public TestModelManager() {
        Shape[] shapes = TestFiguresCreator.createShapes();
        modelManager = new ModelManager(shapes);
    }

    @Test
    public void testCalculateTotalArea() {
        assertEquals(795, modelManager.calculateTotalArea()
        );
    }

    @Test
    public void testCalculateAreaOfPartShape(){
        assertEquals(709, modelManager.calculateAreaOfParticularShape("Circle"));
    }

    @Test
    public void testSortByArea(){
        assertArrayEquals(TestFiguresCreator.getSortedByAreaArray(), modelManager.sortByArea());
    }

    @Test
    public void testSortByColor(){
        assertArrayEquals(TestFiguresCreator.getSortedByColorArray(), modelManager.sortByColor());
    }

}
