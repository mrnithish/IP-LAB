package com.yourpackage; 
  
public class User { 
    private String userId; 
    private String password; 
    private String creditCardNumber; 
  
    public User(String userId, String password, String creditCardNumber) { 
        this.userId = userId; 
        this.password = password; 
        this.creditCardNumber = creditCardNumber; 
    } 
  
    public String getUserId() { 
        return userId; 
    } 
  
    public String getPassword() { 
        return password; 
    } 
  
    public String getCreditCardNumber() { 
        return creditCardNumber; 
    } 
} 