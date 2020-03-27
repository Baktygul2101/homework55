package hw.lesson.microgram51.service;


import hw.lesson.microgram51.model.Post;
import hw.lesson.microgram51.model.User;
import hw.lesson.microgram51.repository.CommentRepo;
import hw.lesson.microgram51.repository.PostRepo;
import hw.lesson.microgram51.repository.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public void removePostById(String id) {
        postRepo.deleteById(id);
    }
    private User getUser() {
        // get current authenticated user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepo.findByUsername(auth.getName()).get();
    }

}
