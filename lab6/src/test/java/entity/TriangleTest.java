package entity;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TriangleTest {
    @DataProvider(name = "exists")
    public Object[][] existsProviderMethod (Method method){
        return new Object[][] {{2, 3, 4, true},
                               {3, 2, 4, true},
                               {4, 2, 3, true},
                               {2, 4, 3, true},
                               {3, 4, 2, true},
                               {4, 3, 2, true}};
    }

    @DataProvider(name = "notExists")
    public Object[][] notExistsProviderMethod (Method method){
        return new Object[][] {{1, 1, 2, false},
                               {1, 2, 1, false},
                               {2, 1, 1, false},
                               {1, 1, 3, false},
                               {1, 3, 1, false},
                               {3, 1, 1, false}};
    }

    @DataProvider(name = "catchException")
    public Object[][] catchExceptionProviderMethod (Method method){
        return new Object[][] {{0, 0, 0},
                               {0, 1, 0},
                               {0, 0, 1},
                               {1, 0, 0},
                               {1, 1, 0},
                               {0, 1, 1},
                               {1, 0, 1},
                               {-1, -1, -1},
                               {-1, 1, 1},
                               {1, -1, 1},
                               {1, 1, -1}};
    }

    @Test(dataProvider = "exists")
    public void isTriangleExists(Integer firstSide, Integer secondSide, Integer thirdSide, boolean result) {
        Assert.assertEquals(result, new Triangle().isTriangleExists(firstSide, secondSide, thirdSide));
    }

    @Test(dataProvider = "notExists")
    public void isTriangleNotExists(Integer firstSide, Integer secondSide, Integer thirdSide, boolean result) {
        Assert.assertEquals(result, new Triangle().isTriangleExists(firstSide, secondSide, thirdSide));
    }

    @Test(dataProvider = "catchException" , expectedExceptions = {ArithmeticException.class}, expectedExceptionsMessageRegExp = "Side cant be negative or zero")
    public void hasArithmeticException(Integer firstSide, Integer secondSide, Integer thirdSide) {
        new Triangle().isTriangleExists(firstSide, secondSide, thirdSide);
    }
}
