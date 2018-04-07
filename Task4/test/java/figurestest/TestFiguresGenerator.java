package figurestest;

import mvcfigures.Model.FiguresGenerator;
import org.junit.Assert;
import org.junit.Test;

public class TestFiguresGenerator {
    @Test
    public void testGenerateFigures() {
        Assert.assertNotNull(FiguresGenerator.generateFigures());
    }

}
