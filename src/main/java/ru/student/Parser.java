package ru.student;

import java.util.ArrayList;

public class Parser {

    ArrayList<String> strings = new ArrayList<>();
    ArrayList<Long> integers = new ArrayList<>();
    ArrayList<Float> floats = new ArrayList<>();

    public ArrayList<String> getStrings() {return strings;}

    public ArrayList<Long> getIntegers() {return integers;}

    public ArrayList<Float> getFloats() {return floats;}

    public void parse(String string) {

        // Parse string into various data types using try-catch chain

        // Parse chain :

        // Integer -> float -> String

        try {
            integers.add(Long.parseLong(string));
        } catch (NumberFormatException e) {
            // Ловим exception - переходим дальше в цепочке парсинга
            try {
                floats.add(Float.parseFloat(string));
            } catch (NumberFormatException ex) {
                strings.add(string);
            }
        }

    }
}
