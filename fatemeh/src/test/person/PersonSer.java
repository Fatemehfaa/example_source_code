package test.person;

import test.Repository;
import test.address.AddressDao;
import test.address.AddressEn;
import test.input.Input;
import test.phone.PhoneDao;
import test.phone.PhoneEn;

import java.util.ArrayList;
import java.util.List;

public class PersonSer {

    public PersonSer() {
    }

    private static ArrayList<PersonEn> getPerson() {
        ArrayList<PersonEn> personEnArrayList = new ArrayList<>();
        try {
            personEnArrayList = PersonDao.select();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return personEnArrayList;
    }

    public static void menuPerson() {
        boolean t = true;
        while (t) {
            System.out.println("1.add Person \t 2.update Person \t  3.delete Person \t 4.show All Person \t 5.back");
            System.out.println("enter one number :");
            int select1 = Input.getScanner().nextInt();
            switch (select1) {
                case 1:
                    PersonEn person = new PersonEn();
                    try {
                        System.out.println("enter firstname");
                        person.setFirstname(Input.getScanner().next());
                        System.out.println("enter lastname");
                        person.setLastname(Input.getScanner().next());
                        System.out.println("enter gander");
                        person.setGender(Input.getScanner().next());
                        System.out.println("enter id address");
                        AddressEn addressEn = AddressDao.getByIdAddress(Input.getScanner().nextInt());
                        person.setAddress(addressEn);
                        PersonDao.insert(person);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    try {
                        PersonEn personEn = new PersonEn();

                        System.out.println("update id ");
                        personEn = PersonDao.getByIdPerson(Input.getScanner().nextInt());

                        System.out.println("update firstname ");
                        personEn.setFirstname(Input.getScanner().next());
                        System.out.println("update lastname:");
                        personEn.setLastname(Input.getScanner().next());
                        PersonDao.update(personEn);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("enter id for delete : ");
                        int id = Input.getScanner().nextInt();
                        List<PhoneEn> listPhone = PhoneDao.getAllPhoneByIdPerson(id);
                        if (listPhone!=null){
                            for (PhoneEn phone:listPhone) {
                                PhoneDao.delete(phone.getId());
                            }
                            PersonDao.delete(id);
                        }
                        else
                            PersonDao.delete(id);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println(getPerson());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 5:
                    t = false;
                    break;

            }
        }
    }
}

