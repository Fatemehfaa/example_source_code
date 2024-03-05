package test.phone;

import test.input.Input;
import test.person.PersonDao;
import test.person.PersonEn;

import java.util.ArrayList;

public class PhoneSer {
    private static int id = 1;


    public PhoneSer() {
    }

    private static ArrayList<PhoneEn>  getPhone(){
        ArrayList<PhoneEn> phoneEnArrayList= new ArrayList<>();
        try{
            phoneEnArrayList=PhoneDao.select();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
       return phoneEnArrayList;
    }

    public static void getMenuphone() {
        boolean t = true;
        while (t) {
            System.out.println("1.add phone \t 2.update phone \t 3.delete phone \t 4.show phone \t 5.exist");
            System.out.println("select one number :");
            int select1 = Input.getScanner().nextInt();
            switch (select1){
                case 1 :
                    try{
                        PhoneEn phone = new PhoneEn();
                        System.out.println("enter phone number (pattern : 09********* )");
                        String phoneNumber = Input.getScanner().next();

                        System.out.println("enter phone type \n MOBILE \n PHONE: ");
                        String phoneType = Input.getScanner().next();

                        if (phoneNumber==null || phoneType == null)
                            throw new RuntimeException("phone number or phone type is null ... ");

                        if (phoneType.equalsIgnoreCase(PhoneType.PHONE.name())){
                            phone.setPhoneType(phoneType);
                            int length = phoneNumber.length();
                            if (length==8 || length==4 || length==3)
                                phone.setPhoneNumber(phoneNumber);
                            else
                                throw new RuntimeException("phone number is not valid .... ");
                        } else if (phoneType.equalsIgnoreCase(PhoneType.MOBILE.name())){
                            phone.setPhoneType(phoneType);
                            int length = phoneNumber.length();
                            String[] split = phoneNumber.split("");
                            if (length == 11  && split[0].equals("0") && split[1].equals("9"))
                                phone.setPhoneNumber(phoneNumber);

                            else
                                throw new RuntimeException("phone number is not valid .... ");
                        }

                        System.out.println("enter person id: ");
                        PersonEn person = PersonDao.getByIdPerson(Input.getScanner().nextInt());
                        phone.setPerson(person);

                        PhoneDao.insert(phone);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try{
                        PhoneEn phoneEn = new PhoneEn();
                        System.out.println("update id");
                        phoneEn = PhoneDao.getPhoneByID(Input.getScanner().nextInt());
                        System.out.println("change phone number");
                        phoneEn.setPhoneNumber(Input.getScanner().next());
                        PhoneDao.update(phoneEn);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try{
                        System.out.println("id delete:");
                        PhoneDao.delete(Input.getScanner().nextInt());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4 :
                    try{
                        System.out.println(getPhone());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5 :
                    t = false;
                    break;

            }
        }
    }
}
