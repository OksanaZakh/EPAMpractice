package temperatureconvertertests;

import org.junit.Test;
import temperatureconverter.TemperatureConverter;

import static org.junit.Assert.assertEquals;


public class TestTemperatureConverter {
    @Test
    public void testConvertFtoC() {
        TemperatureConverter converter=new TemperatureConverter();
        assertEquals(38.888888889,converter.convertFtoC(102), 0.0001);
    }

    @Test
    public void testConvertCtoF(){
        TemperatureConverter converter=new TemperatureConverter();
        assertEquals(19.4,converter.convertCtoF(-7), 0.0001);
   }
   @Test
   public void testConvertCtoK(){
       TemperatureConverter converter=new TemperatureConverter();
       assertEquals(266.15,converter.convertCtoK(-7), 0.1);
   }

    @Test
    public void testConvertKtoC(){
        TemperatureConverter converter=new TemperatureConverter();
        assertEquals(26.85,converter.convertKtoC(300), 0.1);
    }
    @Test
    public void testConvertFtoK(){
        TemperatureConverter converter=new TemperatureConverter();
        assertEquals(588.7055,converter.convertFtoK(600), 0.1);
    }

    @Test
    public void testConvertKtoF(){
        TemperatureConverter converter=new TemperatureConverter();
        assertEquals(80.33,converter.convertKtoF(300), 0.1);
    }
}
