# AI Session 01 — Book Feature

## Огноо
2026-05-10

## Зорилго
Book model, repository, service үүсгэх

## Яриа (товч)

**Хэрэглэгч:** Book.java-д ямар field хэрэгтэй вэ?

**Claude:** id, title, author, isbn, available field-уудтай байх хэрэгтэй.
available field нь номын зээлд байгаа эсэхийг илэрхийлнэ.

**Хэрэглэгч:** Repository дотор ямар method хэрэгтэй вэ?

**Claude:** save, findById, findAll, findByTitle, delete method-уудыг нэмэх хэрэгтэй.
Java List ашиглан in-memory хадгална.

**Хэрэглэгч:** BookService дотор validation хэрэгтэй юу?

**Claude:** Тийм, title болон isbn хоосон байвал IllegalArgumentException шидэх хэрэгтэй.

## Үр дүн
- Book.java үүсгэлээ
- BookRepository.java үүсгэлээ
- BookService.java үүсгэлээ
- Input validation нэмлээ

## AI-н алдаа (Hallucination)
Claude эхэндээ Optional-г буруу ашиглаж `book.get()` шалгалтгүй дуудсан —
`book.isPresent()` шалгаад дуудахаар засав.