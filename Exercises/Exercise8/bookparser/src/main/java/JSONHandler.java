import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class JSONHandler {
    public static BookShelf parseJSON(String resourcePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream in = Main.class.getClassLoader().getResourceAsStream(resourcePath);
        var root = mapper.readTree(in);
        var booksNode = root.get("BookShelf");

        List<Book> books = mapper.readerFor(new TypeReference<List<Book>>() {}).readValue(booksNode);
        BookShelf shelf = new BookShelf();
        books.forEach(shelf::addBook);
        return shelf;
    }
}
