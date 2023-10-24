import java.util.Scanner;

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
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|                 WELCOME TO SHI BOOK SHOP MANAGEMENT SYSTEM                    |");
        System.out.println("+-------------------------------------------------------------------------------+");

        System.out.println("[1]Add Book                                                 [2]Delete Book");
        System.out.println("[3]Upadate Book                                             [4]Show All Books");
        System.out.println("[5]Logout                                                   [6]Exit the System");


    }



}