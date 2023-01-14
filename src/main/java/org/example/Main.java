package org.example;

public class Main {
    public static void main(String[] args) {

        UppercaseService nthUpper = new UppercaseService(1);
        System.out.println(nthUpper.getNthUppercaseCharacters("!tCL1Nical"));

    }
}