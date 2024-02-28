package test.person;

import test.Repository;
import test.address.AddressDao;
import test.address.AddressEn;
import test.input.Input;

import java.util.ArrayList;

public class PersonSer  {
    private static int id =1;

    public PersonSer() {
    }

    public ArrayList<PersonEn> getPerson(){
        ArrayList<PersonEn>personEnArrayList = new ArrayList<>();
        try {
            PersonDao personDao1 = new PersonDao();
            personEnArrayList = personDao1.select();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return personEnArrayList;
    }

    public static void menuPerson(){
        boolean t = true;
        while (t){
            System.out.println("1.add Person \t 2.update Person \t  3.delete Person \t 4.show All Person \t 5.back");
            System.out.println("enter one number :");
            int select1 = Input.getScanner().nextInt();
            switch (select1){
                case 1:
                    try {
                        PersonDao.insert(id);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        PersonDao.update();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                     break;
                case 3:
                    try{
                        PersonDao.delete(id);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        PersonSer personSer = new PersonSer();
                        ArrayList<PersonEn> personEnArrayList=personSer.getPerson();
                        for(PersonEn personEn:personEnArrayList){
                            System.out.println(personEn.getId());
                            System.out.println(personEn.getFirstname());
                            System.out.println(personEn.getLastname());
                            System.out.println(personEn.getAddress());
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 5:
                    t = true;
                    break;

                    }
            }
        }
    }

