package library.service;

import library.model.Book;
import library.repository.BookRepository;
import java.util.List;
import java.util.Optional;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(String id, String title, String author, String isbn) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
        if (isbn == null || isbn.isEmpty()) throw new IllegalArgumentException("ISBN cannot be empty");
        Book book = new Book(id, title, author, isbn);
        bookRepository.save(book);
        return book;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public List<Book> searchByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public boolean deleteBook(String id) {
        return bookRepository.delete(id);
    }
}