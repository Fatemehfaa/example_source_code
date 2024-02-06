package singlton;

import java.util.ArrayList;

public class Person {

    private Person() {
    }

   private static ArrayList<Person> person = new ArrayList<>();
    public static ArrayList<Person> getInstance(){
        return person;

    }




}
