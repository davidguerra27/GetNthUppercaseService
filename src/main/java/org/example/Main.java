package org.example;

public class Main {
    public static void main(String[] args) {

        UppercaseService nthUpper = new UppercaseService(2);
        System.out.println(nthUpper.getNthUppercaseCharacters("IT!#INi#A#"));


    }
}