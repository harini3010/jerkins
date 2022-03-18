package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Book;

public class BookService {
	
	static int count = 0;
	
	public double getDiscount(Book book) {
		
		boolean status = true;
		
		double discount = 0.05;
		
		while(status) {
		
		if(book.getPrice()>200) {
			discount = 0.10;
		}
		
		else if(book.getPrice()>200 && book.getPrice() <= 500) {
			
			discount = 0.15;
		}
		count++;
		if(count>1000000) {
			status = false;
		}
		}
		return discount;
	}
	
	public Book getBook(int key) {
		if(key < 0) {
			
			throw new RuntimeException();
		}
		
		else {
			
		switch(key)  {
		case 1:
			return new Book(100,"java",120);
		case 2:
			return new Book(101,"spring",90);	
		case 3:
			return new Book(102,"react",250);
		default:
			return null;
		}
	}
			
	
}
	public List<Book> getAllBooks(){
		
		List<Book> list = new ArrayList<>();
		list.add(null);
		list.add(new Book (100,"java",120));
		list.add(null);
		list.add(new Book (101,"spring",200));
		list.add(null);
		list.add(new Book (102,"react",250));
//		
		return list;
	
		
		
		
		
		
	}
	


}
