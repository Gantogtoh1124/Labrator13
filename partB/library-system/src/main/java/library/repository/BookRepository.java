package library.repository;

import library.model.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository {
    private List<Book> books = new ArrayList<>();

    public void save(Book book) {
        books.add(book);
    }

    public Optional<Book> findById(String id) {
        return books.stream().filter(b -> b.getId().equals(id)).findFirst();
    }

    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    public List<Book> findByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    public boolean delete(String id) {
        return books.removeIf(b -> b.getId().equals(id));
    }
}