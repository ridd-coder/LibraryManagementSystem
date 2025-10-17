public class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;

    public Book(int id, String title, String author, boolean issued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = issued;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return issued; }

    @Override
    public String toString() {
        return String.format("ID: %d | %s by %s | %s", 
                             id, title, author, (issued ? "Issued" : "Available"));
    }
}
