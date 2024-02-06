package bookPhone;

public class Men extends Person {

    public int getMilitaryService() {
        return militaryService;
    }

    public void setMilitaryService(int militaryService) {
        this.militaryService = militaryService;
    }

    @Override
    public void eating() {
        System.out.println("men eating");

    }

    @Override
    public void speaking() {
        System.out.println("men speaking.");

    }

    public int militaryService;

}
