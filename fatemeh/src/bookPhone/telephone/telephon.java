package bookPhone.telephone;

import bookPhone.person.Person;

public class telephon {
     private int idPhone;
    private long number;
    private String type;
    private Person person;


    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "telephon{" +
                "idPhone=" + idPhone +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", person=" + person +
                '}';
    }

    public void setPerson(Person person) {
        this.person = person;
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
