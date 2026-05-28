public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.addBook(new Book("Clean Code", "Robert C. Martin"));
        manager.addBook(new Book("Effective Java", "Joshua Bloch"));

        System.out.println("Book list");
        for (Book book : manager.getBooks()) {
            System.out.println("- " + book);
        }

        Book result = manager.findByTitle("Clean Code");
        System.out.println("Search result: " + result);
    }
}
