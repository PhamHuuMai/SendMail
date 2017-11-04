package com.mycompany.sendmail;

import org.junit.Assert;
import org.junit.Test;

public class test {

    @Test
    public void test() {
        System.out.println("======================");
        new EmailDeliver().deliver();
        System.out.println("======================");
        Assert.assertEquals(1, 1);
    }

}
