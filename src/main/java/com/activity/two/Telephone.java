package com.activity.two;

public class Telephone implements Phone {
    @Override
    public void call(String phoneNo) {
        System.out.println("Calling: " + phoneNo);
    }
}
