package web.DAO;

import org.springframework.ui.Model;
import web.models.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    void removeById(Long id);
    void saveNewUserProfile(User user);
    User getById(Long id);
    void updateUserProfile(User user);



}
