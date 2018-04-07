package temperatureconvertertests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import temperatureconverter.TemperatureConverter;

import java.util.Arrays;
import java.util.Collection;


@RunWith(value = Parameterized.class)
public class TestTemperatureConverterParametrized {

    public double param;
    public double resultExpected;

    public TestTemperatureConverterParametrized(double param, double resultExpected) {
        this.param = param;
        this.resultExpected = resultExpected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {102, 38.888888889},
                {500, 260},
                {100, 37.777777778}
        });
    }

    @Test
    public void testParam() {
        TemperatureConverter converter = new TemperatureConverter();
        double result = converter.convertFtoC(param);
        Assert.assertEquals(resultExpected, result, 0.0001);
    }
}
