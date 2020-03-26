package hw.lesson.microgram51.service;



import hw.lesson.microgram51.model.User;
import hw.lesson.microgram51.repository.CommentRepo;
import hw.lesson.microgram51.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final CommentRepo commentRepo;
    private final UserRepo userRepo;

    public UserService(CommentRepo commentRepo,UserRepo userRepo) {
        this.commentRepo = commentRepo;
        this.userRepo=userRepo;
    }

    public List<User> getUserList() {
        List<User> result = new ArrayList<>();
        userRepo.findAll().forEach(result::add);
        return result;
    }
    public User setUser(String name, String email, String password) {
        return userRepo.save(new User(name,email,password));
    }

    public Iterable<User> getUsers() { return userRepo.findAll(); }

    public Iterable<User> getName(String name) {
        return (Iterable<User>) userRepo.findByName(name);
    }
 /*   public boolean existsEmail(String email) {
        return userRepo.existsByEmail(email);
    }*/
}
