package base;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "PostTable")
public class Post implements Serializable, Comparable<Post> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "timestamp")
    private String timestamp;
    @Column(name = "author")
    private SignedOnUser author;
    @Column(name = "message")
    private String message;
    @Column(name = "likes")
    private int likes;

    public Post() {

    }

    public Post(SignedOnUser author, String message) {
        this.author = author;
        this.message = message;
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(new Date());
        this.likes = 0;
    }

    public String getTimestamp() {
    	return timestamp;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SignedOnUser getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
	public int compareTo(Post o) {
		return timestamp.compareTo(o.getTimestamp());
	}

    @Override
    public String toString() {
        return String.format("Post[id=%d, message='%s']", id, message);
    }
}