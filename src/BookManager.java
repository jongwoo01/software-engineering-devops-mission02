import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookManager {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book must not be null");
        }
        books.add(book);
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

