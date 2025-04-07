package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Book;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LibraryIO {
    private static final Gson gson = new Gson();

    public static void exportBooks(List<Book> books, String filePath) throws IOException {
        List<Book> sorted = books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .toList();

        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(sorted, writer);
        }
    }

    public static List<Book> importBooks(String filePath) throws IOException {
        try (Reader reader = new FileReader(filePath)) {
            Type listType = new TypeToken<List<Book>>(){}.getType();
            return gson.fromJson(reader, listType);
        } catch (FileNotFoundException e) {
            return Collections.emptyList();
        }
    }
}