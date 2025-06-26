package ru.student;

// Класс Main, содержащий точку входа в cli-приложение :

// Wrapper for running utility

public class Main {

    public static void main(String[] args) {
        Util util = new Util(args);
        util.run();
    }

}