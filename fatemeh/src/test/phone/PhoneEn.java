package test.phone;

import test.person.PersonEn;

public class PhoneEn {

    private int id;
    private String phoneNumber;
    private PhoneType phoneType;

    private PersonEn personEn;

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

    public PersonEn getPersonEn() {
        return personEn;
    }

    public PhoneEn setPersonEn(PersonEn personEn) {
        this.personEn = personEn;
        return this;
    }

    private PersonEn person;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
