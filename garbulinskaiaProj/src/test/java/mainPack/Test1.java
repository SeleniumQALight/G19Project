package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class Test1 {
    @Test
    public void test1(){
        System.out.println("test 221");

        Assert.fail("Fail test");
    }


    @After
    public  void tearDown(){

    }
}
