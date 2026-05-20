import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class JacksonBookExample {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String json = """
                {
                  "title": "Clean Code",
                  "author": "Robert C. Martin",
                  "year": 2008,
                  "topics": ["Java", "software design", "clean coding"]
                }
                """;

        Book book = mapper.readValue(json, Book.class);
        System.out.println("Book title: " + book.title);
        System.out.println("Author: " + book.author);
        System.out.println("Topics: " + book.topics);

        String updatedJson = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(book);
        System.out.println(updatedJson);
    }

    public static class Book {
        public String title;
        public String author;
        public int year;
        public List<String> topics;
    }
}