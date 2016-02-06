package be.kdg.prog4.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Users {
    @Autowired
    private UserDao userDao;

    public void addUser(String username, String password) {
        User user = new User(username, password);
        userDao.create(user);
    }

    public boolean login(String username, String password) {
        User user = userDao.getUser(username);
        if (user == null) return false;
        if (!user.getPassword().equals(password)) return false;
        return true;
    }
}
