package org.example;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class UppercaseService {
    private int n;
    private Map<Character, Integer> charCount = new LinkedHashMap<>();


    public UppercaseService(int n) {
        this.n = n;
    }
    public String getNthUppercaseCharacters(String text){
        if(n < 0 || text.equals("")){
            return "";
        }
        StringBuilder result = new StringBuilder();
        IntStream.range(0, text.length())
                .filter(i -> (i + 1) % n == 0)
                .filter(i -> Character.isUpperCase(text.charAt(i))
                        || Character.isDigit(text.charAt(i))
                        || !Character.isLetterOrDigit(text.charAt(i)))
                .mapToObj(text::charAt)


                .forEach(c -> {
                    result.append(c);
                    charCount.merge(c, 1, Integer::sum);
                });
        printCharCount();
        return result.toString();


    }
    public void printCharCount() {

        charCount.forEach((c, count) -> System.out.println(c + " = " + count));
    }

}
