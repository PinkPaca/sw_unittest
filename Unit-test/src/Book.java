import java.util.*;

public class Book {
	ArrayList<BookDetail> books = new ArrayList<BookDetail>();
	
	
	public void addBook(String id, String title, String author, int issuedYear) {
		for(BookDetail book:books) {
			if(book.id==id) {
				throw new IllegalArgumentException("Existed book");
			}
		}
		books.add(new BookDetail(id, title, author, issuedYear));		
	}
	
	public BookDetail searchBook(String id) {
		for(BookDetail book:books) {
			if(book.id==id) {
				return book;
			}
		}
		throw new IllegalArgumentException("Non existed book");
	}
	
	public void removeBook(String id) {
		for(BookDetail book:books) {
			if(book.id==id) {
				books.remove(book);
				return;
			}
		}
		throw new IllegalArgumentException("Non existed book");

	}
}
