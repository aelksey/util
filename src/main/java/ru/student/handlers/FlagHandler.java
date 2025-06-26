package ru.student.handlers;

import ru.student.Flags;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

// Данный класс занимается обработкой опций-флагов, доступных приложению

// Соблюдается принцип чистого кода - для класса четко определена зона ответственности

public class FlagHandler {

    ArrayList<String> args = new ArrayList<>();

    public FlagHandler(String[] args){this.args = new ArrayList<>(List.of(args));}

    public ArrayList<String> getArgs(){return args;}

    // Handle -h flag :

    public void handleHelpFlag(){
        for (String arg : args){
            if(arg.equalsIgnoreCase(Flags.HELP_FLAG.toString())){ // Works for both cases(-flag,-Flag)
                printManpage();
                System.exit(0);
            }
        }
    }

    public void printManpage () {
        // Печать мануала на утилиту
        // H.O.P.A.S.F acronym
        String eng_manpage[] = {
                "ENG:",
                "Usage: java -jar util [options] <unordered_files> [args...]",
                "Options:", "-h   to display manual page",
                "-o   to specify output directory",
                "-p   to specify output files prefix",
                "-a   to append to output files instead of rewriting(overrides default behaviour)",
                "-s   to output short-form statistics into cli",
                "-f   to output full statistics into cli\n"
        };

        String rus_manpage[] = {
                "RUS:",
                "Использование: java -jar util [опции] <неотсортированные_файлы> [файл...]",
                "Опции-флаги:",
                "-h   для отображения справки",
                "-o   для задания выходной директории сортированных файлов",
                "-p   для указания префикса сортированных файлов",
                "-a   заменяет стандартное поведение записи в выходные файлы(добавление)",
                "-s   для вывода краткой формы статистики",
                "-f   для выврода полной формы статистики\n"
        };

        for (String str : eng_manpage) System.out.println(str);
        for (String str : rus_manpage) System.out.println(str);

    }

    // Handle other flags :

    // Check -h flag and print Manual page
    // For -o and other flags that require arguments treat them as following (-o argument)

    public String handleOutputFlag() {
        String result = "";
        for (int i = 0; i < args.size(); i++) {
            if (args.get(i).equalsIgnoreCase(Flags.OUTPUT_DIR_FLAG.toString())) { // Works for both cases(-flag,-Flag)
                if(args.size() > 1){
                    result = args.get(i+1);
                    // Remove flag and argument from list of args
                    args.remove(i);
                    args.remove(i+1);
                }else{
                    System.out.println("Пустой агрумент для флага -o");
                    System.exit(1);
                }
                File file = new File(result);
                if(!file.exists()){System.out.println("Неправильный аргумент для флага -o" +
                "(директория не существует)");System.exit(1);}
                break;
            }
        }
        return result;
    }

    public String handlePrefixFlag(){
        String result = "";
        for (int i = 0 ; i < args.size() ; i++){
            if (args.get(i).equalsIgnoreCase(Flags.PREFIX_FLAG.toString())) { // Works for both cases(-flag,-Flag)
                if (args.size() > 1) {
                    result = args.get(i+1);
                    // Remove flag and argument from list of args
                    args.remove(i);
                    args.remove(i+1);
                } else {
                    System.out.println("Пустой агрумент для флага -p");
                    System.exit(1);
                }
                break;
            }
        }
        return result;
    }

    public boolean handleAppendFlag(){
        boolean activated = false;
        for (int i = 0; i < args.size() ; i++){
            if(args.get(i).equalsIgnoreCase(Flags.APPEND_TO_FILE_FLAG.toString())){ // Works for both cases(-flag,-Flag)
                activated = true;
                // Remove flag
                args.remove(i);
            }
        }
        return activated;
    }

    public boolean handleShortStatsFlag(){
        boolean activated = false;
        for (int i = 0 ; i < args.size() ; i++){
            if(args.get(i).equalsIgnoreCase(Flags.SHORT_STATS_FLAG.toString())){ // Works for both cases(-flag,-Flag)
                activated = true;
                // Remove flag
                args.remove(i);
            }
        }
        return activated;
    }

    public boolean handleFullStatsFlag(){
        boolean activated = false;
        for (int i = 0 ; i < args.size() ; i++){
            if(args.get(i).equalsIgnoreCase(Flags.FULL_STATS_FLAG.toString())){ // Works for both cases(-flag,-Flag)
                activated = true;
                // Remove flag
                args.remove(i);
            }
        }
        return activated;
    }

}
