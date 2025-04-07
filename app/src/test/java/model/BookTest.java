package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    void testEqualsAndHashCode() {
        Book book1 = new Book("Title", "Author");
        Book book2 = new Book("Title", "Author");
        Book book3 = new Book("Other", "Author");

        assertEquals(book1, book2);
        assertNotEquals(book1, book3);
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    void testBorrowAndReturn() {
        Book book = new Book("T", "A");
        assertTrue(book.isAvailable());
        book.borrow();
        assertFalse(book.isAvailable());
        book.returnBook();
        assertTrue(book.isAvailable());
    }

    @Test
    void testBorrowUnavailableBook_throwsException() {
        Book book = new Book("T", "A");
        book.borrow();
        assertThrows(IllegalStateException.class, book::borrow);
    }
}
