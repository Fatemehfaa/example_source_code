package bookPhone;

import bookPhone.address.Adress;
import bookPhone.person.Person;
import bookPhone.person.men;
import bookPhone.person.women;
import bookPhone.telephone.telephon;
import library.book.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        add();
    }

  /*  private static void showAddress() {
        for (Adress item : adresses) {
            System.out.println(item);

        }
    }*/
    private static void showTelephone(){
        for (telephon i:telephons){
            System.out.println(i);

        }
    }
    public static void showPerson(){
        for(Person item:person){
            System.out.println(item);
        }
    }


    public static void showAll() {
        for (Person item : person) {
            System.out.println(item);
        }

        for (telephon i : telephons) {
            System.out.println(i);

        }
        for (Adress item : adresses) {
            System.out.println(item);

        }
    }
    static Scanner sc = new Scanner(System.in);
    public static void searchByCount(int count){
        for(Person i: person){
            if(i.getCount()==count){
                System.out.println(i);
            }

        }
    }


    static ArrayList<Adress> adresses = new ArrayList<>();
    static ArrayList<telephon> telephons = new ArrayList<>();
    static ArrayList<Person> person = new ArrayList<>();
    static int count = 1;
    static int id = 1;

    private static void add() {
        Scanner sc = new Scanner(System.in);

        boolean t = true;
        while (t) {
            telephon tele = new telephon();

            System.out.println("----telephone------");
            System.out.println("(1) add person");
            System.out.println("(2) show person");
            System.out.println("(3) add address");
            System.out.println("(4) show address");
            System.out.println("(5) add telephone");
            System.out.println("(6) show telephone");
            System.out.println("(7) show all");
            System.out.println("(8) search");
            System.out.println("(9) exist");

            int user = sc.nextInt();
            switch (user) {
                case 1:
                    men men1 = new men();
                    System.out.println("enter your gender");
                    String karbar= sc.next();
                    if(karbar.equals("men")){
                        System.out.println("enter your name:");
                        men1.setName(sc.next());
                        System.out.println("enter your family");
                        men1.setFamily(sc.next());
                        men1.setCount(count);
                        System.out.println("count: "+men1.getCount());
                        //men1.setAdress(getAddress(id));
                        //addres.setId(count);
                        //men1.setAdress(addres);
                        count++;
                        person.add(men1);

                    } else if (karbar.equals("women")) {
                        women women1 = new women();
                        System.out.println("enter your name:");
                        women1.setName(sc.next());
                        System.out.println("enter your family");
                        women1.setFamily(sc.next());
                        women1.setCount(count);
                        System.out.println("count: "+women1.getCount());

                        //women1.setAdress(getAddress(id));
                        //women1.setAdress(addres);
                        //id++;
                        count++;
                        person.add(women1);
                    }else {
                        System.out.println("invalid");
                    }
                    break;
                case 2:
                 /*   System.out.println("enter id:");
                    int user3 = sc.nextInt();

                    for(Person i : person){
                        if(i.getCount() == user3){
                            System.out.println(i);
                            System.out.println(i.getAdress());
                        }
                    }*/
                    break;
                case 3:
                    Adress addres = new Adress();
                    System.out.println("enter your city __street __ name __ postCode __ unit:");
                    addres.setCity(sc.next());
                    addres.setStreet(sc.next());
                    addres.setName(sc.next());
                    addres.setPostCode(sc.nextInt());
                    addres.setUnit(sc.nextInt());
                    addres.setId(id);
                   // men1.setAdress(getAddress(id));
                   // men1.setAdress(addres);


                    System.out.println("id: "+addres.getId());
                    id++;
                    System.out.println("enter your id: ");
                    int user4 = sc.nextInt();
                    for (Adress item:adresses){
                        if(item.getId()==user4){
                            System.out.println(item);
                            System.out.println(item.getCity());
                            getAddress(user4);

                        }
                    }
                    break;
                case 4:
                    //showAddress();
                    break;
                case 5:
                    System.out.println("enter your phone number:");
                    tele.setNumber(sc.nextLong());
                    System.out.println("type:\n hamrah\tsabet");
                    tele.setType(sc.next());
                    telephons.add(tele);
                    break;
                case 6:
                    showTelephone();
                    break;
                case 7:
                    showAll();
                    break;
                case 8:
                    System.out.println("count:");
                    int karbar2=sc.nextInt();
                    searchByCount(karbar2);
                    break;
                case 9:
                    t = false;
                    break;
            }


        }
    }

    public static Adress getAddress(int id){
        for (Adress adress:adresses) {
            if(adress.getId()==id){
                return adress;
            }
        }
        return null;
    }

/*
    @Override
    public int search(int codemelli) {
        return 0;
    }

    @Override
    public person.Person searchName(String name) {
        return null;
    }

    @Override
    public person.Person search(String family) {
        return null;
    }*/
}