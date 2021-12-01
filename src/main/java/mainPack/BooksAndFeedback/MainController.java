package mainPack.BooksAndFeedback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MainController {

    @Autowired
    BookRepository bookRepository;

    @PostMapping(path="/book")
    public @ResponseBody String addNewBook(@RequestBody String msg) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Book n = objectMapper.readValue(msg, Book.class);
        bookRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}