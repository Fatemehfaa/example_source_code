package test.phone;

import test.person.PersonEn;

public class PhoneEn {

    private int id;
    private int phoneNumber;
    private PhoneType phoneType;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PhoneEn{" +
                "id=" + id +
                ", phoneNumber=" + phoneNumber +
                ", phoneType=" + phoneType +
                ", person=" + person +
                '}';
    }

    public PhoneEn setId(int id) {
        this.id = id;
        return this;
    }

    private PersonEn person;

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        if (phoneType.equalsIgnoreCase("mobile"))
            this.phoneType=PhoneType.MOBILE;
        else if (phoneType.equalsIgnoreCase("phone"))
            this.phoneType=PhoneType.PHONE;
    }

    public PersonEn getPerson() {
        return person;
    }

    public void setPerson(PersonEn person) {
        this.person = person;
    }

}
