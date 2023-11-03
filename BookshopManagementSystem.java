import java.util.Arrays;
import java.util.Scanner;

public class BookshopManagementSystem{
    private static Book[] bookstore = new Book[10];
    private static int i = 0;
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
				DeleteBook(bookstore);
				break;
			case "3":
				UpdateBook(bookstore);
				break;
            case "4":
				ShowAll(bookstore);
				break;
            case "5":
                LogOut();
                break;
            case "6":
                System.out.println("__________________________");
                System.out.println("(Program exited with code 0:)");
                break;
            default:
                ShowBookshopMenu();

		}

        
    }

    public static void AddBook(){
        
         System.out.println("+-------------------------------------------------------------------------------+");
         System.out.println("|                               ADD BOOK                                        |");
         System.out.println("+-------------------------------------------------------------------------------+");

        // Book[] bookstore = new Book[10];
        // int i = 0;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);

        while(flag){ 
            bookstore[i] = new Book();
            System.out.print("Enter Book ID: ");
            String bookID = sc.next();
            bookstore[i].setbookID(bookID);
            // Check if the book ID already exists
           if(isBookExist(bookID, bookstore, i)){
                System.out.println("Book ID already exists. Please enter a different Book ID.");
                continue; // Skip to the next iteration of the loop
           }

            System.out.print("Enter Book Name: ");
            String name = sc.next();
            bookstore[i].setName(name);
            System.out.print("Enter Book Price: ");
            double price = sc.nextDouble();
            bookstore[i].setPrice(price);
            System.out.print("Enter Book Quantity: ");
            int quantity = sc.nextInt();
            bookstore[i].setQuantity(quantity);
            System.out.print("Enter Author: ");
            String author = sc.next();
            bookstore[i].setAuthor(author);

            System.out.println("Book added sucessfully!...");

            System.out.print("Do you want to add another book(Y/N): ");
            String answer = sc.next();
            
            answer = answer.toLowerCase();
            if(answer.equals("y")){
                i++;
            }else if(answer.equals("n")){
                ShowBookshopMenu();
                flag = false;
            }else{
                System.out.println("Please add Y/y or N/y");
            }
            System.out.println("**********************************************************");
        }

    
        
    }

    public static boolean isBookExist(String bookID, Book[] bookstore, int currindex){
            for(int j=0; j<currindex; j++){
                if(bookstore[j] != null && bookstore[j].getbookID().equals(bookID)){
                    return true;
                }
            }
            return false;
    }



    public static void DeleteBook(Book[] bookstore){
        Scanner sc = new Scanner(System.in);
         System.out.println("+-------------------------------------------------------------------------------+");
         System.out.println("|                               DELETE BOOK                                     |");
         System.out.println("+-------------------------------------------------------------------------------+");

        // Check if all elements in the array are null
            boolean isEmpty = true;
            for (Book book : bookstore) {
                if (book != null) {
                    isEmpty = false;
                    break;
                }
            }

            if (isEmpty) {
                System.out.println("Oops, bookstore is empty. Please add books.");
                System.out.println(" ");
                System.out.print("Do you want to continue to the content page?(Y/N): ");
                String input = sc.next();
                input = input.toLowerCase();
                if (input.equals("y")) {
                    ShowBookshopMenu();
                    // Exit the method if the array is empty
                }
            }


        
        boolean flag = true;
            while(flag){
                    System.out.print("Enter Book Id to delete the item: ");
                    String id = sc.next();
                    int indexToremove = -1;
                    for(int i=0; i<bookstore.length; i++){
                        if(bookstore[i] != null && id.equals(bookstore[i].getbookID()) ){
                            indexToremove = i;
                            break;
                        }
                    }
                    // If the book is found, remove it from the array
                    if (indexToremove != -1) {
                        System.arraycopy(bookstore, indexToremove + 1, bookstore, indexToremove, bookstore.length - indexToremove - 1);
                        bookstore[bookstore.length - 1] = null;
                        System.out.println("Book with ID " + id + " has been deleted.");
                        for( Book book: bookstore){
                            System.out.println((book));
                        }

                    } else {
                        System.out.println("Book with ID " + id + " not found.");
                    }

                    System.out.println(" ");
                    System.out.print("Do you want to delete another book?(Y/N): ");
                    String answer = sc.next();
                    answer = answer.toLowerCase();
                    if(answer.equals("n")){
                        ShowBookshopMenu();
                        flag = false;
                    }else {
                        DeleteBook(bookstore);
                    }
                      
        }
    }

    public static void UpdateBook(Book[] bookstore){
        Scanner sc = new Scanner(System.in);
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|                               UPDATE BOOK                                     |");
        System.out.println("+-------------------------------------------------------------------------------+");

        boolean flag = true;
        while(flag){
            System.out.print("Enter book ID: ");
            String id = sc.next();
            boolean found = false; 
            for(int i=0; i<bookstore.length; i++){
                if(bookstore[i] != null && id.equals(bookstore[i].getbookID())){
                    System.out.print("Enter book name: ");
                    String name = sc.next();
                    bookstore[i].setName(name);
                    System.out.println("Updated Successfully!..");
                    found = true;
                    break;
                }
            }

            if(!found){
                System.out.println("Book ID not found.");
            }

            System.out.println(" ");
            System.out.print("Do you want to update another book?(Y/N): ");
            String answer = sc.next();
            answer = answer.toLowerCase();
            if(answer.equals("n")){
                ShowBookshopMenu();
                flag = false;
            }else {
                UpdateBook(bookstore);
            }
        }
        


    }

    public static void ShowAll(Book[] bookstore){
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|                               SHOW ALL BOOK                                   |");
        System.out.println("+-------------------------------------------------------------------------------+");

        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("| %-13s | %-13s | %-13s | %-13s | %-13s |\n","Book ID", "Book Name", "Book Price", "Book Qty", "Book Author");
        System.out.println("---------------------------------------------------------------------------------");

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < bookstore.length; i++) {
            if (bookstore[i] != null) {
                System.out.printf("| %-13s | %-13s | %-13.2f | %-13d | %-13s |\n",
                        bookstore[i].getbookID(), bookstore[i].getName(), bookstore[i].getPrice(),
                        bookstore[i].getQuantity(), bookstore[i].getAuthor());
            }
        }

            System.out.println(" ");
            System.out.print("Do you want to go Page content? (Y/N): ");
            String answer = sc.next();
            
            answer = answer.toLowerCase();
            if(answer.equals("y")){
                ShowBookshopMenu();
            }else if(answer.equals("n")){
                ShowAll(bookstore);   
            }
        
       
    }

    

    public static void LogOut(){
        Scanner sc = new Scanner(System.in);
        System.out.println("+-------------------------------------------------------------------------------+");
        System.out.println("|                               LOG OUT                                         |");
        System.out.println("+-------------------------------------------------------------------------------+");

        System.out.print("Do you want to logout?(Y/N)");
        String answer = sc.next();
            answer = answer.toLowerCase();
            if(answer.equals("y")){
                ShowloginPage();
                
            }else{
                ShowBookshopMenu();
            }

    }

}

class Book{
    //attributes
    private String bookID;
    private String name;
    private double price;
    private int quantity;
    private String author;

    //bookid
    public void setbookID(String bookID){
        this.bookID = bookID;
    }

    public String getbookID(){
        return bookID;
    }

    //name
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    //price
    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    //quantity
    public void setQuantity(int quantity){
        if(quantity==0 || quantity<0){
            System.out.println("You can not store book without valid quantity! please check again");
        }else{
            this.quantity = quantity;
        }
        
    }

    public int getQuantity(){
        return quantity;
    }

    //author
    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

}