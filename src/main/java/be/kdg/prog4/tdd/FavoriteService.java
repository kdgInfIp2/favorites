package be.kdg.prog4.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FavoriteService {
    @Autowired
    private Users users;
    private Map<String, List<String>> favorites;

    public FavoriteService() {
        System.out.println("constructie FavoriteService");
        this.favorites = new HashMap<>();
    }

    public boolean checkLogin(String username, String password) {
        System.out.println("checkLogin()");
        System.out.println("\tusername = " + username);
        System.out.println("\tpassword = " + password);
        return isRoot(username, password) || users.login(username, password);
    }

    public boolean isRoot(String username, String password) {
        return ("root".equals(username) && "rootpasswd".equals(password));
    }

    public void addUser(String root, String rootpasswd, String username, String password) {
        if (!isRoot(root, rootpasswd)) return;
        System.out.println("addUser()");
        System.out.println("\troot = " + root);
        System.out.println("\trootpasswd = " + rootpasswd);
        System.out.println("\tusername = " + username);
        System.out.println("\tpassword = " + password);
        users.addUser(username, password);
    }

    public void addFavorite(String username, String password, String favorite) {
        if (!checkLogin(username, password)) return;
        List<String> f = favorites.get(username);
        if (f == null) {
            f = new ArrayList<>();
        }
        f.add(favorite);
        favorites.put(username, f);
    }

    public List<String> getFavorites(String username, String password) {
        if (users.login(username, password)) {
            List<String> result = favorites.get(username);
            if (result == null) return new ArrayList<>();
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    public void removeFavorite(String username, String password, String favorite) {
        if (!users.login(username, password)) return;
        favorites.get(username).remove(favorite);
    }
}
