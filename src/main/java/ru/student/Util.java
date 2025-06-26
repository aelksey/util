package ru.student;

import ru.student.handlers.FileHandler;
import ru.student.handlers.FlagHandler;


// Главный класс приложения

public class Util {

    // Add variable-states i.e. default-behabiour custom file prefixes etc.
    String prefix = "";
    String workdir = "";
    boolean append_mode = false;
    boolean short_stats = false;
    boolean full_stats = false;

    String[] args;

    FlagHandler flagHandler;

    public Util(String[] args){
        this.args = args;
        flagHandler = new FlagHandler(args);
    }

    public void run(){
        if (args.length == 0) {
            flagHandler.printManpage();
            System.exit(1);
        } // Запуск утилиты с пустым вводом
        if (args.length > 0){
            flagHandler.handleHelpFlag();
            workdir = flagHandler.handleOutputFlag();
            prefix = flagHandler.handlePrefixFlag();
            append_mode = flagHandler.handleAppendFlag();
            short_stats = flagHandler.handleShortStatsFlag();
            full_stats = flagHandler.handleFullStatsFlag();
            FileHandler fileHandler = new FileHandler(flagHandler.getArgs(),workdir,prefix,append_mode);
            fileHandler.handle();
            Stats stats = new Stats(fileHandler,short_stats,full_stats);
            stats.init();
            stats.print();
            // Stats - add stats and stuff
        }
    }

    // Logic to parse files etc.


}
