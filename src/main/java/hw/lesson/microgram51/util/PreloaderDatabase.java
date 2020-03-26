package hw.lesson.microgram51.util;


import hw.lesson.microgram51.model.Post;
import hw.lesson.microgram51.model.User;
import hw.lesson.microgram51.repository.PostRepo;
import hw.lesson.microgram51.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@Configuration
public class PreloaderDatabase {

   @Bean
    CommandLineRunner initDatabase(UserRepo repository) {

        repository.deleteAll();

        return (args) -> Stream.of(users())
                .peek(System.out::println)
                .forEach(repository::save);
    }


    private User[] users() {
        return new User[]{
                new User("Bakulya", "bakulya@gmail.com", new BCryptPasswordEncoder().encode("123456")),
                new User("Ainura", "ainura@gmail.com", new BCryptPasswordEncoder().encode("78945kk")),
                new User("Bek", "bek@inbox.ru", new BCryptPasswordEncoder().encode("ghghg"))};
    }
  /*  CommandLineRunner initDatabase(PostRepo postRepo) {

        postRepo.deleteAll();

        return (args) -> Stream.of(posts())
                .peek(System.out::println)
                .forEach(postRepo::save);
    }

    private Post[] posts() {
        return new Post[]{
                new Post("1",null,null,"ssfsf",1),
                new Post("2",null,null,"ssfdgegdsf",1)};
    }*/
}
