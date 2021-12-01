package mainPack.BooksAndFeedback;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findByCode(String code);
}