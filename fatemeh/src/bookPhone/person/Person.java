package bookPhone.person;

import bookPhone.address.Adress;

/*enum Gender{
    men,
    women
}*/
public abstract class Person {

    private  int count;
    private  String name;
    private String family;

    @Override
    public String toString() {
        return "Person{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", adress=" + adress +
                '}';
    }

    private Adress adress;


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



    //public abstract int search(int codemelli );
    //public abstract person.Person searchName(String name);
    //public abstract person.Person search(String family);


}
