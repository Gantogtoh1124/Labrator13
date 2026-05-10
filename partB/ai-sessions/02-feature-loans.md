# AI Session 02 — Loan Feature

## Огноо
2026-05-10

## Зорилго
Loan model, repository, service үүсгэх

## Яриа (товч)

**Хэрэглэгч:** Зээлийн хугацааг хэрхэн тооцох вэ?

**Claude:** LocalDate.now().plusDays(14) ашиглан 14 хоногийн хугацаа тавина.
returnDate нь буцаасан үед л set хийгдэнэ.

**Хэрэглэгч:** Аль хэдийн зээлд байгаа номыг дахин зээлэхийг хэрхэн хориглох вэ?

**Claude:** Book-н available field-г шалган, false байвал IllegalStateException шидэнэ.
Зээлэхдээ available-г false, буцаахдаа true болгоно.

**Хэрэглэгч:** LoanService-д BookRepository хэрэгтэй юу?

**Claude:** Тийм, LoanService нь BookRepository-г constructor-оор авах хэрэгтэй —
номын available байдлыг өөрчлөх учраас.

## Үр дүн
- Loan.java үүсгэлээ
- LoanRepository.java үүсгэлээ
- LoanService.java үүсгэлээ
- loanBook, returnBook, getActiveLoans method үүсгэлээ

## AI-н алдаа (Hallucination)
Claude эхэндээ LoanService-д MemberRepository оруулахыг санал болгосон —
гэвч member validation энэ системд хэрэггүй байсан тул хасав.