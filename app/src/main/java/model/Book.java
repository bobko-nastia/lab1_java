package model;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private boolean isAvailable = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void borrow() {
        if (!isAvailable) throw new IllegalStateException("Book already borrowed.");
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}