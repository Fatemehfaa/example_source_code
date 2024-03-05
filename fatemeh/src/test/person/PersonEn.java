package test.person;

import test.address.AddressEn;

import java.util.ArrayList;

public class PersonEn {

    private int id;

    private String firstname;
    private String lastname;
    private Gender gender;

    private AddressEn address;


    public AddressEn getAddress() {
        return address;
    }

    public void setAddress(AddressEn address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if (firstname.length()<3){
            try {
                throw new IllegalAccessException("first name not valid");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("men"))
            this.gender = Gender.MEN;
        else if (gender.equalsIgnoreCase("women"))
            this.gender = Gender.WOMEN;
    }



    @Override
    public String toString() {
        String toString = "PersonEn{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender=" + gender;
        if (address==null)
            toString+=" } \n";
        else
            toString += ", address=" + address + '}' +'\n';

        return toString ;
    }

    public void setAddress(String address) {
    }
}
