package com.acitivity.one;

import com.acitivity.one.util.ClassC;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        printClassA();
        printClassB();
        printClassC();
    }

    public static void printClassA() {
        ClassA classA = new ClassA();
        classA.checkBoolValue();
    }

    public static void printClassB() {
        ClassB classB = new ClassB();
        System.out.println("Value of days from Class B is: " + Arrays.toString(classB.days));
    }

    public static void printClassC() {
        ClassC classC = new ClassC();
        int result = classC.printNumberFromParameter(5);
        System.out.println("Value of number from Class C is: " + result);
    }

}
