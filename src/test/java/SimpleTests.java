import org.junit.Assert;
import org.junit.Test;

public class SimpleTests {

    //Проверка "указан некорректный рост"
    @Test
    public void testZeroHeight() {
        var actualResult = getIMTResult(0f, 60f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    public void testNegativeHeight() {
        var actualResult = getIMTResult(-1f, 60f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    public void testExceedsMaxHeight() {
        var actualResult = getIMTResult(351f, 60f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    //Проверка "указан некорректный вес"
    @Test
    public void testZeroWeight() {
        var actualResult = getIMTResult(180f, 0f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    public void testNegativeWeight() {
        var actualResult = getIMTResult(180f, -1f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    public void testExceedsMaxWeight() {
        var actualResult = getIMTResult(180f, 1001f);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    //Проверка "выраженный дефицит массы тела"
    @Test
    public void testUnderweight() {
        var actualResult = getIMTResult(180f, 51.84f);
        Assert.assertEquals("выраженному дефициту массы тела", actualResult);
    }

    //Проверка "недостаточная масса тела"
    @Test
    public void testInsufficientWeight() {
        var actualResult = getIMTResult(180f, 58.32f);
        Assert.assertEquals("недостаточной массе тела", actualResult);
    }

    //Проверка "нормальная масса тела"
    @Test
    public void testNormalWeightMin() {
      var actualResult = getIMTResult(180f, 61.56f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void testNormalWeightMax() {
        var actualResult = getIMTResult(180f, 77.76f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    //Проверка "избыточная масса тела"
    @Test
    public void testOverweight() {
        var actualResult = getIMTResult(180f, 81f);
        Assert.assertEquals("избыточной массе тела", actualResult);
    }


    private String getIMTResult(Float heightCm, Float weightKg)
    {
        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));
        String userResult = null;
        if (userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        } else if (userIndex > 16 && userIndex < 19)  {
            userResult = "недостаточной массе тела";
        } else if (userIndex > 19 && userIndex < 25) {
            userResult = "нормальной массе тела";
        } else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }
        if (heightCm.equals(0.0f)) userResult+="указан некорректный рост";
        return userResult;
    }
}
