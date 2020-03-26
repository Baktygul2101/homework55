package hw.lesson.microgram51.controller;


import hw.lesson.microgram51.model.Comment;
import hw.lesson.microgram51.model.Post;
import hw.lesson.microgram51.model.User;
import hw.lesson.microgram51.repository.*;
import hw.lesson.microgram51.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private PostRepo publicationRepo;
    @Autowired
    private LikeRepository likeRepo;
    @Autowired
    private SubscriptionRepo subscriptionRepo;



    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getUserList();
    }

    @PostMapping("/")
    public User saveNewUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("password") String password) {
        return userService.setUser(name, email, password);
    }

    @GetMapping
    public Iterable<User> getEvents() {
        return userService.getUsers();
    }

    @GetMapping("/name/{name}")
    public User getName(@PathVariable("name") String name) {
        return (User) userService.getName(name);
    }

    @GetMapping("/checkUser/{email}")
   /* public boolean checkEmail(@PathVariable("email") String email) {
        return userService.existsEmail(email);
    }*/

    @PostMapping("/postcomment/{id}")
    public List<Comment> getPublication(@PathVariable("id") String id) {
        return commentRepo.findAllByPost(id);
    }


    @GetMapping("/watchPublication")
    public Iterable<Post> watchAllPublication() {
        return publicationRepo.findAll();
    }
}