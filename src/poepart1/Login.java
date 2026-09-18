/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poepart1;

/**
 *
 * @author Student
 */
class Login {
    private String registeredUsername;
    private String registeredPassword;
    private String firstName;
    private String lastName;
    
    // Check if username is correctly formatted
    public boolean checkUserName(String username){
        return username.contains("_")
                && username.length() <=5;
    }
    //Check if password meets complexity requirements
    public boolean checkPasswordComplexity(String password){
        if (password.length() <8){
            return false;
        }
        boolean hasCapitalLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;
        
        for (int i = 0; i< password.length(); i++){
            char character = password.charAt(i);
            
            if (Character.isUpperCase(character)){
                hasCapitalLetter = true;
            }
            if (Character.isDigit(character)){
                hasNumber = true;
            }
            if (!Character.isLetterOrDigit(character)){
                hasSpecialCharacter = true;
            }
        }
        return hasCapitalLetter
                && hasNumber
                && hasSpecialCharacter;
    }
    //Check South African cell phone number
    public boolean checkCellPhoneNumber(String phoneNumber){
        return phoneNumber.matches("\\+27[0-9]{9}");
    }
    //Register user
    public String registerUser(String username,
            String password,
            String phoneNumber,
            String firstName,
            String lastName){
        if(! checkUserName (username)){
            return "Username is not correctly formatted , please ensure your username contains an underscore and is no than five characters long.";
        }
        if(!checkPasswordComplexity(password)){
            return "Password is not correctly formatted; please ensure that the password contains at least eisght characters,a capiatal letter, a numberand a special character.";
        }
        if(!checkCellPhoneNumber(phoneNumber)){
            return "Cell phone number is incorrectly formatted or does not contain an international code, please correct the number and try again.";
        }
        registeredUsername = username;
        registeredPassword = password;
        this.firstName = firstName;
        this.lastName = lastName;
        
        return "Username successfully captured.";
    }
    // Login user
    public boolean loginUser(String username,String password){
        
        return registeredUsername != null
                && registeredPassword != null
                && registeredUsername.equals(username)
                && registeredPassword.equals(password);
    }
    //Return login status
    public String returnLoginStatus(String username, String password){
        if (loginUser(username,password)){
            return"Welcome" + firstName +" " +lastName +",it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}
