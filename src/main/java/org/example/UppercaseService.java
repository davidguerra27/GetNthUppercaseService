package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class UppercaseService {
    private int n;


    public UppercaseService(int n) {
        this.n = n;
    }
    public String getNthUppercaseCharacters(String text){
        if(n < 0){
            return "";
        }
        return IntStream.range(0, text.length())
                .filter(i -> Character.isUpperCase(text.charAt(i)))
                .filter(i -> (i + 1) % n == 0)
                .mapToObj(text::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
