package sia.tacocloud.domain.reposytory;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.domain.entyty.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
