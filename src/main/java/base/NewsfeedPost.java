package base;


import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@DiscriminatorValue("newsfeed")
public class NewsfeedPost extends Post {
    private String postContent;

    @Column(name="tags")
    private String[] tags;

    private Comment[] comments;

    public NewsfeedPost() {

    }

    public NewsfeedPost(SignedOnUser author, String message, String[] tags) {
        super(author,message);
        this.tags = tags;
    }

    public String getPostContent() {
        return postContent;
    }

    public String[] getTags() {
        return tags;
    }

    public Comment[] getComments() {
        return comments;
    }

    @Override
    public String toString() {

        return super.toString() + tags;
    }
}