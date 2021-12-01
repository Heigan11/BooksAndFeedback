package mainPack.BooksAndFeedback;

import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
}