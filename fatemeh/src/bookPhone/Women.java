package bookPhone;

public class Women extends Person{

    @Override
    public void eating() {
        System.out.println("women eating.");
    }

    @Override
    public void speaking() {
        System.out.println("women speaking.");

    }
    public String hairColor;

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }
}
