package mainPack.BooksAndFeedback;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Access(AccessType.FIELD)
@Audited
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String code;
    private String name;
    private String description;
    private String author;

    //If need to create connection to "feedback"

//    @ElementCollection(targetClass=Feedback.class)
//    private Set<Feedback> feedbacks = new HashSet<>();
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
//    public Set<Feedback> getFeedbacks() {
//        return this.feedbacks;
//    }
//
//    public void setFeedbacks(Set<Feedback> feedbacks) {
//        this.feedbacks = feedbacks;
//    }
//
//    public void addFeedbacks(Feedback feedback) {
////        feedback.setBook(this); //If need to create connection to "book"
//        this.feedbacks.add(feedback);
//    }

    public Book() {
    }

    public Book(String code, String name, String description, String author) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.author = author;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
