package org.example;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class UppercaseService {
    //THE INTEGER THAT WILL SERVE AS A POINTER
    private int n;
    //MAP TO COLLECT THE SUM OF ALL CHARACTERS RETURN
    private Map<Character, Integer> charCount = new LinkedHashMap<>();


    public UppercaseService(int n) {
        this.n = n;
    }
    public String getNthUppercaseCharacters(String text){
        //IF N IS ZERO OR THE STRING INPUT IS EMPTY NO NEED TO COMPUTE ANYTHING
        if(n < 0 || text.equals("")){
            return "";
        }
        // A STRING BUILDER TO ALLOW US TO  APPEND THE CHARACTERS BEING FILTERED
        StringBuilder result = new StringBuilder();
        //FILTER THE STREAM FIRST BY ITS N INDEX POSITION
        //THEN BY ITS CHARACTER
        //THEN MAP EVERY CHAR THAT PASSED THE CRITERIA
        //THEN FROM EACH ELEMENT APPEND IT TO THE STRING TO BE RETURNED
        //AND COLLECT ITS SUM INTO THE MAP INSTANTIATED ABOVE
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
        //CALL THE METHOD HERE SO IT HAPPENS AFTER ALL THE DATA HAS BEEN COMPUTED
        printCharCount();
        //RETURN THE FINAL STRING BUILDER TO STRING
        return result.toString();


    }
    public void printCharCount() {
        //PRINT A FORMATTED VERSION OF THE COUNT MAP
        charCount.forEach((c, count) -> System.out.println(c + " = " + count));
    }

}
