package com.example.demo;

import static org.hamcrest.Matchers.*;
import org.hamcrest.Matcher;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;

public class BookServiceHamcrestTest {
	
	@Test
	@DisplayName(value = "Test Book Class has a property author")
	void testBookHasAuthorProperty() {
		
		Book book = new Book();
		
		assertThat(book, hasProperty("authorName"));

	}
	
	BookService service = new BookService();
	@Test
	@DisplayName(value = "get book method in book service should return a book with price less that 100 for book with id 101")
	void testBookMethodShouldReturn() {
		
		Book book = service.getBook(2);
		double actual = book.getPrice();
		double expected = 100;
		assertThat(actual, is(lessThan(expected)));
	}
	
	


}
