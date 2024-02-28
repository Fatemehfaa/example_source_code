package test.phone;

import test.Repository;
import test.input.Input;

import java.util.ArrayList;

public class PhoneSer {
    private static int id = 1;


    public PhoneSer() {
    }

    public static ArrayList<PhoneEn>  getPhone(){
        ArrayList<PhoneEn> phoneEnArrayList= new ArrayList<>();
        try{
            PhoneDao phoneDao = new PhoneDao();
            phoneEnArrayList = phoneDao.select();

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
                        PhoneDao.insert();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try{
                        PhoneDao.update();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 3:
                    try{
                        PhoneDao.delete(id);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4 :
                    try{
                        PhoneSer phoneSer = new PhoneSer();
                        ArrayList<PhoneEn> phoneEnArrayList = phoneSer.getPhone();
                        for(PhoneEn phoneEn:phoneEnArrayList){
                            System.out.println(phoneEn.getPhoneNumber());
                            System.out.println(phoneEn.getPhoneType());
                        }
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
