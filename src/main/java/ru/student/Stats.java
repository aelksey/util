package ru.student;

import ru.student.handlers.FileHandler;
import ru.student.stats.FloatStats;
import ru.student.stats.IntegerStats;
import ru.student.stats.StringStats;

import java.util.ArrayList;

public class Stats {

    // Flags

    boolean short_stats = false;
    boolean full_stats = false;

    // Collections

    ArrayList<String> strings = new ArrayList<>();
    ArrayList<Integer> integers = new ArrayList<>();
    ArrayList<Float> floats = new ArrayList<>();

    // Simple stats

    int strings_size = 0;
    int integers_size = 0;
    int floats_size = 0;

    // Full stats

    public Stats(FileHandler fileHandler,boolean short_stats,boolean full_stats){
        this.integers = fileHandler.getIntegers();
        this.floats = fileHandler.getFloats();
        this.strings = fileHandler.getStrings();
        this.short_stats = short_stats;
        this.full_stats = full_stats;
    }

    public void init(){
        strings_size = strings.size();
        integers_size = integers.size();
        floats_size = floats.size();
    }

    public void print(){
        if(short_stats) {
            System.out.println("Краткая статистика");
            System.out.println("Строковых элементов: " + strings_size);
            System.out.println("Целочисленных элементов: " + integers_size);
            System.out.println("Чисел с плавающей точкой: " + floats_size);
        } else if (full_stats) {
            System.out.println("Полная статистика:");
            IntegerStats integerStats = new IntegerStats(integers);
            FloatStats floatStats = new FloatStats(floats);
            StringStats stringStats = new StringStats(strings);

            integerStats.print();
            floatStats.print();
            stringStats.print();

        }
    }

}
