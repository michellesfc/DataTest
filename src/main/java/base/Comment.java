package base;

import javax.persistence.*;
@Entity
@DiscriminatorValue("comment")  

public class Comment extends Post {

    @Column(name="parent")
    private Post parent;
    private String author;

}