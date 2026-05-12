package library.service;

import library.model.Book;
import library.model.Loan;
import library.repository.BookRepository;
import library.repository.LoanRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoanService {
    private LoanRepository loanRepository;
    private BookRepository bookRepository;

    public LoanService(LoanRepository loanRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
    }

    public Loan loanBook(String loanId, String bookId, String memberId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isEmpty()) throw new IllegalArgumentException("Book not found");
        if (!book.get().isAvailable()) throw new IllegalStateException("Book is already loaned");
        book.get().setAvailable(false);
        Loan loan = new Loan(loanId, bookId, memberId);
        loanRepository.save(loan);
        return loan;
    }

    public Loan returnBook(String loanId) {
        Optional<Loan> loan = loanRepository.findById(loanId);
        if (loan.isEmpty()) throw new IllegalArgumentException("Loan not found");
        if (loan.get().isReturned()) throw new IllegalStateException("Book already returned");
        loan.get().setReturned(true);
        loan.get().setReturnDate(LocalDate.now());
        Optional<Book> book = bookRepository.findById(loan.get().getBookId());
        book.ifPresent(b -> b.setAvailable(true));
        return loan.get();
    }

    public List<Loan> getActiveLoans() {
        return loanRepository.findActiveLoans();
    }

    public List<Loan> getLoansByMember(String memberId) {
        return loanRepository.findByMemberId(memberId);
    }

    public List<Loan> getOverdueLoans() {
        List<Loan> result = new ArrayList<>();
        for (Loan l : loanRepository.findActiveLoans()) {
            if (LocalDate.now().isAfter(l.getDueDate())) {
                result.add(l);
            }
        }
        return result;
    }
}