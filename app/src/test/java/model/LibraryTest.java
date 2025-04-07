package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book book;

    @BeforeEach
    void setUp() {
        library = new Library();
        book = new Book("Test Book", "Author");
        library.addBook(book);
    }

    @Test
    void testAddReader() {
        Reader reader = new Reader("Anna");
        library.addReader(reader);
        assertTrue(library.getReaders().contains(reader));
    }

    @Test
    void testRemoveReader() {
        Reader reader = new Reader("Bohdan");
        library.addReader(reader);
        library.removeReader(reader);
        assertFalse(library.getReaders().contains(reader));
    }

    @Test
    void testBorrowAndReturnBook() {
        assertTrue(book.isAvailable());
        library.borrowBook(book);
        assertFalse(book.isAvailable());

        library.returnBook(book);
        assertTrue(book.isAvailable());
    }

    @Test
    void testBorrowAlreadyBorrowedBook_throwsException() {
        library.borrowBook(book);
        assertThrows(IllegalStateException.class, () -> library.borrowBook(book));
    }
}
