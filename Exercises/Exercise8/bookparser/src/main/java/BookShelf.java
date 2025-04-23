import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    public List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void printAll() {
        books.forEach(System.out::println);
    }
}
