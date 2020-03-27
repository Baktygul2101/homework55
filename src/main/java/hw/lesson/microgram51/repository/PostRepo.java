package hw.lesson.microgram51.repository;



import hw.lesson.microgram51.model.Post;
import hw.lesson.microgram51.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepo extends CrudRepository<Post, String> {

    public Optional<Post> findById(String id);
    public void deleteById(int id);
}
