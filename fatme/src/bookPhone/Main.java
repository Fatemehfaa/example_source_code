package bookPhone;

import bookPhone.book.Book;
import bookPhone.customer.Customer;
import bookPhone.employee.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
        buyBook();
        borrowBook();
        showMember();
*/


        ArrayList<Book> b = new ArrayList<>();
        ArrayList<Employee> e = new ArrayList<>();
        ArrayList<Customer> c = new ArrayList<>();
        int id = 1;
        int idBook = id, idEmployee = id, idCustomer = id;
        Scanner sc = new Scanner(System.in);

        System.out.println("Select a number.\n1==>bookPhone.book\n2==>bookPhone.employee\n3==>bookPhone.customer");
        String input = sc.next();


/*        for(Book item : b){
            if(input.equals("bookPhone.book")){
                System.out.println(b);
            }else {
                break;
            }
        }
        for(bookPhone.employee.Employee item:e){
            if (input.equals("bookPhone.employee")){
                System.out.println(e);
            }
        }
        for(bookPhone.customer.Customer item :c){
            System.out.println(c);

        }*/
        while (true) {

            Book book = new Book();
            Employee employee = new Employee();
            Customer customer = new Customer();
            //set bookPhone.book
            if (input.equals("1")) {
                System.out.println("enter bookPhone.book name:");
                book.setName(sc.next());
                System.out.println("enter bookPhone.book author name:");
                book.setAuthor(sc.next());
                System.out.println("enter bookPhone.book code:");
                String code = sc.next();
                book.setCode(Integer.parseInt(code));
                System.out.println("enter price bookPhone.book");
                book.setPrice(sc.nextInt());
                book.setId(idBook);


                System.out.println("Book name: " + book.getName());
                System.out.println("Book author: " + book.getAuthor());
                System.out.println("Book code: " + book.getCode());
                System.out.println("bookPhone.book price: " + book.getPrice());
            }

            if (input.equals("2")) {
                System.out.println("enter bookPhone.employee code:");
                employee.setEmployeeCode(sc.nextInt());
                System.out.println("enter bookPhone.employee name:");
                employee.setName(sc.next());
                System.out.println("enter bookPhone.employee family:");
                employee.setFamily(sc.next());
                System.out.println("enter bookPhone.employee nationalCode:");
                employee.setNationalCode(sc.nextInt());
                System.out.println("enter bookPhone.employee number:");
                employee.setNumber(sc.nextInt());
                System.out.println();
                employee.setId(idEmployee);

                System.out.println("bookPhone.employee code : " + employee.getEmployeeCode());
                System.out.println("bookPhone.employee name : " + employee.getName());
                System.out.println("bookPhone.employee family: " + employee.getFamily());
                System.out.println("bookPhone.employee nationalCode: " + employee.getNationalCode());
                System.out.println("bookPhone.employee number:" + employee.getNumber());

            }
            if (input.equals("3")) {
                System.out.println("enter bookPhone.customer name:");
                customer.setName(sc.next());
                System.out.println("enter bookPhone.customer family:");
                customer.setFamily(sc.next());
                System.out.println("enter bookPhone.customer nationalCode:");
                customer.setNationalCode(sc.nextInt());
                System.out.println("enter bookPhone.customer number:");
                customer.setNumber(sc.nextInt());
                customer.setId(idCustomer);

                System.out.println("bookPhone.customer name:" + customer.getName());
                System.out.println("bookPhone.customer family:" + customer.getFamily());
                System.out.println("bookPhone.customer nationalCode:" + customer.getNationalCode());
                System.out.println("bookPhone.customer number:" + customer.getNumber());

            }


            b.add(book);
            e.add(employee);
            c.add(customer);

            /*switch (input) {
                case "1":
                    System.out.println("bookPhone.book" + b);
                    break;
                case "2":
                    System.out.println("bookPhone.employee" + e);
                    break;
                case "3":
                    System.out.println("bookPhone.customer" + c);
                    break;
                default:
                    System.out.println("error");
            }
*/
            idBook++;
            idEmployee++;
            idCustomer++;
            System.out.println("id bookPhone.book : " + book.getId());
            System.out.println("id bookPhone.employee:" + employee.getId());
            System.out.println("id bookPhone.customer:" + customer.getId());


            String str = "Do you want to continue? ";
            System.out.print(str);
            String user = sc.next();           //next instead nextLine for run if//
            if (user.equals("yes")) {
                continue;
            } else if (user.equals("no")) {
                break;
            }

        }

        //System.out.println(b.get(0).getName());

    }
        private static void showMember () {
        }

        private static void borrowBook () {
        }

        private static void buyBook () {
        }


    }








