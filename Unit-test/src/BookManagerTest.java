import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerTest {
	BookManager bookManager;

	@BeforeEach
	void setUp() throws Exception {
		bookManager = new BookManager(
				List.of(
						new Book(1, "Java 기초", "Jane", 2021),
						new Book(2, "Java 심화", "Jane", 2021),
						new Book(3, "C 기초", "Joe", 2021),
						new Book(4, "C 심화", "Joe", 2021),
						new Book(5, "C++ 기초", "Jack", 2021),
						new Book(6, "C++ 심화", "Jack", 2021),
						new Book(7, "Go 기초", "James", 2021),
						new Book(8, "Go 심화", "James", 2021),
						new Book(9, "Rust 기초", "Jin", 2021),
						new Book(10, "Rust 심화", "Jin", 2021)
				)
		);
		
		
	}

	@Test
	void addBook() {
		int prevSize = bookManager.books.size();
		Book book = new Book(11, "자바 기초", "Jane", 2021);

		bookManager.addBook(book);

		assertEquals(bookManager.books.size(), prevSize + 1);
	}

	@Test
	void addExistBook() {
		Book book1 = new Book(1, "자바 기초", "Jane", 2021);

		assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(book1));

	}

	@Test
	void searchBook() {
		int targetId = 1;
		Book targetBook = bookManager.searchBook(targetId);

		assertEquals(targetId, targetBook.id);
	}
	
	@Test
	void binarySearchBook() {
		int targetId = 1;
		Book targetBook = bookManager.search_bs(targetId);

		assertEquals(targetId, targetBook.id);
	}

	@Test
	void searchUnexistBook() {
		int targetId = 11;

		assertThrows(IllegalArgumentException.class, () -> bookManager.searchBook(targetId));
	}

	@Test
	void removeBook() {
		int targetId = 1;

		bookManager.removeBook(targetId);

		assertThrows(IllegalArgumentException.class, () -> bookManager.searchBook(targetId));
	}

}
