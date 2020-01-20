package stream.spliterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;

public class Book {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{name=" + name + ", author=" + author + '}';
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        Collections.addAll(books,
                new Book("aa", "AA"),
                new Book("bb", "BB"),
                new Book("cc", "CC"),
                new Book("dd", "DD"));
        Spliterator<Book> spliterator = books.spliterator();
        while (spliterator.tryAdvance(b -> b.setName("*" + b.getName() + "*"))) ;
        books.forEach(System.out::println);
    }
}