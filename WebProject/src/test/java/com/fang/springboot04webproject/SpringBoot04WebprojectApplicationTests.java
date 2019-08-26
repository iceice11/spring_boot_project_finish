package com.fang.springboot04webproject;

import com.fang.springboot04webproject.controller.HelloController;
import com.fang.springboot04webproject.junitTest.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot04WebprojectApplicationTests {

    private Calculator calculator = new Calculator();
    @Test
    public void contextLoads() {
        Assert.assertEquals(calculator.add(1,2),3);
        System.out.println("success");
    }

}
