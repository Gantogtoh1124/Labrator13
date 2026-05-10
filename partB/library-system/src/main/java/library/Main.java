package library;

import library.model.*;
import library.repository.*;
import library.service.*;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepo = new BookRepository();
        MemberRepository memberRepo = new MemberRepository();
        LoanRepository loanRepo = new LoanRepository();

        BookService bookService = new BookService(bookRepo);
        MemberService memberService = new MemberService(memberRepo);
        LoanService loanService = new LoanService(loanRepo, bookRepo);

        // Ном нэмэх
        bookService.addBook("B001", "Clean Code", "Robert Martin", "978-0132350884");
        bookService.addBook("B002", "The Pragmatic Programmer", "David Thomas", "978-0135957059");

        // Гишүүн нэмэх
        memberService.addMember("M001", "Болд", "bold@email.com", "99001122");
        memberService.addMember("M002", "Сараа", "saraa@email.com", "99334455");

        // Ном зээлэх
        loanService.loanBook("L001", "B001", "M001");

        // Идэвхтэй зээлүүдийг харах
        System.out.println("Идэвхтэй зээлүүд:");
        loanService.getActiveLoans().forEach(System.out::println);

        // Ном буцаах
        loanService.returnBook("L001");

        // Бүх номыг харах
        System.out.println("\nБүх номнууд:");
        bookService.getAllBooks().forEach(System.out::println);
    }
}