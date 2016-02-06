package be.kdg.prog4.tddOld;

import org.springframework.beans.factory.annotation.Autowired;

public class FavoriteService {
    @Autowired
    private Users users;

    public boolean checkLogin(String username, String password) {
        return users.login(username, password);
    }
}
