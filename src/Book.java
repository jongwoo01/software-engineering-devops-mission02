public class Book {
    private final String title;
    private final String author;

    public Book(String title, String author) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("author must not be blank");
        }
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

