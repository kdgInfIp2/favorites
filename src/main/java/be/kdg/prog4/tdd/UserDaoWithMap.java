package be.kdg.prog4.tdd;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDaoWithMap implements UserDao {
    private Map<String, User> users;

    public UserDaoWithMap() {
        this.users = new HashMap<>();
    }

    @Override
    public void create(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public User getUser(String username) {
        return users.get(username);
    }
}
