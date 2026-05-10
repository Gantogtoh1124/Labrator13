package library.repository;

import library.model.Loan;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoanRepository {
    private List<Loan> loans = new ArrayList<>();

    public void save(Loan loan) {
        loans.add(loan);
    }

    public Optional<Loan> findById(String id) {
        return loans.stream().filter(l -> l.getId().equals(id)).findFirst();
    }

    public List<Loan> findAll() {
        return new ArrayList<>(loans);
    }

    public List<Loan> findByMemberId(String memberId) {
        List<Loan> result = new ArrayList<>();
        for (Loan l : loans) {
            if (l.getMemberId().equals(memberId)) result.add(l);
        }
        return result;
    }

    public List<Loan> findActiveLoans() {
        List<Loan> result = new ArrayList<>();
        for (Loan l : loans) {
            if (!l.isReturned()) result.add(l);
        }
        return result;
    }
}