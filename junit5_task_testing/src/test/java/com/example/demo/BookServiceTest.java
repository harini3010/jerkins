package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;

public class BookServiceTest {

	private BookService service;
	
	@BeforeAll
	public static void setUp() {
		//System.out.println("before all called");
	}

	@BeforeEach
	public void setDown() {
		//System.out.println("before each called");

		service = new BookService();
	}

	@Test
	@DisplayName("get book method should not return value for choices upto 3")
	public void testGetBookMethodNotNull() {
		//System.out.println("dummuy test called");
		//		Book actual = service.getBook(2);
		//		assertNotNull(actual);
		
		assertAll("getBook method with choice 1 to 3",
				()-> assertNotNull(service.getBook(1)),
				()->assertNotNull(service.getBook(2)),
				()->assertNotNull(service.getBook(3))
			);
	}
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	void testGetBookMethodWithParam(int key) {
		
		assertNotNull(service.getBook(key));
	}

	@Test
	@DisplayName("getBook Method should return null value for choices above 3")
	 void testGetBookMethodReturnNull() {
		//System.out.println("dummy test two called");
		
		assertNull(service.getBook(4));
	}
	
	@Test
	 void testForException() {
		 Throwable exception =
				  assertThrows(RuntimeException.class, ()->{service.getBook(-2);
				  });
		
	}
	@Test
	@DisplayName(value = "getDiscount Method should return 0.10 discount for price less than or equal to 200")
	void testForTenPercentDiscount() {
		Book book = service.getBook(1);
		double actual = service.getDiscount(book);
		double expected = 0.10;
		assertEquals(expected, actual);
	}
	@Test
	@DisplayName(value = "getDiscount Method should return 0.15 discount for price greater than 200 and")
	void testForFifteenPercentDiscount() {
		Book book = service.getBook(3);
		double actual = service.getDiscount(book);
		double expected = 0.15;
		assertEquals(expected, actual);
	}
	@Test
	@DisplayName(value = " getDiscount Method should be completed with 100 ms")
	void testgetBookCompleteTiming() {
		Book book = service.getBook(3);
		double actual = service.getDiscount(book);
		double expected = 0.15;
		double value = assertTimeout(Duration.ofMillis(100), ()-> service.getDiscount(book));
		assertEquals(expected, actual);
		
	}
	@DisplayName(value ="getDiscount method should return 0.05")
	@Test
	@Disabled("disabled till timeout bug in the method is fixed")
	void testGetBookTestFivePercentDiscount() {
		Book book = service.getBook(1);
		double actual = service.getDiscount(book);
		double excepted = 0.15;
		
		assertEquals(excepted, actual);
	}
	

	@ParameterizedTest
	@ValueSource(ints = {1,3,5})
	@DisplayName("GetAll Books method should return a list with index position 1,3,5 not being null")
	void testGetAllBooksPosition(int key) {
		//assertFalse(true,"Not Yet Implemented");
		assertNotNull(service.getAllBooks().get(key));
	}
	
		
		
	
	
	@AfterAll
	public static void destroy() {
//System.out.println("after all called");
	}

	@AfterEach
	public void tearDown() {
//System.out.println("after each called");
	}
}