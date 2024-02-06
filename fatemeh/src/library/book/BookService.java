package library.book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookService {
    public static void main(String[] args) {
        operationBook();

    }


    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Book> b = new ArrayList<>();

    public BookService() {
//        if (b == null) {
//            b = new ArrayList<>();
//        }
    }

    static int idBook = 1;


    private static void addBook() {
        while (true) {
            Book book = new Book();
            System.out.println("enter library.book name:");
            book.setName(sc.next());
            System.out.println("enter library.book author name:");
            book.setAuthor(sc.next());
            System.out.println("enter library.book code:");
            String code = sc.next();
            book.setCode(Integer.parseInt(code));
            System.out.println("enter price library.book");
            book.setPrice(sc.nextInt());
            book.setId(idBook);
            idBook++;
            System.out.println("id library.book : " + book.getId());
            b.add(book);

            String str = "Do you want to continue? ";
            System.out.print(str);
            String user = sc.next();           //next instead nextLine for run if//
            if (user.equalsIgnoreCase("yes")) {
                continue;
            } else if (user.equalsIgnoreCase("no")) {
                break;
            }

        }
    }


    private static void print() {
        for (Book item : b) {
            System.out.println(item);
        }
//        System.out.println(b);
    }

    public static void findById(int id){
        for (Book item: b) {
         if (item.getId()==id){
             System.out.println(item);
         }
        }

//        for (int i = 0; i < b.size() ; i++) {
//            Book library.book = b.get(i);
//           if (library.book.getId()==id){
//               System.out.println(library.book);
//           }
//       }
    }

    private static void update(int id) {
        while (true){
            Book book = new Book();
            int user= sc.nextInt();
            for(Book i:b){
                if(i.getId()==user){
                /*    System.out.println("enter new library.book name:");
                    i.setName(sc.next());
                    System.out.println("enter new library.book author name:");
                    i.setAuthor(sc.next());
                    System.out.println("enter new library.book code:");
                    i.setCode(sc.nextInt());
                    System.out.println("enter new price library.book");
                    i.setPrice(sc.nextInt());*/
            /*        //System.out.println(i.getAuthor());
                    System.out.println("Name="+i.getName());
                    System.out.println("Author="+i.getAuthor());
                    System.out.println("Code="+i.getCode());
                    System.out.println("Price="+i.getPrice());
            */      //  System.out.println(i);
                    System.out.println("what do you want to update? ");
            String which = sc.next();
           if(which.equals("name")){
               System.out.println("enter new library.book name:");
               i.setName(sc.next());
            } else if (which.equals("author")) {
               System.out.println("enter new library.book author name:");
               i.setAuthor(sc.next());
           } else if (which.equals("code")) {
               System.out.println("enter new library.book code:");
               i.setCode(sc.nextInt());
           } else if (which.equals("price")) {
               System.out.println("enter new price library.book");
               i.setPrice(sc.nextInt());
           }
                    System.out.println(i);
                }
            }
            break;
        }
    }
   /* int user = sc.nextInt();
        System.out.println("what do you remove?");
        for (Car i : cars) {
        if (i.getId()==user) {
            if (i.getName().equals(sc.next())) {
                i.setName(null);
                System.out.println(cars);
            }
        }
    }*/
    public static void remove(int u){
        while (true){
            Book book = new Book();
            int idUser= sc.nextInt();
            for (Book iteration : b) {
                if (iteration.getId() == idUser) {
                    System.out.println("enter name");
                    if (iteration.getName().equals(sc.next())) {
                        iteration.setName(null);
                        System.out.println(iteration);
                        break;
                    }
                }
            }

         /*   int use  = sc.nextInt();
            for(Book i :b){
                if(i.getId()==use){
                    System.out.println(b.remove(0));
                    System.out.println(i);
                    b.remove(library.book);
                    System.out.println(i);
                    System.out.println("what do you want to remove? ");
                    String which = sc.next();
                    if(which.equals("name")){
                    }
                }

            }*/
        }
    }


    public static void operationBook() {
        boolean t = true;
        while (t) {
            System.out.println();
            System.out.println("1== create \t2== find by id \t3== update \t4== remove \t5== print \t6== exit");
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    addBook();
                    break;
                case 2:
                   System.out.println("enter id:");
                    int idUser = sc.nextInt();
                    findById(idUser);
                    break;

                case 3:
                    System.out.println("which ID update?\nID: ");
                    update(idBook);
                    break;
                case 4:
                    System.out.println("which ID remove?\nID: ");
                    remove(idBook);
                    break;
                case 5:
                    print();
                    break;
                case 6:
                    t = false;
                    break;
                default:
                    System.out.println("number failed -- enter number true");
                    t = false;
                    break;
            }
        }

    }
}
