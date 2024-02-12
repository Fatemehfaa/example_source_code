package bookPhone.telephone;

import bookPhone.person.Person;

public class telephon {
    private long number;
    private String type;

    @Override
    public String toString() {
        return "telephone.telephon{" +
                "number=" + number +
                ", type='" + type + '\'' +
                '}';
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
