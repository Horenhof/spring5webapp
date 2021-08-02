package guru.springframework.spring5webapp.repos;

import guru.springframework.spring5webapp.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}
