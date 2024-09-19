import org.junit.Assert;
import org.junit.Test;

public class TestconvertExamPointsIntoGrade {
    //Проверка на вывод оценки 2
    @Test
    public void testGradeTwo1() {
        String actualResult = getMarkResult(0);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void testGradeTwo2() {
        String actualResult = getMarkResult(35);
        Assert.assertEquals("2", actualResult);
    }

    //Проверка на вывод оценки 3
    @Test
    public void testGradeThree1() {
        String actualResult = getMarkResult(36);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void testGradeThree2() {
        String actualResult = getMarkResult(56);
        Assert.assertEquals("3", actualResult);
    }

    //Проверка на вывод оценки 4
    @Test
    public void testGradeFour1() {
        String actualResult = getMarkResult(57);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void testGradeFour2() {
        String actualResult = getMarkResult(71);
        Assert.assertEquals("4", actualResult);
    }

    //Проверка на вывод оценки 5
    @Test
    public void testGradeFive1() {
        String actualResult = getMarkResult(72);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void testGradeFive2() {
        String actualResult = getMarkResult(100);
        Assert.assertEquals("5", actualResult);
    }

    //Проверка на вывод "no mark result"
    @Test
    public void testGradeNoResult1() {
        String actualResult = getMarkResult(-1);
        Assert.assertEquals("no mark result", actualResult);
    }

    @Test
    public void testGradeNoResult2() {
        String actualResult = getMarkResult(101);
        Assert.assertEquals("no mark result", actualResult);
    }

    private String getMarkResult(Integer mark)
    {
        if(mark>=0 && mark <=35) return "2";
        if(mark>35 && mark <=56) return "3";
        if(mark>56 && mark<71) return "4";
        if(mark>72 && mark<100) return "5";
        return "no mark result";
    }
}
