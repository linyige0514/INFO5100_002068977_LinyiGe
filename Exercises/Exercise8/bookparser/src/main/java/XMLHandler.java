import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XMLHandler {
    public static BookShelf parseXML(String resourcePath) throws Exception {
        BookShelf shelf = new BookShelf();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputStream in = Main.class.getClassLoader().getResourceAsStream(resourcePath);
        Document doc = builder.parse(in);
        doc.getDocumentElement().normalize();

        NodeList bookList = doc.getElementsByTagName("Book");

        for (int i = 0; i < bookList.getLength(); i++) {
            Element bookEl = (Element) bookList.item(i);

            String title = bookEl.getElementsByTagName("title").item(0).getTextContent();
            int year = Integer.parseInt(bookEl.getElementsByTagName("publishedYear").item(0).getTextContent());
            int pages = Integer.parseInt(bookEl.getElementsByTagName("numberOfPages").item(0).getTextContent());

            List<String> authors = new ArrayList<>();
            NodeList authorList = ((Element) bookEl.getElementsByTagName("authors").item(0)).getElementsByTagName("author");
            for (int j = 0; j < authorList.getLength(); j++) {
                authors.add(authorList.item(j).getTextContent());
            }

            shelf.addBook(new Book(title, year, pages, authors));
        }

        return shelf;
    }
}
