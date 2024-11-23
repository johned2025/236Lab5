package lab5;

import java.util.ArrayList;
import java.util.Iterator;

public class Member {

	private String name;
	public ArrayList<Book> borrowedBooks; // Book class dependency
	
	public Member(String name) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public ArrayList<Book> getBorrowedBooks() { 
		return borrowedBooks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return "Member: " + name;
	}
	public void borrowBook(Book book) {
		BorrowingService borrowingService = new BorrowingService();
		boolean success = borrowingService.borrowBook(this, book); 
		if(success)
		{
		// print something
			System.out.println("Book has been Borrowed");
		} else {
		// print something else
			System.out.println("Book could not be borrowed");
		}
	}
	public void returnBook(Book book) {
		BorrowingService borrowingService = new BorrowingService();
		boolean success = borrowingService.returnBook(this, book); 
		if(success)
		{
		// print something
			System.out.println("Book has been Returned");
		} else {
		// print something else
			System.out.println("Book could not be returned");
		}
	}
	public void listBorrowedBooks() {
		for (Book book : borrowedBooks)
			System.out.println(book); // book.toString()
	}
	public int borrowedBooksCount() {
		return borrowedBooks.size();
	}
	public void returnAllBooks() {
		Iterator<Book> bookIterator = borrowedBooks.iterator();
	    while(bookIterator.hasNext()) {
		   	 Book book = bookIterator.next();
		   	 book.setIsAvailable(true);
	    }
	    borrowedBooks.clear(); // clear array of borrowed books
	}
}
