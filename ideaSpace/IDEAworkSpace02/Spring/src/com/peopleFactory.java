package com;

public class peopleFactory {
    public static People newInstance(){
        return new People(1,"123");
    }
}
