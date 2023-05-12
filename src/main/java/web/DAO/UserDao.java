package web.DAO;

import org.springframework.ui.Model;
import web.models.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> getAllUsers();
    void removeById(Long id);
    void saveNewUserProfile(User user);
    User getById(Long id);
    Boolean isUserExistsWithEmail(String email);
    void updateUserProfile(User user);



}
