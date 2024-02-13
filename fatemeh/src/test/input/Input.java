package test.input;

import java.util.Scanner;

public class Input {

    private static Scanner scanner;

    private Input(){}

    public static Scanner getScanner(){
        if (scanner == null){
            scanner = new Scanner(System.in);
            return scanner;
        }
        return scanner;
    }

}
