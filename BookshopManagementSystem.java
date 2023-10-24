import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class BookshopManagementSystem{
    public static void main(String[] args){
        ShowloginPage();
    }

    public static void ShowloginPage(){
          Scanner sc = new Scanner(System.in);
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|                                   LOGIN PAGE                                  |");
        System.out.println("+-------------------------------------------------------------------------------+");

        String dbUsername = "admin";
        String dbPassword = "1234";

        boolean loginpage = true;

        while(loginpage){
            System.out.print("Enter your username: ");
            String username = sc.next();
            System.out.print("Enter your password: ");
            String password = sc.next();

        
        if(!username.equals(dbUsername) && !password.equals(dbPassword)){
            System.out.println("Wrong username and password..! Try again..");
            loginpage = true;
            
        }else if(!username.equals(dbUsername) && password.equals(dbPassword)){
            System.out.println("Wrong username..! Try again..");
            loginpage = true;
           
        }else if(username.equals(dbUsername) && !password.equals(dbPassword)){
            System.out.println("Wrong password..! Try again..");
            loginpage = true;
            
        }else{
            System.out.println("Login Successful!");
            loginpage = false;
            ShowBookshopMenu();      
        }

        }  
        sc.close();
    }

    public static void ShowBookshopMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|                 WELCOME TO SHI BOOK SHOP MANAGEMENT SYSTEM                    |");
        System.out.println("+-------------------------------------------------------------------------------+");

        System.out.println("[1]Add Book                                                 [2]Delete Book");
        System.out.println("[3]Upadate Book                                             [4]Show All Books");
        System.out.println("[5]Logout                                                   [6]Exit the System");

        System.out.print("ENTER AN OPTION TO CONTINUE: ");
        String option = sc.next();

        switch(option){
			case "1":
				AddBook();
				break;
			case "2":
				DeleteBook();
				break;
			case "3":
				UpdateBook();
				break;
            case "4":
				ShowAll();
				break;
            case "5":
                LogOut();
                break;
            case "6":
                ExitSystem();
                break;
            default:
                ShowBookshopMenu();

		}

        sc.close();
    }

    public static void AddBook(){
        Scanner sc = new Scanner(System.in);
         System.out.println("+-------------------------------------------------------------------------------+");
         System.out.println("|                               ADD BOOK                                        |");
         System.out.println("+-------------------------------------------------------------------------------+");

        List<Book> books = new ArrayList<>();

        while(true){ 
            System.out.print("Enter Book ID: ");
            String bookID = sc.next();
            System.out.print("Enter Book Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Book Price: ");
            double price = sc.nextDouble();
            System.out.print("Enter Book Quantity: ");
            int quantity = sc.nextInt();
            System.out.print("Enter Author: ");
            String author = sc.nextLine();


            Book newBook = new Book(bookID, name, price, quantity, author);
            books.add(newBook);
            System.out.println("Book Added Succesfully!...");
            

            System.out.print("Do you want to add another book(Y/N): ");
            String answer = sc.next();

            switch(answer){
                case "Y":
                    System.out.println("***********************************************************");
                    continue;
                case "y":
                    System.out.println("***********************************************************");
                    continue;
                case "N":
                    ShowBookshopMenu();
                    break;
                case "n":
                    ShowBookshopMenu();
                    break;
            }
            sc.close();
        }

        
        
        
        
    }



    public static void DeleteBook(){
        Scanner sc = new Scanner(System.in);
         System.out.println("+-------------------------------------------------------------------------------+");
         System.out.println("|                               DELETE BOOK                                     |");
         System.out.println("+-------------------------------------------------------------------------------+");

        System.out.print("Enter Book Id to delete the item: ");
        String bookID = sc.next();



    }

    public static void UpdateBook(){
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|                               UPDATE BOOK                                     |");
        System.out.println("+-------------------------------------------------------------------------------+");
    }

    public static void ShowAll(){
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|                               SHOW ALL BOOK                                   |");
        System.out.println("+-------------------------------------------------------------------------------+");

        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("| %-13s | %-13s | %-13s | %-13s | %-13s |\n","Book ID", "Book Name", "Book Price", "Book Qty", "Book Author");
        System.out.println("---------------------------------------------------------------------------------");


       
       

    }

    public static void LogOut(){
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|                               LOG OUT                                         |");
        System.out.println("+-------------------------------------------------------------------------------+");
    }

    public static void ExitSystem(){
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|                              Exit the System                                  |");
        System.out.println("+-------------------------------------------------------------------------------+");
    }
}

class Book{
    //attributes
    String bookID;
    String name;
    double price;
    int quantity;
    String author;

    public Book(String bookID, String name, double  price, int quantity, String author){
        this.bookID = bookID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("| %-13s | %-13s | %-13s | %-13s | %-13s |\n", bookID, name, price, quantity, author);
    }


}