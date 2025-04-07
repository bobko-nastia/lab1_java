package util;

import com.google.gson.Gson;
import model.Book;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryIOTest {

    @Test
    void testExportAndImportBooks() throws IOException {
        List<Book> books = List.of(
                new Book("B", "A"),
                new Book("A", "B")
        );

        String filePath = "test_books.json";
        LibraryIO.exportBooks(books, filePath);

        List<Book> imported = LibraryIO.importBooks(filePath);

        assertEquals(2, imported.size());
        assertEquals("A", imported.get(0).getTitle()); // бо має бути відсортовано
    }

    @Test
    void testImportFromNonExistingFile_returnsEmptyList() throws IOException {
        List<Book> books = LibraryIO.importBooks("non_existent.json");
        assertTrue(books.isEmpty());
    }
}
