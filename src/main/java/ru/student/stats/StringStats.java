package ru.student.stats;

import java.util.ArrayList;

public class StringStats {

    ArrayList<String> strings = new ArrayList<>();
    int size = 0;
    String shortest_string = "";
    String longest_string = "";

    public  StringStats(ArrayList<String> strings){
        this.strings = strings;
        init();
    }

    public void init(){
        this.size = strings.size();
        this.shortest_string = getShortestString();
        this.longest_string = getLongestString();
    }

    public String getShortestString(){
        int length = strings.get(0).length();
        int index = 0;

        for (int i = 0 ; i < strings.size(); i++){
            if(strings.get(i).length() < length){
                length = strings.get(i).length();
                index = i;
            }
        }
        return strings.get(index);
    }

    public String getLongestString(){
        int length = strings.get(0).length();
        int index = 0;

        for (int i = 0 ; i < strings.size(); i++){
            if(strings.get(i).length() > length){
                length = strings.get(i).length();
                index = i;
            }
        }
        return strings.get(index);
    }

    public void print(){
        System.out.println("Статистика по типу string :");
        System.out.println("Записано элементов :" + size);
        System.out.println("Самая короткая строка :" + shortest_string);
        System.out.println("Самая длинная строка :" + longest_string);
    }

}
