package junit.test;

import java.util.Arrays;
 
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
 
@RunWith(Parameterized.class)
public class JunitTestWithParametters {
 
    // @Parameters annotation marks this method as parameters provider
    /*@Parameters(name = "Run #Square of : {0}^2={1}")
    public static Iterable<Object []> data() {
        return Arrays.asList(new Object[][] { { 1, 1 }, { 2, 4 }, { 3, 19 },
                { 4, 16 }, { 5, 25 } });
    }*/
    @Parameters(name = "Run of : {0}")
    public static Iterable<Object[] > data() {
        return Arrays.asList(new Object[][] { {"1111","1122"}, {"22222","22222222222"} });
    }
    // Our two parameters
   // private final int input;
    //private final int resultExpected;
    private String s;
    private String s1;
 
    // Constructor is initialized with one set of parameters everytime
    /*public JunitTestWithParametters(final int input, final int result) {
        this.input = input;
        this.resultExpected = result;
    }*/
    public JunitTestWithParametters( String s, String s1) {
        this.s=s;
        this.s1=s1;
    }
 /*
    @Test
    public void testUserMapping() {
        // You can use here assert also
        Assert.assertEquals(resultExpected, MathUtils.square(input));
    }*/
    @Test
    public void testUserMapping() {
        // You can use here assert also
    	MyPrint.print(s	,s1);
    }
}


final class MathUtils {
    //Return square of a function
    public static int square(final int number) {
        return number * number;
    }
}


final class MyPrint {
    //Return square of a function
    public static void print(String s, String s1) {
        System.out.println(""+s+"-"+s1);
    }
}