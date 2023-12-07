package com.yourpackage; 
  
import java.util.ArrayList; 
import java.util.List; 
  
public class Cart { 
    private List<Book> books; 
  
    public Cart() { 
        this.books = new ArrayList<>(); 
    } 
  
    public void addBook(Book book) { 
        books.add(book); 
    } 
  
    public List<Book> getBooks() { 
        return books; 
    } 
  
    public double getTotal() { 
        return books.stream().mapToDouble(Book::getPrice).sum(); 
    } 
} 