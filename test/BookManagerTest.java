public class BookManagerTest {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.addBook(new Book("Clean Code", "Robert C. Martin"));

        if (manager.getBooks().size() != 1) {
            throw new AssertionError("book count should be 1");
        }

        Book found = manager.findByTitle("clean code");
        if (found == null) {
            throw new AssertionError("book should be found by title");
        }

        if (!"Robert C. Martin".equals(found.getAuthor())) {
            throw new AssertionError("author should match");
        }

        System.out.println("BookManagerTest passed");
    }
}

