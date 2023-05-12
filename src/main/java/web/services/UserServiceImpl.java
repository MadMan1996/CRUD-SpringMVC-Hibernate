package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.DAO.UserDao;
import web.DAO.UserDaoJPAImpl;
import web.models.User;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
       return userDao.getAllUsers();
    }
    @Transactional
    @Override
    public void removeUserById(Long id) {
        userDao.removeById(id);
    }

    @Override
    @Transactional
    public void saveNewUserProfile(User user) {
        userDao.saveNewUserProfile(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    @Transactional
    public void updateUserProfile(User user) {
        userDao.updateUserProfile(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean isUserExistsWithEmail(String email) {
        return userDao.isUserExistsWithEmail(email);
    }
}
