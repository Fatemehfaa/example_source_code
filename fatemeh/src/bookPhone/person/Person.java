package bookPhone.person;

import bookPhone.address.Adress;
import bookPhone.telephone.telephon;

public abstract class Person {

    private  int count;
    private  String name;
    private String family;
    private Adress adress;

    @Override
    public String toString() {
        return "Person{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", adress=" + adress +
                '}';
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Person() {

        count ++;
    }

}
