# AI Usage Report — Mini Library Management System

## 1. Юуг AI хийсэн, юуг өөрөө хийсэн?

### AI хийсэн зүйлс:
- **Part A:** ARCHITECTURE.md-н Mermaid diagram, STACK-COMPARISON.md-н 3 stack харьцуулалт,
  ADR-001 format, CLAUDE.md-н бүтэц
- **Part B:** Book.java, Member.java, Loan.java model-уудын бүтэц,
  Repository, Service layer-уудын код,
  25 unit test-ийн skeleton,
  pom.xml-н JUnit dependency тохиргоо
- **Slash commands:** review.md, test.md, docs.md, commit.md, security.md-н prompt агуулга

### Өөрөө хийсэн зүйлс:
- Төслийн сэдэв сонгох (Mini Library)
- Folder бүтэц үүсгэх, файлуудыг зөв байрлалд байрлуулах
- AI-н санал болгосон кодыг шалгаж, алдааг засах
- Commit message бичих, Git workflow дагах
- AI session log-ийг товчилж бичих
- Тест ажиллуулж үр дүнг шалгах

---

## 2. Hallucination жишээ

### Жишээ 1: Optional буруу ашиглалт
AI эхэндээ BookRepository-н findById method-д дараах кодыг санал болгосон:

```java
public Book findById(String id) {
    return books.stream().filter(b -> b.getId().equals(id)).findFirst().get();
}
```

`.get()`-г шалгалтгүй дуудсан нь NoSuchElementException үүсгэх эрсдэлтэй байсан.
`Optional<Book>` буцаахаар засаж, дуудах газарт `isPresent()` шалгалт нэмлээ.

### Жишээ 2: Mockito санал болгосон
Unit test бичихэд AI `@ExtendWith(MockitoExtension.class)` ашиглахыг санал болгосон:

```java
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @Mock
    private BookRepository bookRepository;
}
```

Гэвч `pom.xml`-д Mockito dependency байхгүй байсан тул compile алдаа гарсан.
In-memory repository ашиглах байдлаар засав.

---

## 3. Security анхаарал

### Жишээ 1: Input validation дутуу
AI эхэндээ BookService-д validation байхгүй кодыг үүсгэсэн:

```java
public Book addBook(String id, String title, String author, String isbn) {
    Book book = new Book(id, title, author, isbn);
    bookRepository.save(book);
    return book;
}
```

Title болон ISBN хоосон байвал систем хэвийн ажиллахгүй байх эрсдэлтэй.
`IllegalArgumentException` шидэх validation нэмлээ:

```java
if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
if (isbn == null || isbn.isEmpty()) throw new IllegalArgumentException("ISBN cannot be empty");
```

---

## 4. AI-аар хурдан хийсэн зүйлс

- **Boilerplate код:** Model класс, getter/setter-үүдийг маш хурдан үүсгэсэн.
  Гараар бичвэл 30+ минут зарцуулах байсан кодыг 2 минутад гаргасан.
- **Test skeleton:** 25 тестийн бүтцийг хурдан үүсгэсэн, зөвхөн логикийг шалгах л үлдсэн.
- **pom.xml тохиргоо:** JUnit 5 dependency, Surefire plugin тохиргоог алдаагүй гаргасан.
- **Commit message:** Conventional Commits форматыг дагасан мессеж хурдан гаргасан.

---

## 5. AI-аар удаан хийсэн зүйлс

- **Folder бүтэц:** AI зааврыг дагаж үүсгэхэд `partB/src/` давхар үүссэн —
  устгаж засахад цаг зарцуулсан.
- **Package нэр:** `Model` гэж том үсгээр үүссэн, `model` болгон засахад хугацаа зарцуулсан.
- **AI зөрчилтэй зөвлөгөө:** Зарим үед AI өмнөх зөвлөгөөтэй зөрчилдсөн зөвлөгөө өгсөн —
  аль нь зөв болохыг шалгахад цаг зарцуулсан.
- **Hallucination шалгах:** AI-н бүх кодыг нэг бүрчлэн шалгах шаардлагатай байсан.

---

## 6. Skill atrophy эрсдэл ба зохицуулалт

AI-тай ажиллах явцад "AI бичнэ, би хуулна" хэв маягт орох эрсдэл байсан.
Үүнийг дараах байдлаар зохицуулсан:

- **Кодыг ойлгож уншсан:** AI үүсгэсэн бүх кодыг мөр бүрчлэн уншиж,
  яагаад ингэж бичсэнийг ойлгосон.
- **Алдааг өөрөө засах:** Hallucination болон алдааг AI-д дахин асуухгүйгээр
  өөрөө олж засахыг хичээсэн.
- **AI байхгүй цаг:** Тест ажиллуулах, folder бүтэц зохион байгуулах,
  commit хийх зэрэг ажлыг AI ашиглахгүйгээр өөрөө хийсэн.
- **Тайлбарлах чадвар:** Кодын аль ч хэсгийг өөрөө тайлбарлаж чаддаг байхыг зорьсон.