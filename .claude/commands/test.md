Generate unit tests for the Mini Library Management System code I provide.

Follow the testing pyramid:
- Unit level: test individual functions in isolation
- Cover happy path, edge cases, and error cases

Required test cases to include:
- Add a book with valid data → success
- Add a book with missing fields → should throw error
- Loan a book that is available → status changes to "loaned"
- Loan a book that is already loaned → should return error
- Return a book → status changes back to "available"
- Search book by title, author, ISBN → correct results returned
- Register a member with valid data → success
- Register a member with duplicate ID → should fail

Use the same test framework already used in partB/tests/.
Each test must have: describe block, clear test name, arrange/act/assert structure.