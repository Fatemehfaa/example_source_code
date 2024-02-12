package Bazi;

import javax.swing.plaf.IconUIResource;
import java.util.Random;
import java.util.Scanner;

public class bazi {
    public static void main(String[] args) {
        String[] str = {"sang" , "kaqaz" , "gheychi"};
        int karbar = 0;
        int system = 0;
        int count= 3;

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        for(int i=0 ; i<=count ; i++){
            System.out.println("input karbar: ");
            String karbarInput =sc.nextLine();
            int rand =random.nextInt(3);
            System.out.println("system: " + str[rand]);
            if(karbarInput.equals(str[0]) && str[rand]==str[0]|| karbarInput.equals(str[1])&& str[rand]== str[1]|| karbarInput.equals(str[2])&&str[rand]==str[2]) {
                System.out.println("again");
                count++;

                } else if (karbarInput.equals(str[0]) && str[rand]==str[1]) {
                System.out.println("bordm");
                karbar++;

            } else if (karbarInput.equals(str[0]) && str[rand]==str[2]) {
                System.out.println("bordm");
                karbar++;

            } else if (karbarInput.equals(str[1]) && str[rand]==str[2]) {
                System.out.println("bakhtam");
                system++;

            } else if (karbarInput.equals(str[1]) && str[rand]== str[0]) {
                System.out.println("bakhtam");
                system++;

            } else if (karbarInput.equals(str[2]) && str[rand] == str[0]) {
                System.out.println("bakhtam");
                system++;

            } else if (karbarInput.equals(str[2]) && str[rand] == str[1]) {
                System.out.println("bordm");
                karbar++;

            } else {
                System.out.println("invalid");
            }

        }
        if(karbar>system){
            System.out.println("man bordm");
        } else if (karbar<system) {
            System.out.println("man bakhtam");
        }

    }
        }



