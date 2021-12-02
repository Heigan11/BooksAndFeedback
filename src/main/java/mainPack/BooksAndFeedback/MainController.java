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

    @Autowired
    FeedbackRepository feedbackRepository;

    @PostMapping(path="/book")
    public @ResponseBody String addNewBook(@RequestBody String msg) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Book n = objectMapper.readValue(msg, Book.class);
        n.setCode(String.valueOf(n.hashCode()));
        bookRepository.save(n);
        return "Saved";
    }

    @PostMapping(path="/feedback")
    public @ResponseBody String addNewFeedback(@RequestBody String msg) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Feedback n = objectMapper.readValue(msg, Feedback.class);
        if (bookRepository.findByCode(n.getCode()) != null)
            feedbackRepository.save(n);
        return "Saved";
    }

    //If need to create connection to "book"
//    @PostMapping(path="/feedback")
//    public @ResponseBody String addNewFeedback(@RequestBody String msg) throws JsonProcessingException {
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        Feedback n = objectMapper.readValue(msg, Feedback.class);
//        if (bookRepository.findByCode(n.getCode()) != null) {
//            bookRepository.findByCode(n.getCode()).addFeedbacks(n);
//            feedbackRepository.save(n);
//        }
//        return "Saved";
//    }

    @GetMapping(path="/books")
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(path="/feedbacks")
    public @ResponseBody Iterable<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }
}