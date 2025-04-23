public class Book {
    public String title;
    public int publishedYear;
    public int numberOfPages;
    public java.util.List<String> authors;

    public Book() {}

    public Book(String title, int year, int pages, java.util.List<String> authors) {
        this.title = title;
        this.publishedYear = year;
        this.numberOfPages = pages;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "\uD83D\uDCD8 " + title + " (" + publishedYear + "), Pages: " + numberOfPages + ", Authors: " + authors;
    }
}
