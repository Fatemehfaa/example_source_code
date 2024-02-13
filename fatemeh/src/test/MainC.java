package test;

import test.address.AddressSer;
import test.input.Input;

import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        boolean t = true;

        while (t){
            System.out.println("1.address \t 2.person \t 3.phone \t\t 4.exit");
            System.out.println("select one number :");
            int select = Input.getScanner().nextInt();
            switch (select){
                case 1:
                    AddressSer.getMenuAddress();
                    break;

                case 4:
                    t=false;
                    break;
            }
        }

    }
}
