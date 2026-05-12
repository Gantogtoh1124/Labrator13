public List<Loan> getOverdueLoans() {
    List<Loan> result = new ArrayList<>();
    for (Loan l : loanRepository.findActiveLoans()) {
        if (LocalDate.now().isAfter(l.getDueDate())) {
            result.add(l);
        }
    }
    return result;
}