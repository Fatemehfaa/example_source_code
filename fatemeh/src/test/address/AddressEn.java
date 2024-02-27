package test.address;

public class AddressEn {
    private int id=1 ;

    public AddressEn() {
        id++;
    }

    private String street;
    private int zipCode;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "AddressEn{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }


}

