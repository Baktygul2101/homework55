package hw.lesson.microgram51.service;


import hw.lesson.microgram51.model.User;
import hw.lesson.microgram51.repository.CommentRepo;
import hw.lesson.microgram51.repository.PostRepo;
import hw.lesson.microgram51.repository.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class PostService {


    private final PostRepo postRepo;
    private final CommentRepo commentRepo;
    private final UserRepo userRepo;

    public PostService(PostRepo postRepo, CommentRepo commentRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.commentRepo=commentRepo;
        this.userRepo=userRepo;
    }
    public void removeSubscriptionByIdAndEmail(int id, String email) {
        postRepo.deleteAllByIdAndUser(id, email, this.getUser());
    }
    private User getUser() {
        // get current authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepo.findByUsername(auth.getName()).get();
    }
}
