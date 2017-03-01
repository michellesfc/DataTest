package base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/posts")
public class Controller {
    @Autowired
    PostRepository postRepository;

    @GetMapping
    public ArrayList<Post> listAll() {
        ArrayList<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(post -> posts.add(post));
        return posts;
    }

    @GetMapping("{id}")
    public Post find(@PathVariable Long id) {
        return postRepository.findOne(id);
    }
    
    /*
    @PostMapping
    public Post create(@RequestBody Post input) {
        SignedOnUser user = new SignedOnUser("Michelle","G");
        return postRepository.save(new Post(user, input.getMessage()));
    }*/


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        postRepository.delete(id);
    }

    @DeleteMapping
    public void deleteAll() {
        for (Post post : postRepository.findAll()) {
            postRepository.delete(post);
        }
    }

    @PutMapping("{id}")
    public Post update(@PathVariable Long id, @RequestBody Post input) {
        Post post = postRepository.findOne(id);
        if (post == null) {
            return null;
        } else {
            post.setMessage(input.getMessage());
            post.setLikes(input.getLikes());
            return postRepository.save(post);
        }
    }

    //this is for testing
    @RequestMapping("/makepost")
    public Post testPost() {
        SignedOnUser user = new SignedOnUser("Michelle","G");
        return postRepository.save(new Post(user, "fdsfdsgsgfdgdfgd Smihfghgfhfghgfhfghfghfgth"));
    }

    
    //this is for testing
    @RequestMapping("/makenpost")
    public Post testPost1() {
        SignedOnUser user = new SignedOnUser("Michelle","G");
        String[] tags = {"student", "pro"};
        return postRepository.save(new NewsfeedPost(user, "fdsfdfgth", tags));
    }
}

