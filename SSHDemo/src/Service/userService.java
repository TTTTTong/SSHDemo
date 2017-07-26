package Service;

import Entity.user;

import java.util.List;

public interface userService {
    void save(user user);
    user getUser(String user);
    void delete(int id);
    void update(user user);
    user findById(int id);
    List<?> findAll(String username);
}
