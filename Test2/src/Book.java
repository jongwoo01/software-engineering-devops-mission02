public class Book {
    private final String title;
    private final String author;
    private final int publicationYear;

    public Book(String title, String author) {
        this(title, author, 0);
    }

    public Book(String title, String author, int publicationYear) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("author must not be blank");
        }
        if (publicationYear < 0) {
            throw new IllegalArgumentException("publication year must not be negative");
        }

        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        if (publicationYear == 0) {
            return title + " by " + author;
        }
        return title + " by " + author + " (" + publicationYear + ")";
    }
}