package mainPack.BooksAndFeedback;

import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Audited
public class Feedback {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String code;
    private String feedback;
    private String score;

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
