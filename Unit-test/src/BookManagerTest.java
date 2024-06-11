import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerTest {
	BookManager bookManager;

	@BeforeEach
	void setUp() throws Exception {
		bookManager = new BookManager();
	}

	@Test
	void addBook() {
		Book book = new Book(1, "자바 기초", "Jane", 2021);

		bookManager.addBook(book);

		assertEquals(bookManager.books.size(), 1);
		assertEquals(book.id, bookManager.books.get(0).id);
	}

	@Test
	void addExistBook() {
		Book book1 = new Book(1, "자바 기초", "Jane", 2021);

		bookManager.addBook(book1);

		assertThrows(IllegalArgumentException.class, () -> bookManager.addBook(book1));

	}

	@Test
	void searchBook() {
		Book book1 = new Book(1, "자바 기초", "Jane", 2021);

		bookManager.addBook(book1);

		int targetId = 1;
		Book targetBook = bookManager.searchBook(targetId);

		assertEquals(book1.id, targetBook.id);
	}

	@Test
	void searchUnexistBook() {
		int targetId = 1;

		assertThrows(IllegalArgumentException.class, () -> bookManager.searchBook(targetId));
	}

	@Test
	void removeBook() {
		Book book1 = new Book(1, "자바 기초", "Jane", 2021);
		int targetId = 1;

		bookManager.addBook(book1);

		bookManager.removeBook(targetId);

		assertEquals(bookManager.books.size(), 0);
		assertThrows(IllegalArgumentException.class, () -> bookManager.searchBook(targetId));
	}

}
