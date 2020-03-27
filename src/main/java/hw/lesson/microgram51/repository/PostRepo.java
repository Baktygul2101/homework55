package hw.lesson.microgram51.repository;



import hw.lesson.microgram51.model.Post;
import hw.lesson.microgram51.model.User;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, String> {

    public void deleteAllByIdAndUser(int id, String email, User user);
}
