package lab5;

public class BorrowingService implements BorrowingServiceAPI{

		@Override
		public boolean borrowBook(Member member, Book book) {
			// Check if the member has borrowed the book
			 if (member.getBorrowedBooks().contains(book)) {
			        System.out.println("Member has already borrowed this book: " + book.getTitle());
			        return false; // Member cannot borrow the same book again
			    }
			 
			 member.borrowBook(book);
			 book.setIsAvailable(false); // Mark the book as unavailable after borrowing
			 System.out.println("Successfully borrowed book: " + book.getTitle());
			 return true; // Book borrowed successfully
		}
		@Override
		public boolean returnBook(Member member, Book book) {
		    // Check if the member has borrowed the book
		    if (!member.getBorrowedBooks().contains(book)) {
		        System.out.println("This book was not borrowed by the member: " + book.getTitle());
		        return false; // Book not borrowed by the member
		    }

		    // Return the book: Remove it from the member's borrowed list and mark the book as available
		    member.returnBook(book);
		    book.setIsAvailable(true); // Mark the book as available after returning
		    System.out.println("Successfully returned book: " + book.getTitle());
		    return true; // Book returned successfully
		}

}
