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
		BorrowingBookResult result = borrowingService.borrowBook(this, book); 
		if(result.isSuccess())
		{
		// print something
			this.borrowedBooks.add(book);
			  
			System.out.println(result.getBorrowingMessage());
		} else {
		// print something else
			System.out.println(result.getBorrowingMessage());
		}
	}
	public void returnBook(Book book) {
		BorrowingService borrowingService = new BorrowingService();
		BorrowingBookResult result = borrowingService.returnBook(this, book); 
		if(result.isSuccess())
		{
		// print something
			this.borrowedBooks.remove(book);
			System.out.println(result.getBorrowingMessage());
		} else {
		// print something else
			System.out.println(result.getBorrowingMessage());
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
