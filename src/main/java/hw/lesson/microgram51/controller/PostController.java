package hw.lesson.microgram51.controller;


import hw.lesson.microgram51.model.Post;
import hw.lesson.microgram51.model.User;
import hw.lesson.microgram51.service.CommentService;
import hw.lesson.microgram51.service.PostService;
import hw.lesson.microgram51.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private  CommentService commentService;
    @Autowired
    private  PostService postService;

    @Autowired
    private UserService userService;



    @DeleteMapping("/")
    public void removePost( @RequestParam("id") int id) {
        userService.removePostById(id);
    }





}