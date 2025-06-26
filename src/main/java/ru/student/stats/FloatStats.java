package ru.student.stats;

import java.util.ArrayList;

public class FloatStats {

    ArrayList<Float> floats = new ArrayList<>();
    int size = 0;
    float min = 0;
    float max = 0;
    float sum = 0;
    float average = 0;

    public FloatStats(ArrayList<Float> floats) {
        this.floats = floats;
        init();
    }

    public void init() {
        size = floats.size();
        min = getMin();
        max = getMax();
        sum = getSum();
        average = getAverage();
    }

    float getMin() {
        float min = floats.get(0);
        for (int i = 0; i < floats.size(); i++) {
            if (floats.get(i) < min) min = floats.get(i);
        }
        return min;
    }

    float getMax() {
        float max = floats.get(0);
        for (int i = 0; i < floats.size(); i++) {
            if (floats.get(i) > max) max = floats.get(i);
        }
        return max;
    }

    float getSum() {
        float sum = 0;
        for (int i = 0; i < floats.size(); i++) {
            sum = sum + floats.get(i);
        }
        return sum;
    }

    float getAverage() {return (getSum()/floats.size());}

    public void print(){
        System.out.println("Статистика по типу float :");
        System.out.println("Записано элементов :" + size);
        System.out.println("Минимальное значение :" + min);
        System.out.println("Максимальное значение :" + max);
        System.out.println("Сумма :" + sum);
        System.out.println("Среднее :" + average);
    }

}

