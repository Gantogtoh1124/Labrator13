package library.model;

import java.time.LocalDate;

public class Loan {
    private String id;
    private String bookId;
    private String memberId;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean returned;

    public Loan(String id, String bookId, String memberId) {
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.loanDate = LocalDate.now();
        this.dueDate = LocalDate.now().plusDays(14);
        this.returned = false;
    }

    public String getId() { return id; }
    public String getBookId() { return bookId; }
    public String getMemberId() { return memberId; }
    public LocalDate getLoanDate() { return loanDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public boolean isReturned() { return returned; }

    public void setReturned(boolean returned) { this.returned = returned; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    @Override
    public String toString() {
        return "Loan{id='" + id + "', bookId='" + bookId + "', memberId='" + memberId + "', dueDate=" + dueDate + ", returned=" + returned + "}";
    }
}