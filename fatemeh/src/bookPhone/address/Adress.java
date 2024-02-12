package bookPhone.address;

import bookPhone.person.Person;

public class Adress {

    private int id = 1;
    private String city;
    private String street;
    private String name;
    private int postCode;
    private int unit;


    public Adress() {
        setId(id++);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "address.Adress{" +
                " city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", name=" + name +
                ", postCode=" + postCode +
                ", unit=" + unit +
                '}';
    }

}
