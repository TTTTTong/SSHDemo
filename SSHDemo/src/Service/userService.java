package Service;

import Entity.user;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface userService {
    void save(user user);
    user getUser(String user);
    void delete(int id);
    void update(user user);
    user findById(int id);
    List<user> findAll();
}
