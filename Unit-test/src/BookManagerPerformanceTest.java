import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerPerformanceTest {
	BookManager bookManager;

	@BeforeEach
	void setUp() throws Exception {
		List<Book> initialBooks = new ArrayList<Book>();
		
		for (int i = 1; i <= 10000; i++) {
			initialBooks.add(new Book(i, "Java 기초", "Jane", 2021));
		}
		
		
		bookManager = new BookManager(
				initialBooks
		);		
	}


	@Test
	void searchBook() {
		int firstTargetId = 1;
		int secondTargetId = 5000;
		int thirdTargetId = 10000;
		
		Book firstTargetBook = bookManager.searchBook(firstTargetId);
		Book secondTargetBook = bookManager.searchBook(secondTargetId);
		Book thirdTargetBook = bookManager.searchBook(thirdTargetId);
		

		assertEquals(firstTargetId, firstTargetBook.id);
		assertEquals(secondTargetId, secondTargetBook.id);
		assertEquals(thirdTargetId, thirdTargetBook.id);
	}
	
	@Test
	void binarySearchBook() {
		int firstTargetId = 1;
		int secondTargetId = 5000;
		int thirdTargetId = 10000;
		
		Book firstTargetBook = bookManager.search_bs(firstTargetId);
		Book secondTargetBook = bookManager.search_bs(secondTargetId);
		Book thirdTargetBook = bookManager.search_bs(thirdTargetId);
		

		assertEquals(firstTargetId, firstTargetBook.id);
		assertEquals(secondTargetId, secondTargetBook.id);
		assertEquals(thirdTargetId, thirdTargetBook.id);
	}



}
