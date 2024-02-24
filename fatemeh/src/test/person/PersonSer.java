package test.person;

import test.Repository;
import test.input.Input;

import java.util.ArrayList;

public class PersonSer extends Repository {
    private static int id =1;

    public PersonSer() throws Exception {
    }

    public ArrayList<PersonDao> getPerson() throws Exception{
        ArrayList<PersonDao> personDaos = new ArrayList<>();
        PersonDao personDao1 = new PersonDao();
        personDao1.insert();
        personDao1.update();
        personDao1.delete(id);
        personDao1.select();
        ArrayList<PersonDao> personDaos1 = personDao1.select();
        return personDaos ;
    }

    public static void menuPerson(){
        boolean t = true;
        while (t){
            System.out.println("1.add Person \t 2.show All Person \t 3.get Person by ID \t 4.back");
            System.out.println("enter one number :");
            int select = Input.getScanner().nextInt();
            switch (select){
                case 1:
                    PersonEn personEn = new PersonEn();
                    System.out.println("....");
                    personEn.setId(id);
                    System.out.println("enter first name: ");
                    personEn.setFirstname(Input.getScanner().next());
                    System.out.println("enter last name: ");
                    personEn.setLastname(Input.getScanner().next());
                    id++;
                    break;
                case 2:
                    // PersonDao.getInstance();
                     break;
                case 3:
                    break;
                case 4:
                    t = true;
                    break;

                    }
            }
        }
    }

