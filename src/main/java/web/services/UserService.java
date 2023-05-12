package web.services;

import web.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    void removeUserById(Long id);
    void saveNewUserProfile(User user);
    User getById(Long id);

    void updateUserProfile(User user);

   Boolean isUserExistsWithEmail(String email);

}
