package ru.student.stats;

import java.util.ArrayList;

public class IntegerStats {

    ArrayList<Integer> integers = new ArrayList<>();
    int size = 0;
    int min = 0;
    int max = 0;
    int sum = 0;
    int average = 0;

    public IntegerStats(ArrayList<Integer> integers) {
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

    int getMin() {
        int min = integers.get(0);
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) < min) min = integers.get(i);
        }
        return min;
    }

    int getMax() {
        int max = integers.get(0);
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) > max) max = integers.get(i);
        }
        return max;
    }

    int getSum() {
        int sum = 0;
        for (int i = 0; i < integers.size(); i++) {
            sum = sum + integers.get(i);
        }
        return sum;
    }

    int getAverage() {return (getSum()/integers.size());}

    public void print(){
        System.out.println("Статистика по типу int :");
        System.out.println("Записано элементов :" + size);
        System.out.println("Минимальное значение :" + min);
        System.out.println("Максимальное значение :" + max);
        System.out.println("Сумма :" + sum);
        System.out.println("Среднее :" + average);
    }

}

