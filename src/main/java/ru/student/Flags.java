package ru.student;

// Перечисление(enum) для всех доступных флагов, принимаемых программой

public enum Flags {
    HELP_FLAG("-h"),
    OUTPUT_DIR_FLAG("-o"),
    PREFIX_FLAG("-p"),
    APPEND_TO_FILE_FLAG("-a"),
    SHORT_STATS_FLAG("-s"),
    FULL_STATS_FLAG("-f");

    private String str; // Строковое значение флага

    public String toString(){return str;} // Метод для возвращения строкового представления флага

    private Flags(String str){this.str = str;} // Приватный конструктор перечисления


}
