package lab5.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab5.BorrowingService;
import lab5.Ebook;
import lab5.Member;
import lab5.PaperBook;

public class TestBorrowAndReturnChecks {
	
	Member member1;
	Member member2;
	
	PaperBook book1 = new PaperBook("Harry Potter");
	Ebook book2 = new Ebook("Lord of The Rings");
	
	BorrowingService borrowingService = new BorrowingService();
	
	@BeforeEach
	void setUp() throws Exception {
		member1 = new Member("Jane"); // flush borrowedBook array 
		member2 = new Member("Jimmy");   // flush borrowedBook array 
		book1.setIsAvailable(true);
		book2.setIsAvailable(true);
	}
	
	@Test
	void borrowABook() {
		borrowingService.borrowBook(member1,book1);
		assertEquals(borrowingService.borrowBook(member1,book1), false, "Should be false");
	}
	
	@Test
	void returnABook() {
		assertEquals(borrowingService.returnBook(member2,book2), false, "Should be false");
	}

}
