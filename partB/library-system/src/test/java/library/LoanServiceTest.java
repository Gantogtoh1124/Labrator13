package library;

import library.model.Loan;
import library.repository.BookRepository;
import library.repository.LoanRepository;
import library.service.BookService;
import library.service.LoanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoanServiceTest {
    private LoanService loanService;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        BookRepository bookRepo = new BookRepository();
        LoanRepository loanRepo = new LoanRepository();
        bookService = new BookService(bookRepo);
        loanService = new LoanService(loanRepo, bookRepo);
        bookService.addBook("B001", "Clean Code", "Robert Martin", "111");
    }

    @Test
    void loanBook_available_success() {
        Loan loan = loanService.loanBook("L001", "B001", "M001");
        assertNotNull(loan);
        assertFalse(loan.isReturned());
    }

    @Test
    void loanBook_alreadyLoaned_throwsException() {
        loanService.loanBook("L001", "B001", "M001");
        assertThrows(IllegalStateException.class, () ->
            loanService.loanBook("L002", "B001", "M002"));
    }

    @Test
    void loanBook_bookNotFound_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            loanService.loanBook("L001", "B999", "M001"));
    }

    @Test
    void returnBook_success() {
        loanService.loanBook("L001", "B001", "M001");
        Loan loan = loanService.returnBook("L001");
        assertTrue(loan.isReturned());
        assertNotNull(loan.getReturnDate());
    }

    @Test
    void returnBook_alreadyReturned_throwsException() {
        loanService.loanBook("L001", "B001", "M001");
        loanService.returnBook("L001");
        assertThrows(IllegalStateException.class, () ->
            loanService.returnBook("L001"));
    }

    @Test
    void returnBook_notFound_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            loanService.returnBook("L999"));
    }

    @Test
    void getActiveLoans_returnsOnlyActive() {
        loanService.loanBook("L001", "B001", "M001");
        assertEquals(1, loanService.getActiveLoans().size());
    }
}