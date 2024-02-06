package bookPhone.book;

public class Book {
    private int code;
    private String name;
    private String Author;
    private int price;
    private int id=0;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
       /* if (name.length() < 3) {
            throw new IllegalArgumentException();
        }*/
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setAuthor(String author) {
        Author = author;
    }

    public String getAuthor() {
        return Author;
    }


    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }


    @Override
    public String toString() {
        return "Book{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", Author='" + Author + '\'' +
                ", price=" + price +
                ", id=" + id +
                '}';
    }

}
