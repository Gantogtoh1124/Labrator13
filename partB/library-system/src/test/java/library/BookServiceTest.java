package library;

import library.model.Book;
import library.repository.BookRepository;
import library.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService(new BookRepository());
    }

    @Test
    void addBook_validData_success() {
        Book book = bookService.addBook("B001", "Clean Code", "Robert Martin", "978-0132350884");
        assertNotNull(book);
        assertEquals("Clean Code", book.getTitle());
    }

    @Test
    void addBook_emptyTitle_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            bookService.addBook("B001", "", "Author", "12345"));
    }

    @Test
    void addBook_emptyIsbn_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            bookService.addBook("B001", "Title", "Author", ""));
    }

    @Test
    void getAllBooks_returnsAllBooks() {
        bookService.addBook("B001", "Book 1", "Author 1", "111");
        bookService.addBook("B002", "Book 2", "Author 2", "222");
        assertEquals(2, bookService.getAllBooks().size());
    }

    @Test
    void searchByTitle_found() {
        bookService.addBook("B001", "Clean Code", "Robert Martin", "111");
        assertEquals(1, bookService.searchByTitle("Clean").size());
    }

    @Test
    void searchByTitle_notFound() {
        bookService.addBook("B001", "Clean Code", "Robert Martin", "111");
        assertEquals(0, bookService.searchByTitle("Python").size());
    }

    @Test
    void deleteBook_exists_returnsTrue() {
        bookService.addBook("B001", "Clean Code", "Robert Martin", "111");
        assertTrue(bookService.deleteBook("B001"));
    }

    @Test
    void deleteBook_notExists_returnsFalse() {
        assertFalse(bookService.deleteBook("B999"));
    }

    @Test
    void getBookById_exists_returnsBook() {
        bookService.addBook("B001", "Clean Code", "Robert Martin", "111");
        assertTrue(bookService.getBookById("B001").isPresent());
    }

    @Test
    void getBookById_notExists_returnsEmpty() {
        assertTrue(bookService.getBookById("B999").isEmpty());
    }
}