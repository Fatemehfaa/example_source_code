package test.input;

import test.Repository;

import java.util.Scanner;

public class Input extends Repository {

    private static Scanner scanner;

    private Input() throws Exception{
        super();

    }

    public static Scanner getScanner(){
        if (scanner == null){
            scanner = new Scanner(System.in);
            return scanner;
        }
        return scanner;
    }

}


