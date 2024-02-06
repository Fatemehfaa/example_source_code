package library;

import library.book.Book;
import library.customer.Customer;
import library.employee.Employee;

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

        System.out.println("Select a number.\n1==>library.book\n2==>library.employee\n3==>library.customer");
        String input = sc.next();


/*        for(Book item : b){
            if(input.equals("library.book")){
                System.out.println(b);
            }else {
                break;
            }
        }
        for(library.employee.Employee item:e){
            if (input.equals("library.employee")){
                System.out.println(e);
            }
        }
        for(library.customer.Customer item :c){
            System.out.println(c);

        }*/
        while (true) {

            Book book = new Book();
            Employee employee = new Employee();
            Customer customer = new Customer();
            //set library.book
            if (input.equals("1")) {
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


                System.out.println("Book name: " + book.getName());
                System.out.println("Book author: " + book.getAuthor());
                System.out.println("Book code: " + book.getCode());
                System.out.println("library.book price: " + book.getPrice());
            }

            if (input.equals("2")) {
                System.out.println("enter library.employee code:");
                employee.setEmployeeCode(sc.nextInt());
                System.out.println("enter library.employee name:");
                employee.setName(sc.next());
                System.out.println("enter library.employee family:");
                employee.setFamily(sc.next());
                System.out.println("enter library.employee nationalCode:");
                employee.setNationalCode(sc.nextInt());
                System.out.println("enter library.employee number:");
                employee.setNumber(sc.nextInt());
                System.out.println();
                employee.setId(idEmployee);

                System.out.println("library.employee code : " + employee.getEmployeeCode());
                System.out.println("library.employee name : " + employee.getName());
                System.out.println("library.employee family: " + employee.getFamily());
                System.out.println("library.employee nationalCode: " + employee.getNationalCode());
                System.out.println("library.employee number:" + employee.getNumber());

            }
            if (input.equals("3")) {
                System.out.println("enter library.customer name:");
                customer.setName(sc.next());
                System.out.println("enter library.customer family:");
                customer.setFamily(sc.next());
                System.out.println("enter library.customer nationalCode:");
                customer.setNationalCode(sc.nextInt());
                System.out.println("enter library.customer number:");
                customer.setNumber(sc.nextInt());
                customer.setId(idCustomer);

                System.out.println("library.customer name:" + customer.getName());
                System.out.println("library.customer family:" + customer.getFamily());
                System.out.println("library.customer nationalCode:" + customer.getNationalCode());
                System.out.println("library.customer number:" + customer.getNumber());
                System.out.println("");
            }


            b.add(book);
            e.add(employee);
            c.add(customer);

            /*switch (input) {
                case "1":
                    System.out.println("library.book" + b);
                    break;
                case "2":
                    System.out.println("library.employee" + e);
                    break;
                case "3":
                    System.out.println("library.customer" + c);
                    break;
                default:
                    System.out.println("error");
            }
*/
            idBook++;
            idEmployee++;
            idCustomer++;
            System.out.println("id library.book : " + book.getId());
            System.out.println("id library.employee:" + employee.getId());
            System.out.println("id library.customer:" + customer.getId());


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








