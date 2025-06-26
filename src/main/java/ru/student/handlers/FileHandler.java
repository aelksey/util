package ru.student.handlers;


// Class to receive files thorugh cli arguments and arse them

import ru.student.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHandler {

    ArrayList<String> args;
    String workdir = "";
    String prefix = "";
    boolean append_mode = false;

    ArrayList<String> strings = new ArrayList<>();
    ArrayList<Integer> integers = new ArrayList<>();
    ArrayList<Float> floats = new ArrayList<>();

    public ArrayList<String> getStrings() {return strings;}
    public ArrayList<Integer> getIntegers() {return integers;}
    public ArrayList<Float> getFloats() {return floats;}

    public FileHandler(ArrayList<String> args, String workdir, String prefix, boolean append_mode){
            this.args = args;
            this.workdir = workdir;
            this.prefix = prefix;
            this.append_mode = append_mode;
    }


    public void handle(){
        CheckFiles();
        ReadFiles();
        WriteFiles();
    }

    public void CheckFiles(){
        for (int i = 0 ; i < args.size(); i++){
            File file = new File(args.get(i));
            if (!file.exists() && !file.isFile()){ // Если файла не существет и это не файл - для проверки на директорию
                System.out.println("Неверное значение агрумента("+i+")");
                System.out.println("Файла не существует в заданной директории");
                // Файла не существует, удаляем его из списка аргументов
                args.remove(i);
            }
        }
    }

    public void ReadFiles(){
        Parser parser = new Parser();
        for (String arg : args){
            File file = new File(arg);
            try {
                String line = "";
                BufferedReader reader = new BufferedReader(new FileReader(file));
                // Parse file into buffers
                while ((line = reader.readLine()) != null) parser.parse(line);
                reader.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        strings = parser.getStrings();
        integers = parser.getIntegers();
        floats = parser.getFloats();
    }

    public void WriteFiles(){
            try {
                FileWriter integers_writer = new FileWriter(workdir+"/"+prefix+"integers.txt",append_mode);
                FileWriter floats_writer = new FileWriter(workdir+"/"+prefix+"floats.txt",append_mode);
                FileWriter strings_writer = new FileWriter(workdir+"/"+prefix+"strings.txt",append_mode);

                for(int i : integers) integers_writer.write(String.valueOf(i) + "\n");
                integers_writer.close();

                for(float f : floats) floats_writer.write(String.valueOf(f) + "\n");
                floats_writer.close();

                for(String s : strings) strings_writer.write(s + "\n");
                strings_writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

}
