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

        String dbUsername = "chethana";
        String dbPassword = "1234";

        System.out.println("Enter your username: ");
        String username = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();

        sc.close();
        if(username != dbUsername && password!= dbPassword){
            System.out.println("Wrong username and password..! Try again..");
        }else if(username != dbUsername && password == dbPassword){
            System.out.println("Wrong username..! Try again..");
        }else if(username == dbUsername && password != dbPassword){
            System.out.println("Wrong password..! Try again..");
        }else{
            System.out.println("Login Successful!");
            ShowBookshopMenu();      
        }
    }

    public static void ShowBookshopMenu(){
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|                 WELCOME TO SHI BOOK SHOP MANAGEMENT SYSTEM                    |");
        System.out.println("+-------------------------------------------------------------------------------+");

        


    }



}