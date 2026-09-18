/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poepart1;
import java.util.Scanner;
/**
 *
 * @author Student
 */
public class PoePart1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Registration register = new Registration();
        
        String username;
        String password;
        String cellphone;
        //===================
        //REGISTRATION
        //===================
        
        System.out.println("==== REGISTER ====");
        
        System.out.println("Please enter your username: ");
        username = scan.nextLine();
        
        System.out.println("Please enter your password: ");
        password = scan.nextLine();
        
        System.out.println("Please enter your South African cell phone number");
        cellphone = scan.nextLine();
        
        //Check registration details
        String registrationMessage = register.registerUser(username, password, cellphone);
       
        System.out.println(registrationMessage);
        
        //====================
        //LOGIN
        //====================
        
        if (register.registerStatus(username, password, cellphone)){
            System.out.println("\n===== LOGIN =====");
            
            System.out.print("Enter username: ");
            String loginUsername = scan.nextLine();
            
            System.out.print("Enter password: ");
            String loginPassword = scan.nextLine();
            
            //Check login details
            if (loginUsername.equals(username)
                    && loginPassword.equals(password)) {
                
                System.out.println("Welcome" + username +",it is great to see you again.");
            }else{
                System.out.println("Username or passwordincorrects," + "Please try again.");
            }
            
        }else{
            System.out.println("Please fix your registration details" + "before attempting to login");
        }
        scan.close();
    }
}
   