import java.util.ArrayList;
 
public class BookManager {
	
	public ArrayList<Book> books = new ArrayList<Book>();
	
	
	public void addBook(Book book) {
		for(Book existBook:books) {
			if(existBook.id==book.id) {
				System.out.println("해당 ID(" +book.id +")는 이미 존재합니다.");
				throw new IllegalArgumentException("Existed book");
			}
		}
		books.add(book);
		book.printBook("도서가 추가되었습니다.");
		
	}
	
	
	public Book searchBook(String id) {
		for(Book book:books) {
			if(book.id==id) {
				book.printBook("");

				return book;
			}
		}
		System.out.println("검색된 도서가 없습니다.");
		throw new IllegalArgumentException("Non existed book");
	}
	
	public void removeBook(String id) {
		for(Book book:books) {
			if(book.id==id) {
				book.printBook("도서를 삭제하였습니다.");

				books.remove(book);
				return;
			}
		}
		throw new IllegalArgumentException("Non existed book");
	}
}
