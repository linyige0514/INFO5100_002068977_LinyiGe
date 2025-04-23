import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("📖 Parsing XML:");
        BookShelf xmlShelf = XMLHandler.parseXML("books.xml");
        xmlShelf.printAll();

        xmlShelf.addBook(new Book("Design Patterns", 1994, 395, List.of("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides")));
        System.out.println("\n📌 After adding one book to XML shelf:");
        xmlShelf.printAll();

        System.out.println("\n📖 Parsing JSON:");
        BookShelf jsonShelf = JSONHandler.parseJSON("books.json");
        jsonShelf.printAll();

        jsonShelf.addBook(new Book("Refactoring", 1999, 431, List.of("Martin Fowler")));
        System.out.println("\n📌 After adding one book to JSON shelf:");
        jsonShelf.printAll();
    }
}
