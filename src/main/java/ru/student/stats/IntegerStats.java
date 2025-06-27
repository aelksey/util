package ru.student.stats;

import java.util.ArrayList;
import java.util.Locale;

public class IntegerStats {

    ArrayList<Long> integers = new ArrayList<>();
    int size = 0;
    long min = 0;
    long max = 0;
    long sum = 0;
    long average = 0;

    public IntegerStats(ArrayList<Long> integers) {
        this.integers = integers;
        init();
    }

    public void init() {
        size = integers.size();
        min = getMin();
        max = getMax();
        sum = getSum();
        average = getAverage();
    }

    long getMin() {
        long min = 0;
        if(size > 0) min = integers.get(0);
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) < min) min = integers.get(i);
        }
        return min;
    }

    long getMax() {
        long max = 0;
        if(size > 0) max = integers.get(0);
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) > max) max = integers.get(i);
        }
        return max;
    }

    long getSum() {
        long sum = 0;
        for (int i = 0; i < integers.size(); i++) {
            sum = sum + integers.get(i);
        }
        return sum;
    }

    long getAverage() {
        long result = 0;
        if(getSum() > 0 && integers.size() > 0) result = getSum()/integers.size();
        return result;
    }

    public void print(){
        System.out.println("Статистика по типу int :");
        System.out.println("Записано элементов :" + size);
        System.out.println("Минимальное значение :" + min);
        System.out.println("Максимальное значение :" + max);
        System.out.println("Сумма :" + sum);
        System.out.println("Среднее :" + average);
    }

}

