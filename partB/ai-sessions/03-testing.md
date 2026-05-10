# AI Session 03 — Unit Testing

## Огноо
2026-05-10

## Зорилго
BookService, LoanService, MemberService-д unit test бичих

## Яриа (товч)

**Хэрэглэгч:** JUnit 5-д @BeforeEach яаж ашиглах вэ?

**Claude:** @BeforeEach annotation нь тест бүрийн өмнө ажиллана.
setUp() method дотор шинэ instance үүсгэж тест тусгаарлана.

**Хэрэглэгч:** Loan тестэд Book-г урьдчилан нэмэх хэрэгтэй юу?

**Claude:** Тийм, LoanServiceTest-н setUp() дотор тест ном нэмэх хэрэгтэй —
эс бол loanBook тест Book not found алдаа өгнө.

**Хэрэглэгч:** Edge case гэж юу юуг тестлэх вэ?

**Claude:** 
- Аль хэдийн зээлсэн номыг дахин зээлэх
- Байхгүй номыг зээлэх
- Аль хэдийн буцаасан номыг дахин буцаах
- Хоосон нэр, email-тай гишүүн нэмэх

## Үр дүн
- BookServiceTest: 10 тест
- LoanServiceTest: 7 тест
- MemberServiceTest: 8 тест
- Нийт 25 тест, бүгд pass

## AI-н алдаа (Hallucination)
Claude эхэндээ @ExtendWith(MockitoExtension.class) ашиглахыг санал болгосон —
гэвч Mockito dependency байхгүй тул in-memory repository ашиглав.