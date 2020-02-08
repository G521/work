package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        People people = ac.getBean("peo",People.class);
        System.out.println(people);
        System.out.println(people.getSet().size());

    }
}
