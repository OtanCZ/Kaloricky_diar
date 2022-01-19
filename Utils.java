package com.src.kaloricky_diar;

import com.src.logovani.LoggerLevel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Utils {
    private static Scanner scan = new Scanner(System.in);
    private static FileWriter myWriter;

    static {
        try {
            myWriter = new FileWriter("filename.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int intFromConsole(){
        return scan.nextInt();
    }

    public static String lineFromConsole(){
        scan.nextLine();
        return scan.nextLine();
    }

    public static void printToFile(String message) {
        try {
            myWriter.write(message + "\n");
            myWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
