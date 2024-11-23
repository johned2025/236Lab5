package lab5;

public class BorrowingService implements BorrowingServiceAPI{

		@Override
		public boolean borrowBook(Member member, Book book) {
			System.out.println("Borrowing book: " + book);
			if (book != null && book.getIsAvailable() == true && !member.getBorrowedBooks().contains(book)) {
				member.borrowedBooks.add(book);
				book.setIsAvailable(false);
				return true;
			}
			return false;
		}
		@Override
		public boolean returnBook(Member member, Book book) {
			System.out.println("Returning book: " + book);
			if (member.getBorrowedBooks().contains(book)) {
				member.borrowedBooks.remove(book);
				book.setIsAvailable(true);
				return true;
			}
			return false;
    }
}
