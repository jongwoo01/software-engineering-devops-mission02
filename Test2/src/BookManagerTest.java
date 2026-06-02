import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class BookManagerTest {
    @Test
    void addAndFindBookByTitle() {
        BookManager manager = new BookManager();
        manager.addBook(new Book("Clean Code", "Robert C. Martin"));

        assertEquals(1, manager.getBooks().size());
        Book found = manager.findByTitle("Clean Code");
        assertNotNull(found);
        assertEquals("Robert C. Martin", found.getAuthor());
    }
}
