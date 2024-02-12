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
    private Adress adress;


    @Override
    public String toString() {
        return "person.Person{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                /**
                 * description: اینجا وقتی آدرس و میخواد چاپ کنه میره تویه کلاس آدرس و toString اون کلاس میاره و برای چاپ بر اساس همون toString کلاس آدرس چاپ میکنه
                 * */
                ", address='"+adress+'\''+
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



    //public abstract int search(int codemelli );
    //public abstract person.Person searchName(String name);
    //public abstract person.Person search(String family);


}
