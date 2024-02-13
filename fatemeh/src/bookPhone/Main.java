package bookPhone;

import bookPhone.address.Adress;
import bookPhone.person.Person;
import bookPhone.person.men;
import bookPhone.person.women;
import bookPhone.telephone.telephon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        add();
    }


    public static void showPerson() {
        for (Person item : person) {
            System.out.println(item);
        }
    }


    public static void showAll() {
        for (Person per : person) {
            System.out.println(per);
        }
        for (telephon telephon : telephons) {
            System.out.println(telephon);
        }
        for (Adress item : adresses) {
            System.out.println(item);
        }
    }


    public static void searchByCount(int count) {
        for (Person i : person) {
            if (i.getCount() == count) {
                System.out.println(i);
            }
        }
    }


    static ArrayList<Adress> adresses = new ArrayList<>();
    static ArrayList<telephon> telephons = new ArrayList<>();
    static ArrayList<Person> person = new ArrayList<>();
    static int count = 1;
    static int id = 1;
    static int idPhone = 1;

    private static void add() {
        Scanner sc = new Scanner(System.in);

        boolean t = true;
        while (t) {

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
                    System.out.println("enter your gender");
                    String karbar = sc.next();
                    if (karbar.equals("men")) {
                        men men1 = new men();
                        System.out.println("enter your name:");
                        men1.setName(sc.next());
                        System.out.println("enter your family");
                        men1.setFamily(sc.next());
                        men1.setCount(count);


/**
 * متد getForSetAddress() بر اساس id اطلاعات ادرس را دریافت کرده و به اطلاعات شخص اضافه میکند
 * */

                        Adress forSetAddress = getForSetAddress();
                        men1.setAdress(forSetAddress);

                 /*       telephon addTele = addTele2();
                        men1.setTele(addTele);

*/
                        System.out.println("count: " + men1.getCount());
                        count++;
                        person.add(men1);


                    } else if (karbar.equals("women")) {
                        women women1 = new women();
                        System.out.println("enter your name:");
                        women1.setName(sc.next());
                        System.out.println("enter your family");
                        women1.setFamily(sc.next());
                        women1.setCount(count);
                        System.out.println("count: " + women1.getCount());


/**
 * متد getForSetAddress() بر اساس id اطلاعات ادرس را دریافت کرده و به اطلاعات شخص اضافه میکند
 * */

                        Adress forSetAddress = getForSetAddress();
                        women1.setAdress(forSetAddress);

                        /*telephon addTele = addTele2();
                        women1.setTele(addTele);
*/

                        count++;
                        person.add(women1);


                    } else {
                        System.out.println("invalid");
                    }
                    break;
                case 2:
                    for (Person per : person) {
                        System.out.println(per);
                    }
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

                    System.out.println("id: " + addres.getId());
                    id++;

                    adresses.add(addres);
                    break;
                case 4:
                    showAddress();
                    break;
                case 5:
                    telephon tele = new telephon();
                    System.out.println("enter your phone number:");
                    tele.setNumber(sc.nextLong());
                    System.out.println("type:\n hamrah\tsabet");
                    tele.setType(sc.next());
                    tele.setIdPhone(idPhone);
                    System.out.println("idPhone: " + tele.getIdPhone());

                    System.out.println("add person id: ");
                    int idPerson = sc.nextInt();
                    for(Person i : person){
                        if(i.getCount()==idPerson){
                            tele.setPerson(i);
                        }
                    }
                    idPhone++;
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
                    int karbar2 = sc.nextInt();
                    searchByCount(karbar2);
                    break;
                case 9:
                    t = false;
                    break;
                case 10 :
                    showPerson();
                    break;
            }


        }
    }

    private static bookPhone.telephone.telephon addTele2() {
        System.out.println("id phone user: ");
        int idPhoneUser = sc.nextInt();
        telephon telephone =addTelephone(idPhoneUser);
        return telephone;
    }


    private static void showAddress() {
        for (Adress adress : adresses) {
            System.out.println(adress);
        }
    }

    public static Adress getAddress(int id) {
        for (Adress adress : adresses) {
            if (adress.getId() == id) {
                return adress;
            }
        }
        return null;
    }

    public static Adress getForSetAddress() {
/**
 * description: میخواهیم ادرس را بر اساس Id که درون آدرس وجود دارد دریافت کنیم.
 *  و آبجکت آدرس که به عنوان خروجی به ما داده شده است را به ادرس درون person اضافه میکنیم
 * */
        System.out.println("enter id address : ");
        int idAddress = sc.nextInt();
        Adress address = getAddress(idAddress);
        /* ادرس دریافتی را اضافه میکنم به مشخصات شخص */
        return address;
    }

    private static void showTelephone() {

        for (telephon i : telephons) {
                System.out.println(i);
            }
        }

    public static telephon addTelephone(int idPhone){
        for(telephon i : telephons){
            if (i.getIdPhone() == idPhone) {
                return i;
            }
        }
        return null;
    }

}