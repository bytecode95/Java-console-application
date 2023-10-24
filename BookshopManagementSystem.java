import java.util.Scanner;
import java.util.Arrays;

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

        Book[] books = new Book[10];

        for(int i=0; i< books.length; i++){
            books[i] = new Book();
            System.out.print("Enter Book ID: ");
            books[i].bookID = sc.next();
            System.out.print("Enter Book Name: ");
            books[i].name = sc.next();
            System.out.print("Enter Book Price: ");
            books[i].price = sc.nextDouble();
            System.out.print("Enter Book Quantity: ");
            books[i].quantity = sc.nextInt();
            System.out.print("Enter Author: ");
            books[i].author = sc.next();
            
            System.out.println("Book Added Succesfully!...");
            System.out.print("Do you want to add another book(Y/N): ");
            String answer = sc.next();

            switch(answer){
                case "Y":
                    continue;
                case "y":
                    continue;
                case "N":
                    ShowBookshopMenu();
                    break;
                case "n":
                    ShowBookshopMenu();
                    break;
            }
        }


        sc.close();
    }



    public static void DeleteBook(){
         System.out.println("+-------------------------------------------------------------------------------+");
         System.out.println("|                               DELETE BOOK                                     |");
         System.out.println("+-------------------------------------------------------------------------------+");

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
}