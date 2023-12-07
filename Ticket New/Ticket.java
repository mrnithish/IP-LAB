package com.yourpackage; 
  
public class Ticket { 
    private String movie; 
    private String seat; 
    private double price; 
  
    public Ticket(String movie, String seat, double price) { 
        this.movie = movie; 
        this.seat = seat; 
        this.price = price; 
    } 
  
    public String getMovie() { 
        return movie; 
    } 
  
    public String getSeat() { 
        return seat; 
    } 
  
    public double getPrice() { 
        return price; 
    } 
}