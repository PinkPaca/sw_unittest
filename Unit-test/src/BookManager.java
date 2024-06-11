import java.util.ArrayList;
import java.util.Comparator;
 
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
	
	
	public Book searchBook(int id) {
		for(Book book:books) {
			if(book.id==id) {
				book.printBook("");

				return book;
			}
		}
		System.out.println("검색된 도서가 없습니다.");
		throw new IllegalArgumentException("Non existed book");
	}
	
	public void removeBook(int id) {
		for(Book book:books) {
			if(book.id==id) {
				book.printBook("도서를 삭제하였습니다.");

				books.remove(book);
				return;
			}
		}
		throw new IllegalArgumentException("Non existed book");
	}
	
	// 책 id로 이진 탐색하는 함수 
	public Book search_bs(int id, int low, int high) {		
		int mid;
		
		while(low <= high) {
			mid = (low + high) / 2;
			
			Book targetBook = books.get(mid);
			
			if(id == targetBook.id) {		// 탐색 성공 
				return targetBook;
			} else if(id < targetBook.id) { // 왼쪽 탐색 
				high = mid - 1;
			} else {						// 오른쪽 탐색 
				low = mid + 1;
			}
		}
		
		// 탐색 실패, 오류 발생 
		System.out.println("binary search: 검색된 도서가 없습니다.");
		throw new IllegalArgumentException("Non existed book");
	}
}
