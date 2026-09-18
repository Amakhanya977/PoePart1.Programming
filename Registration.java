/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart1;

public class Registration{
    // Checks if username meets requirements
    public boolean checkUserName(String username){
        return username.contains("_") &&username.length()>5;
    }
    //Checks if password meets complexity requirements
    public boolean checkPasswordComplexity(String password){
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        for (int i = 0; i< password.length(); i++){
            char c = password.charAt(i);
            
            if (Character.isUpperCase(c)){
                hasCapital = true;
            }
            if (Character.isDigit(c)){
                hasNumber = true;
            }
            if(!Character.isLetterOrDigit(c)){
                hasSpecial = true;
            }
        }
        return password.length() >8
                && hasCapital
                && hasNumber
                && hasSpecial;
    }
    //Checks if South African cell phone number is valid
    public boolean checkCellPhoneNumber(String cellphone){
        return cellphone.matches("^\\+27[0-9]{9}$");
    }
    //Registers the user and returns a message
    public String registerUser(String username,String password,String cellphone){
        
        if (checkUserName(username)
                && checkPasswordComplexity(password)
                && checkCellPhoneNumber(cellphone)){
            return "Registration successful";
        }else{
            return "Registration unsuccessful";
        }
    }
    //Returns true if all registration requirements are met
    public boolean registerStatus(String username,String password, String cellphone){
        
        return checkCellPhoneNumber(cellphone)
                && checkUserName (username)
                && checkPasswordComplexity(password);
    }
}