package bookPhone.telephone;

import bookPhone.person.Person;

public class telephon {
     private int idPhone;
    private long number;
    private String type;


    @Override
    public String toString() {
        return "telephon{" +
                "idPhone=" + idPhone +
                ", number=" + number +
                ", type='" + type + '\'' +
                '}';
    }


    public int getIdPhone() {
        return idPhone;
    }

    public void setIdPhone(int idPhone) {
        this.idPhone = idPhone;
    }


    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public telephon() {
    }


}
