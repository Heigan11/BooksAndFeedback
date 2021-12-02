package mainPack.BooksAndFeedback;

import com.sun.xml.bind.v2.TODO;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Access(AccessType.FIELD)
@Audited
public class Feedback {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String code;
    private String feedback;
    private String score;

    //If need to create connection to "book"
//    @ManyToOne
//    private Book book;
//    @ManyToOne
//    @JoinColumn(name = "book_code", referencedColumnName = "code")
//    public Book getBook() {
//        return this.book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }

    public Feedback() {
    }

    public Feedback(String code, String feedback, String score) {
        this.code = code;
        this.feedback = feedback;
        this.score = score;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
